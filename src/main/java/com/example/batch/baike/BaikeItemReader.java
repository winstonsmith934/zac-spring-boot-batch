package com.example.batch.baike;

import java.net.URI;

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
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.bean.BaiduBaikeClientBean;

@Component("BaikeItemReader")
public class BaikeItemReader implements ItemReader<BaiduBaikeClientBean> {
    private static final Logger log = LoggerFactory.getLogger(BaikeItemReader.class);
    private int count;

    @Override
    public BaiduBaikeClientBean read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        BaiduBaikeClientBean baiduBaikeClientBean = null;
        if (count < 1) {
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
                baiduBaikeClientBean = JSON.parseObject(resBody, BaiduBaikeClientBean.class);
            }
            count++;
        }
        return baiduBaikeClientBean;
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
        return UriBuilder.fromUri("http://baike.baidu.com/api/openapi").build();

    }
}