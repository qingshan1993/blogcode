package com.jjq.funda.util;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/9
 * @desc js脚本
 */
@Slf4j
public class JsUtilsTest {



    @Test
    public void jsObjectParseTest () throws ScriptException {
        String strResult = "var apidata={ content:\"\n" +
                "净值日期\t单位净值\t累计净值\t日增长率\t申购状态\t赎回状态\t分红送配\n" +
                "2022-07-08\t2.7840\t3.0160\t0.80%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-07\t2.7620\t2.9940\t-2.06%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-06\t2.8200\t3.0520\t-1.30%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-05\t2.8570\t3.0890\t0.99%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-04\t2.8290\t3.0610\t4.78%\t限制大额申购\t开放赎回\t\n" +
                "2022-07-01\t2.7000\t2.9320\t-1.10%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-30\t2.7300\t2.9620\t2.82%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-29\t2.6550\t2.8870\t-0.15%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-28\t2.6590\t2.8910\t-0.41%\t限制大额申购\t开放赎回\t\n" +
                "2022-06-27\t2.6700\t2.9020\t1.17%\t限制大额申购\t开放赎回\t\n" +
                "\",records:1395,pages:140,curpage:1};";
        Map<String, Object> apiData = JsUtils.parseJjObject(strResult, "apidata");
        log.info("result:{}", JsonUtils.toJsonString(apiData));
    }

    private final String BASE_PACKAGE = "com.example.demo";
    private final String RESOURCE_PATTERN = "/**/*.class";

    @Test
    public void test() {
        Map<String, Class> handlerMap = new HashMap<String, Class>();

        //spring工具类，可以获取指定路径下的全部类
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(BASE_PACKAGE) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            //MetadataReader 的工厂类
            MetadataReaderFactory readerfactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                //用于读取类信息
                MetadataReader reader = readerfactory.getMetadataReader(resource);
                //扫描到的class
                String classname = reader.getClassMetadata().getClassName();
                Class<?> clazz = Class.forName(classname);
                //判断是否有指定主解

                //if (anno != null) {
                    //将注解中的类型值作为key，对应的类作为 value
                    //handlerMap.put(classname, clazz);
                //}
            }
        } catch (IOException | ClassNotFoundException e) {
        }
    }
}
