package com.jjq.funda.datacenter.spider;

import com.jjq.funda.util.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.nodes.Document;

/**
 * @author jiangjunqing
 * @date 2021/11/15
 * @description: 上下文对象
 * @version:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpiderContext {

    /**
     * 网页链接
     */
    private String url;

    /**
     * 基金代码
     */
    private String fundCode;

    /**
     * 基金名称
     */
    private String fundName;

    /**
     * html文档
     */
    private Document document;

    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }
}
