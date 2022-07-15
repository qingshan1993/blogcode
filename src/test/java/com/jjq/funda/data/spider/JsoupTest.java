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
import java.util.List;

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

    @Test
    public void parseTableTest() throws IOException {

        String htmlFragment ="<table class='w782 comm lsjz'><thead><tr><th class='first'>净值 日期</th><th>单位净值</th><th>累计净值</th><th>日增长率</th><th>申购状态</th><th>赎回状态</th><th class='tor last'>分红送配</th></tr></thead><tbody><tr><td>2022-07-13</td><td class='tor bold'>2.6600</td><td class='tor bold'>2.8920</td><td class='tor bold grn'>-0.04%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-12</td><td class='tor bold'>2.6610</td><td class='tor bold'>2.8930</td><td class='tor bold grn'>-3.06%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-11</td><td class='tor bold'>2.7450</td><td class='tor bold'>2.9770</td><td class='tor bold grn'>-1.40%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-08</td><td class='tor bold'>2.7840</td><td class='tor bold'>3.0160</td><td class='tor bold red'>0.80%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-07</td><td class='tor bold'>2.7620</td><td class='tor bold'>2.9940</td><td class='tor bold grn'>-2.06%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-06</td><td class='tor bold'>2.8200</td><td class='tor bold'>3.0520</td><td class='tor bold grn'>-1.30%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-05</td><td class='tor bold'>2.8570</td><td class='tor bold'>3.0890</td><td class='tor bold red'>0.99%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-04</td><td class='tor bold'>2.8290</td><td class='tor bold'>3.0610</td><td class='tor bold red'>4.78%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-07-01</td><td class='tor bold'>2.7000</td><td class='tor bold'>2.9320</td><td class='tor bold grn'>-1.10%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-30</td><td class='tor bold'>2.7300</td><td class='tor bold'>2.9620</td><td class='tor bold red'>2.82%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-29</td><td class='tor bold'>2.6550</td><td class='tor bold'>2.8870</td><td class='tor bold grn'>-0.15%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-28</td><td class='tor bold'>2.6590</td><td class='tor bold'>2.8910</td><td class='tor bold grn'>-0.41%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-27</td><td class='tor bold'>2.6700</td><td class='tor bold'>2.9020</td><td class='tor bold red'>1.17%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-24</td><td class='tor bold'>2.6390</td><td class='tor bold'>2.8710</td><td class='tor bold red'>3.57%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-23</td><td class='tor bold'>2.5480</td><td class='tor bold'>2.7800</td><td class='tor bold red'>0.08%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-22</td><td class='tor bold'>2.5460</td><td class='tor bold'>2.7780</td><td class='tor bold grn'>-1.32%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-21</td><td class='tor bold'>2.5800</td><td class='tor bold'>2.8120</td><td class='tor bold grn'>-0.39%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-20</td><td class='tor bold'>2.5900</td><td class='tor bold'>2.8220</td><td class='tor bold red'>0.97%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-17</td><td class='tor bold'>2.5650</td><td class='tor bold'>2.7970</td><td class='tor bold red'>2.76%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr><tr><td>2022-06-16</td><td class='tor bold'>2.4960</td><td class='tor bold'>2.7280</td><td class='tor bold red'>1.46%</td><td>限制大额申购</td><td>开放赎回</td><td class='red unbold'></td></tr></tbody></table>";
        Document document = Jsoup.parse(htmlFragment);
        Elements trs = document.select("tr");
        Object[] eles = trs.toArray();
        for (Object ele : eles) {
            Element element = (Element) ele;
            String[] thArr = (String[]) element.select("th").eachText().toArray();
            System.out.println();

        }

        List<String> strings = trs.eachText();
        System.out.println();
    }


}
