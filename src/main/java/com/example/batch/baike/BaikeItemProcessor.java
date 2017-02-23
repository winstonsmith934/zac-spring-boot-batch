package com.example.batch.baike;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.bean.BaiduBaikeClientBean;
import com.example.bean.BaiduBaikeClientCardBean;

@Component("BaikeItemProcessor")
public class BaikeItemProcessor implements ItemProcessor<BaiduBaikeClientBean, BaiduBaikeClientCardBean> {
    private static final Logger log = LoggerFactory.getLogger(BaikeItemProcessor.class);

    @Value("${zac.timezone}")
    private String zacTimezone;

    @SuppressWarnings("null")
    @Override
    public BaiduBaikeClientCardBean process(BaiduBaikeClientBean item) throws Exception {
//        List<BaiduBaikeClientCardBean> cardBeanList = JSON.parseArray(item.getCard(), BaiduBaikeClientCardBean.class);
        List<BaiduBaikeClientCardBean> CardBeanList = JSON.parseArray(item.getCard(),BaiduBaikeClientCardBean.class);
        
        BaiduBaikeClientCardBean cardBean = CardBeanList.get(0);
//        cardBean.setFormat("1");
//        cardBean.setKey("2");
//        cardBean.setName("3");
//        cardBean.setValue("4");
//        for (BaiduBaikeClientCardBean cardObject : cardBeanList) {
//            try {
//                System.err.println(cardObject.getKey());
//                cardBean.setKey(cardObject.getKey());
//                System.err.println(cardObject.getName());
//                System.err.println(cardObject.getValue());
//                System.err.println(cardObject.getFormat());
//                System.err.println("------------------------------");
//            } catch (Exception e) {
//                log.error("Error", e);
//                continue;
//            }
//        }

        return cardBean;
    }
}
