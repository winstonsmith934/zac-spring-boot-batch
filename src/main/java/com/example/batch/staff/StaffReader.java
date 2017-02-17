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
//public class StaffReader implements ItemReader<TransactionStaff> {
//    private static final Logger log = LoggerFactory.getLogger(StaffReader.class);
//
//    @Override
//    public TransactionStaff read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        FlatFileItemReader<TransactionStaff> reader = new FlatFileItemReader<TransactionStaff>();
//        return reader;
//    }
//
//
//
////    @Autowired
////    public ItemReader<TransactionStaff> reader() {
////
////        FlatFileItemReader<TransactionStaff> reader = new FlatFileItemReader<TransactionStaff>();
////        reader.setResource(new ClassPathResource("staff-data.csv"));
////        reader.setLineMapper(new DefaultLineMapper<TransactionStaff>() {
////            {
////                setLineTokenizer(new DelimitedLineTokenizer() {
////                    {
////                        setNames(new String[] { "staffCode", "staffName", "staffNameKana", "staffDivisionId", "staffMailaddress",
////                                "staffStatus" });
////                    }
////                });
////                setFieldSetMapper(new BeanWrapperFieldSetMapper<TransactionStaff>() {
////                    {
////                        setTargetType(TransactionStaff.class);
////                    }
////                });
////            }
////        });
////
////        return reader;
////    }
//
////    @Override
////    public TransactionStaff read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
////        FlatFileItemReader<TransactionStaff> reader = new FlatFileItemReader<TransactionStaff>();
////        reader.setResource(new ClassPathResource("staff-data.csv"));
////        reader.setLineMapper(new DefaultLineMapper<TransactionStaff>() {
////            {
////                setLineTokenizer(new DelimitedLineTokenizer() {
////                    {
////                        setNames(new String[] { "staffCode", "staffName", "staffNameKana", "staffDivisionId", "staffMailaddress",
////                                "staffStatus" });
////                    }
////                });
////                setFieldSetMapper(new BeanWrapperFieldSetMapper<TransactionStaff>() {
////                    {
////                        setTargetType(TransactionStaff.class);
////                    }
////                });
////            }
////        });
////
////        return reader;
////    }
//
//}