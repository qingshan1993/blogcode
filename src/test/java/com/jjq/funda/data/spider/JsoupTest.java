package com.jjq.funda.data.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */
public class JsoupTest {

    @Test
    public void parseTest() throws IOException {
        File file = ResourceUtils.getFile("classpath:html/012414.html");
        Document document = Jsoup.parse(file, StandardCharsets.UTF_8.name());
        Elements elementsByClass = document.getElementsByClass("poptableWrap singleStyleHeight01");
        for (Element element : elementsByClass) {
            Elements tbody = element.getElementsByTag("tr");
            System.out.println(tbody);
        }
    }


}
