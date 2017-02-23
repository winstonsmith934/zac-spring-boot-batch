package com.example.batch.baike;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.bean.BaiduBaikeClientCardBean;



@Component("BaikeItemWriter")
public class BaikeItemWriter implements ItemWriter<BaiduBaikeClientCardBean> {
    private static final Logger log = LoggerFactory.getLogger(BaikeItemWriter.class);
    
	@Override
	public void write(List<? extends BaiduBaikeClientCardBean> items) throws Exception {
		for (int i =0; i < items.size(); i++){
			log.debug(items.get(i).getFormat());
			log.debug(items.get(i).getKey());
			log.debug(items.get(i).getName());
            log.debug(items.get(i).getValue());
		}
		// zacTODO reader 无法停止取得数据
		System.exit(0);
	}
}
