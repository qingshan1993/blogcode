package com.jjq.funda.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/11/6
 * @desc
 */
@Component
public class WeChatHttpClient extends HttpClient {

    @Autowired
    public WeChatHttpClient(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    protected HttpHeaders buildHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "APPCODE e03569fcca3845c2ba3731f740aa6d49");
        return httpHeaders;
    }
}
