package com.example.batch.staff;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

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
        this.setQueryId("com.example.dao.TransactionStaffMapper.selectByPrimaryKey");
        this.setParameterValues(getParameterValues());
        this.setPageSize(100);
    }
    private Map<String, Object> getParameterValues() throws ParseException {
        Map<String, Object> parameterValues = new HashMap<String, Object>();
        parameterValues.put("staffId", 5);
        return parameterValues;
    }
}