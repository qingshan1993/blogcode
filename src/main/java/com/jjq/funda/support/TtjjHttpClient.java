package com.jjq.funda.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author jjq
 * @version 1.0
 * @date 2022/7/5
 * @desc  天天基金请求
 */
@Component
public class TtjjHttpClient extends HttpClient {

    @Autowired
    public TtjjHttpClient(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected HttpHeaders buildHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "APPCODE e03569fcca3845c2ba3731f740aa6d49");
        return httpHeaders;
    }
}
