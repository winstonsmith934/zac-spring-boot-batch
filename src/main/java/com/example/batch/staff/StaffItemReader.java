//package com.example.batch.staff;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.NonTransientResourceException;
//import org.springframework.batch.item.ParseException;
//import org.springframework.batch.item.UnexpectedInputException;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.stereotype.Component;
//
//import com.example.entity.TransactionStaff;
//
//@Component
//public class StaffItemReader implements ItemReader<TransactionStaff> {
//    private static final Logger log = LoggerFactory.getLogger(StaffItemReader.class);
//
//    @Override
//    public TransactionStaff read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        FlatFileItemReader<TransactionStaff> reader = new FlatFileItemReader<TransactionStaff>();
//        // TODO Auto-generated method stub
//        return (TransactionStaff) reader;
//    }
//}