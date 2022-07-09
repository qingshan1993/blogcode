package com.jjq.funda.util;

import com.google.common.collect.Maps;
import com.jjq.funda.exception.FundaException;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc javascript脚本操作类
 */
public class JsUtils {

    private static final ScriptEngineManager scriptEngineManager;
    private static final ScriptEngine javaScript;

    static {
        scriptEngineManager = new ScriptEngineManager();
        javaScript = scriptEngineManager.getEngineByName("javascript");
    }

    /**
     *
     * @param js string of js
     * @param varName variable name
     * @return
     */
    public static Map<String, Object> parseJjObject(String js, String varName) {
        try {
            javaScript.eval(js);
        } catch (ScriptException e) {
            throw new FundaException("parse js error, js:"+ js + "\n ex: " +e.getMessage());
        }
        ScriptObjectMirror objectMirror = (ScriptObjectMirror)javaScript.get(varName);
        Set<Map.Entry<String, Object>> set = objectMirror.entrySet();
        return set.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
