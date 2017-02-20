package com.example.batch.staff;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.entity.TransactionStaff;


@Configuration
@EnableBatchProcessing
public class StaffConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

   
//    @Bean
//    public StaffReader staffReader() {
//        return new StaffReader();
//    }
    
//    @Bean
//    public ItemReader<TransactionStaff> reader() {
//        FlatFileItemReader<TransactionStaff> reader = new FlatFileItemReader<TransactionStaff>();
//        reader.setResource(new ClassPathResource("staff-data.csv"));
//        reader.setLineMapper(new DefaultLineMapper<TransactionStaff>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[] { "staffCode", "staffName", "staffNameKana", "staffDivisionId", "staffMailaddress", "staffStatus" });
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<TransactionStaff>() {{
//                setTargetType(TransactionStaff.class);
//            }});
//        }});
//        return reader;
//    }
    
    @Bean
    public StaffItemProcessor staffProcessor() {
        return new StaffItemProcessor();
    }
    
    @Bean
    public JdbcBatchItemWriter<TransactionStaff> staffWriter() {
        JdbcBatchItemWriter<TransactionStaff> writer = new JdbcBatchItemWriter<TransactionStaff>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<TransactionStaff>());
        writer.setSql("INSERT INTO t_staff (staff_code, staff_name, staff_name_kana, staff_division_id, staff_mailaddress, staff_status) VALUES (:staffCode, :staffName, :staffNameKana, :staffDivisionId, :staffMailaddress, :staffStatus)");
        writer.setDataSource(dataSource);
        return writer;
    }
    
//    @Bean
//    public Job importUserJob() {
//        return jobBuilderFactory.get("importStaffJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(staffStep())
//                .end()
//                .build();
//    }

    @Autowired
    @Qualifier("staffStep")
    private Step staffStep;
    
    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importStaffJob")
                .incrementer(new RunIdIncrementer())
                .flow(staffStep)
                .end()
                .build();
    }
    
    @Bean
    public Step staffStep(StaffMyBatisPagingItemReader reader) {
        return stepBuilderFactory.get("staffStep")
                .<TransactionStaff, TransactionStaff> chunk(10)
                .reader(reader)
                .processor(staffProcessor())
                .writer(staffWriter())
                .build();
    }
    
//    @Bean
//    public Step staffStep() {
//        return stepBuilderFactory.get("staffStep")
//                .<TransactionStaff, TransactionStaff> chunk(10)
//                .reader(reader())
//                .processor(staffProcessor())
//                .writer(staffWriter())
//                .build();
//    }
    // end::jobstep[]

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
//    @Bean
//    public StaffWriter staffWriter() {
//        return new StaffWriter();
//    }
   

//    @Bean
//    public JobExecutionListener listener() {
//        return new JobCompletionNotificationListener();
//    }

//    @Bean
//    public Step staffStep() {
//        return stepBuilderFactory
//                .get("staffStep")
//                .<TransactionStaff, TransactionStaff> chunk(10)
//                .reader(staffReader())
//                .processor(staffProcessor())
//                .writer(staffWriter())
//                .build();
//    }

//    @Bean
//    public Job staffJob() {
//        return jobBuilderFactory.get("staffJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener())
//                .flow(staffStep())
//                .end()
//                .build();
//    }
}

