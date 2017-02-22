package com.example.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: zac
 */

public class BaiduBaikeClientCardBean {

    @JSONField(name = "key")
    private String key;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "value")
    private String value;

    @JSONField(name = "format")
    private String format;
    
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}