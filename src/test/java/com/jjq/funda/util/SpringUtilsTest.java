package com.jjq.funda.util;

import com.jjq.funda.model.QueueMsg;
import com.jjq.funda.model.anno.QueueListener;
import com.jjq.funda.model.param.DataCollectParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.Delayed;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/10
 * @desc
 */
@Slf4j
public class SpringUtilsTest {

    @Test
    public void findMethodAnnotations() {
        Map<Method, QueueListener> methodAnnotations = SpringUtils.findMethodAnnotations(QueueListener.class);
        log.info("result:{}", JsonUtils.toJsonString(methodAnnotations));
    }

    @Test
    public void instanceOfTest() {
        DataCollectParam dataCollectParam = new DataCollectParam();
        System.out.println("dataCollectParam instanceof Delayed:" + (dataCollectParam instanceof Delayed));
        System.out.println("dataCollectParam instanceof QueueMsg:" + (dataCollectParam instanceof QueueMsg));
    }
}
