package com.jjq.funda.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/10
 * @desc spring工具类
 */
@Slf4j
public class SpringUtils {

    private final static String BASE_PACKAGE = "com.jjq.funda";
    private final static String RESOURCE_PATTERN = "/**/*.class";


    /**
     * 找到项目中带有 指定泛型的左右方法
     * @param annotationType
     * @param <A>
     * @return
     */
    public  static <A extends Annotation> Map<Method, A> findMethodAnnotations(Class<A> annotationType) {
        Map<Method, A> result = new HashMap<>(8);
        //spring工具类，可以获取指定路径下的全部类
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(BASE_PACKAGE) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            //MetadataReader 的工厂类
            MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                //用于读取类信息
                MetadataReader reader = readerFactory.getMetadataReader(resource);
                //扫描到的class
                String classname = reader.getClassMetadata().getClassName();
                Class<?> clazz = Class.forName(classname);
                //判断是否有指定主解
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    A annotation = method.getAnnotation(annotationType);
                    if (annotation != null) {
                        result.put(method, annotation);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            log.error("findMethodAnnotations has error", e);
        }

        return result;
    }




}
