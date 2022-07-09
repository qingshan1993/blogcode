package com.jjq.funda.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.script.ScriptException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc
 */
@Slf4j
public class LocalDateTimeUtilsTest {

    @Test
    public void parseTest () throws ScriptException {
        LocalDateTime parse = LocalDateTimeUtils.parse("2022-06-27");
        log.info("result:{}", JsonUtils.toJsonString(parse));
    }
}
