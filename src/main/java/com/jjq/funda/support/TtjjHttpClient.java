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

//    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//Accept-Encoding: gzip, deflate, br
//Accept-Language: zh-CN,zh;q=0.9
//Cache-Control: max-age=0
//Connection: keep-alive
//Cookie: qgqp_b_id=86c1baa5216dcbeb610e10269f4ca613; st_pvi=24657545995558; st_inirUrl=https%3A%2F%2Fwww.baidu.com%2Flink; st_sp=2022-07-07%2021%3A59%3A21; ASP.NET_SessionId=p3lfhvh2qvccczxxmxc2pn30
//Host: fundf10.eastmoney.com
//sec-ch-ua: "Chromium";v="94", "Google Chrome";v="94", ";Not A Brand";v="99"
//sec-ch-ua-mobile: ?0
//sec-ch-ua-platform: "Windows"
//Sec-Fetch-Dest: document
//Sec-Fetch-Mode: navigate
//Sec-Fetch-Site: none
//Sec-Fetch-User: ?1
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36

    @Override
    protected HttpHeaders buildHttpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//        httpHeaders.set("Accept-Encoding", "gzip, deflate, br");
//        httpHeaders.set("Accept-Language", "zh-CN,zh;q=0.9");
//        httpHeaders.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36");

        return httpHeaders;
    }


}
