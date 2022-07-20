package com.jjq.funda.util;

import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.ListIterator;

/**
 * @author qingshan1993
 * @version 1.0
 * @date 2022/7/14
 * @desc jsoup html 解析工具类
 */
public class JsoupUtils {

    /**
     * 解析表格html,返回表格内容
     * @param htmlFragment html片段
     * @return
     */
    public static List<List<String>> parseTable(String htmlFragment) {
        List<List<String>> result = Lists.newArrayList();
        Document document = Jsoup.parseBodyFragment(htmlFragment);
        Elements trs = document.select("tr");
        Object[] objects = trs.toArray();
        for (int i = 1; i < objects.length; i++) {
            Object ele = objects[i];
            Element element = (Element) ele;
            ListIterator<Element> listIterator = element.select("td").listIterator();
            List<String> innerResult = Lists.newArrayList();
            while (listIterator.hasNext()) {
                innerResult.add(listIterator.next().text());
            }
            result.add(innerResult);
        }
        return result;
    }

    /**
     * 解析表格html,返回表格内容
     * @param htmlFragment html片段
     * @return
     */
    public static boolean isValidHtmlFragment(String htmlFragment) {
        return htmlFragment.startsWith("<table");
    }
}
