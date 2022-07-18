package com.jjq.funda.util;

import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.util.List;

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
    public static List<String[]> parseTable(String htmlFragment) {
        List<String[]> result = Lists.newArrayList();
        Document document = Jsoup.parseBodyFragment(htmlFragment);
        Elements trs = document.select("tr");
        Object[] objects = trs.toArray();
        for (Object ele : objects) {
            Element element = (Element) ele;
            String[] thArr = (String[]) element.select("th").eachText().toArray();
            result.add(thArr);
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
