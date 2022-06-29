package com.jjq.funda.support;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/12/3
 * @desc  restTemplate request and response log
 */
@Slf4j
public class RestTemplateLogInterceptor implements ClientHttpRequestInterceptor {


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        String methodValue = request.getMethodValue();
        URI uri = request.getURI();

        log.info("headers:{}, methodValue:{}, uri:{}, body:{}", headers, methodValue, uri, new String(body));
        ClientHttpResponse response = execution.execute(request, body);

        String statusText = response.getStatusText();
        InputStream responseBody = response.getBody();
        log.info("statusText:{}", statusText );
        return response;
    }
}
