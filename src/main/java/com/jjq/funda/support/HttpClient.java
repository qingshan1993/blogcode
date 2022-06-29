package com.jjq.funda.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/12/5
 * @desc
 */
@Component
public class HttpClient extends AbstractHttpClient {

    public HttpClient() {
    }

    @Autowired
    public HttpClient(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected HttpHeaders buildHttpHeaders() {
        return new HttpHeaders();
    }
}
