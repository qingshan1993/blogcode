package com.jjq.funda.queue;


import com.jjq.funda.model.QueueMsg;
import com.jjq.funda.model.anno.QueueListener;
import com.jjq.funda.util.JsonUtils;
import com.jjq.funda.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc 队列监听处理
 */
@Slf4j
@Component
public class QueueListenerProcessor {

    private static Map<Method, QueueListener> methodAnnotationsCache;

    @Autowired
    private List<DataCollectQueue> queueList;

    @Autowired
    private ApplicationContext applicationContext;


    @PostConstruct
    public void init() {
        //搜索整个项目中,找到带有@QueueListener注解的方法
        methodAnnotationsCache = SpringUtils.findMethodAnnotations(QueueListener.class);
        //开启监听
        listen();
    }

    public void listen() {
        Thread thread = new Thread(() -> {
            if (methodAnnotationsCache != null && methodAnnotationsCache.size() >0) {
                log.info(":::::::::::启动后台守护线程,监听队列消息:::::::::::::::::::");
                while (true) {
                    for (DataCollectQueue queue : queueList) {
                        Object pollResult = queue.poll();
                        if (pollResult == null) {
                            continue;
                        }
                        for (Map.Entry<Method, QueueListener> entry : methodAnnotationsCache.entrySet()) {
                            String msgType = entry.getValue().msgType();
                            int retry = entry.getValue().retry();
                            if (pollResult instanceof QueueMsg) {
                                QueueMsg queueMsg = (QueueMsg) pollResult;
                                if (msgType.equals(queueMsg.getMsgType()) && retry > queueMsg.getRetried()) {
                                    try {
                                        Object bean = applicationContext.getBean(entry.getKey().getDeclaringClass());
                                        ReflectionUtils.invokeMethod(entry.getKey(), bean, pollResult);
                                    } catch (Exception e) {
                                        ((QueueMsg) pollResult).setRetried(((QueueMsg) pollResult).getRetried() + 1);
                                        queue.put(pollResult, 10L * ((QueueMsg) pollResult).getRetried(), TimeUnit.MILLISECONDS);
                                    }
                                } else {
                                    log.error("消息消费失败,已重试{}次,消息内容:{}",retry, JsonUtils.toJsonString(pollResult));
                                }
                            }
                        }
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }


}
