package com.jjq.funda.conf;

import com.jjq.funda.support.RestTemplateLogInterceptor;
import com.jjq.funda.util.ListUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author jjq
 * @version 1.0
 * @date 2021/12/3
 * @desc
 */
@Configuration
public class RestTemplateConfiguration {

    private static List<ClientHttpRequestInterceptor> interceptorList;

    static {
        ClientHttpRequestInterceptor interceptor = new RestTemplateLogInterceptor();
        interceptorList = ListUtils.newArrayList(interceptor);
    }

    @Bean
    public RestTemplate restTemplate(OkHttp3ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters().forEach(httpMessageConverter -> {
            if (httpMessageConverter instanceof StringHttpMessageConverter) {
                StringHttpMessageConverter messageConverter = (StringHttpMessageConverter) httpMessageConverter;
                messageConverter.setDefaultCharset(StandardCharsets.UTF_8);
            }
        });
        restTemplate.setInterceptors(interceptorList);
        return restTemplate;
    }

    @Bean
    public OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory() {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();
        factory.setConnectTimeout(30000);
        factory.setReadTimeout(30000);
        factory.setWriteTimeout(30000);
        return factory;
    }
}
