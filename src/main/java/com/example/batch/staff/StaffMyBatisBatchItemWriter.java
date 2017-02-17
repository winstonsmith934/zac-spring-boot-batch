//package com.example.batch.staff;
//
//import org.mybatis.spring.batch.MyBatisBatchItemWriter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.entity.TransactionStaff;
//
//@Component
//public class StaffMyBatisBatchItemWriter extends MyBatisBatchItemWriter<TransactionStaff> {
//    private static final Logger log = LoggerFactory.getLogger(StaffMyBatisBatchItemWriter.class);
//    
//    @Autowired
//    public StaffMyBatisBatchItemWriter(TransactionStaff transactionStaff) throws Exception{
//        this.setSqlSessionFactory(transactionStaff.getClass());
//    }
//}
