package com.example.batch.staff;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.TransactionStaff;

@Component
public class StaffMyBatisPagingItemReader extends MyBatisPagingItemReader<TransactionStaff> {
    private static final Logger log = LoggerFactory.getLogger(StaffMyBatisPagingItemReader.class);
    
    @Autowired
    public StaffMyBatisPagingItemReader (SqlSessionFactoryBean sqlSessionFactoryBean) throws Exception{
        this.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        this.setQueryId("selectByExample");
        this.setPageSize(100);
    }
    
}