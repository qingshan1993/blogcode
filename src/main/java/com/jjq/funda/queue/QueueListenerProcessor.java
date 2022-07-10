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
import java.util.Set;
import java.util.concurrent.Delayed;


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
                        Delayed pollResult = queue.poll();
                        if (pollResult == null) {
                            continue;
                        }
                        log.info("消息监听消费成功,pollResult:{}", JsonUtils.toJsonString(pollResult));
                        for (Map.Entry<Method, QueueListener> entry : methodAnnotationsCache.entrySet()) {
                            String msgType = entry.getValue().msgType();
                            Class paramType = entry.getValue().paramType();
                            int retry = entry.getValue().retry();
                            if (pollResult instanceof QueueMsg) {
                                log.info("::::::::::::pollResult instanceof QueueMsg :true");
                                QueueMsg queueMsg = (QueueMsg) pollResult;
                                log.info("::::::::msgType:{},queueMsg.getMsgType():{}", msgType, queueMsg.getMsgType());
                                log.info("::::::::retry:{}, queueMsg.getRetried():{}", retry, queueMsg.getRetried());
                                if (msgType.equals(queueMsg.getMsgType()) && retry > queueMsg.getRetried()) {
                                    Object bean = applicationContext.getBean(entry.getKey().getDeclaringClass());
                                    log.info("消息监听消费成功,调用反射执行方法:{}, DeclaringClass:{}", JsonUtils.toJsonString(pollResult), entry.getKey().getDeclaringClass());
                                    ReflectionUtils.invokeMethod(entry.getKey(), bean, pollResult);
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
