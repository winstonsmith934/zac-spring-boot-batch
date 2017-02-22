package com.example.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @Author: zac
 */

public class BaiduBaikeClientBean {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "subLemmaId")
    private String subLemmaId;

    @JSONField(name = "newLemmaId")
    private String newLemmaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubLemmaId() {
        return subLemmaId;
    }

    public void setSubLemmaId(String subLemmaId) {
        this.subLemmaId = subLemmaId;
    }

    public String getNewLemmaId() {
        return newLemmaId;
    }

    public void setNewLemmaId(String newLemmaId) {
        this.newLemmaId = newLemmaId;
    }
}