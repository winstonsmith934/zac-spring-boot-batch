package com.example.batch.staff;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.TransactionStaff;

@Component("StaffItemWriter")
public class StaffItemWriter implements ItemWriter<TransactionStaff> {
    private static final Logger log = LoggerFactory.getLogger(StaffItemWriter.class);

    @Autowired
    private DataSource dataSource;
    
	@Override
	public void write(List<? extends TransactionStaff> items) throws Exception {
		for (int i =0; i < items.size(); i++){
			log.debug(items.get(i).getStaffName());
		}
	}
}
