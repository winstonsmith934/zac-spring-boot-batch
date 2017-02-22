package com.example.util;

import java.net.URI;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.example.bean.BaiduBaikeClientBean;
import com.example.bean.BaiduBaikeClientCardBean;

/**
 * @Author: zac
 */

public class BaiduBaikeClient {
    private static final Logger log = LoggerFactory.getLogger(BaiduBaikeClient.class);
    // http://apistore.baidu.com/
    // http://developer.yahoo.co.jp/appendix/
    // https://map.yahooapis.jp/placeinfo/V1/get
    public static void main(String[] args) {
        ClientConfig cc = new ClientConfig();
        Client client = ClientBuilder.newClient(cc);
        WebTarget target = client.target(getBaseURI()).path("BaikeLemmaCardApi");
        Form form = fillUpForm();

        Response res = target.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

        if (res.getStatus() != 200) {
            log.debug("==========");
        } else {
            String resBody = res.readEntity(String.class);
            System.err.println(resBody);

            BaiduBaikeClientBean zacClientBean = JSON.parseObject(resBody, BaiduBaikeClientBean.class);
            System.err.println(zacClientBean.getId());
            System.err.println(zacClientBean.getNewLemmaId());
            System.err.println(zacClientBean.getSubLemmaId());
            System.err.println(zacClientBean.getCard());
            
            List<BaiduBaikeClientCardBean> baiduBaikeClientCardBean = JSON.parseArray(zacClientBean.getCard(),BaiduBaikeClientCardBean.class);
            for(BaiduBaikeClientCardBean cardObject : baiduBaikeClientCardBean){
                try {
                    System.err.println(cardObject.getKey());
                    System.err.println(cardObject.getName());
                    System.err.println(cardObject.getValue());
                    System.err.println(cardObject.getFormat());
                    System.err.println("------------------------------");
                }catch (Exception e) {
                    log.error("Error",e);
                    continue;
                }  
            }
        }

    }

    private static Form fillUpForm() {
        Form form = new Form();
        form.param("scope", "103");
        form.param("format", "json");
        form.param("appid", "379020");
        form.param("bk_key", "China");
        form.param("bk_length", "600");
        return form;
    }

    private static URI getBaseURI() {
//        return UriBuilder.fromUri("http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=China&bk_length=600").build();
        return UriBuilder.fromUri("http://baike.baidu.com/api/openapi").build();

    }
}