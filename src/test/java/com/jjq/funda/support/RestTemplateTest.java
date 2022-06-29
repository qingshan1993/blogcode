package com.jjq.funda.support;

import com.jjq.funda.FundaApplicationTests;
import com.jjq.funda.db.entity.Fund;
import com.jjq.funda.util.MapUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/12/3
 * @desc
 */
@Slf4j
public class RestTemplateTest extends FundaApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpClient httpClient;

    String url = "http://fund.eastmoney.com/001678.html";
    /**
     *
     *
     */
    @Test
    public void restTemplateTest() {
        HashMap<String, Object> map = MapUtils.newHashMap();
        map.put("fundCode", "001678");
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class, map);
        log.info("forEntity:{}", forEntity);
    }

    @Test
    public void exchange() {
        String url ="https://ali-stock.showapi.com/stock-block-list";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, new HttpHeaders());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("fundCode", "001678")
                .queryParam("fundCode", "001678");
        URI uri = builder.build().encode().toUri();
        ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        System.out.println(exchange.getBody());

    }

    @Test
    public void exchange1() {
        String url ="https://coding.imooc.com/class/{1}.html?utm_term=SpringBoot&utm_campaign=SEM&utm_medium=28&_channel_track_key=vI6Iblqh&utm_source=szjineng2";
        HttpEntity<String> httpEntity = new HttpEntity<>(null, new HttpHeaders());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("bd_vid", "8413775722685595173");
        URI uri = builder.build().encode().toUri();
        ResponseEntity<String> exchange = restTemplate.exchange(uri.toString(), HttpMethod.GET, httpEntity, String.class, "485");
        System.out.println(exchange.getBody());

    }

    @Test
    public void httpClientTest() {
        String url = "https://ali-stock.showapi.com/stock-block-list";
        Fund fund = new Fund();
        fund.setFundCode("001678");
        String result = httpClient.get(url, fund, String.class);
        System.out.println(result);
    }


    @Autowired
    private WeChatHttpClient weChatHttpClient;

    @Test
    public void weChatHttpClientTest() {
        String url = "https://ali-stock.showapi.com/stock-block-list";
        Fund fund = new Fund();
        fund.setFundCode("001678");
        String result = weChatHttpClient.get(url, fund, String.class);
        System.out.println(result);
    }

}
