package com.jjq.funda.support;

import com.jjq.funda.util.JsonUtils;
import com.jjq.funda.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */
public abstract class AbstractHttpClient {

    private RestTemplate restTemplate;


    public AbstractHttpClient() {
    }


    public AbstractHttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T get(String url, Class<T> responseType){
        return restTemplate.getForEntity(url, responseType).getBody();
    }


    public <T> T get(String url, Object queryParam, Class<T> responseType){
        HttpEntity<String> httpEntity = new HttpEntity<>(null, buildHttpHeaders());
        return restTemplate.exchange(buildQueryParamsUri(url, queryParam), HttpMethod.GET, httpEntity, responseType).getBody();
    }


    private static URI buildQueryParamsUri(String url, Object queryParam) {
        Map<String, Object> map = MapUtils.fromObject(queryParam);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        map.forEach(builder::queryParam);
        return builder.build().encode().toUri();
    }



    protected abstract HttpHeaders buildHttpHeaders();


}
