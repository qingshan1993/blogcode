package com.jjq.funda.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc
 */
@Slf4j
public class LocalDateTimeUtilsTest {

    @Test
    public void parseTest (){
        LocalDateTime parse = LocalDateTimeUtils.parse("2022-06-27");
        log.info("result:{}", JsonUtils.toJsonString(parse));
    }

    @Test
    public void timeUnitTest () {
        long currentTimeMillis = System.currentTimeMillis();
        long l = currentTimeMillis + TimeUnit.MINUTES.toMinutes(10);
        log.info("\nresult:{},\ncurrentTimeMillis:{}", l, currentTimeMillis);
    }


}
