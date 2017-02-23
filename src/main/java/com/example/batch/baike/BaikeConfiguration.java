package com.example.batch.baike;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.bean.BaiduBaikeClientBean;
import com.example.bean.BaiduBaikeClientCardBean;
import com.example.listener.JobCompletionNotificationListener;

@Configuration
@EnableBatchProcessing
public class BaikeConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Autowired
    @Qualifier("baikeStep")
    private Step baikeStep;
    
    @Bean
    public JobExecutionListener baikeListener() {
        return new JobCompletionNotificationListener();
    }
    
    @Bean
    public Job baikeJob() {
        return jobBuilderFactory.get("baikeJob")
                .incrementer(new RunIdIncrementer())
                .listener(baikeListener())
                .flow(baikeStep)
                .end()
                .build();
    }
    
    @Bean
    public Step baikeStep(BaikeItemReader reader, BaikeItemProcessor processor, BaikeItemWriter writer) {
        return stepBuilderFactory.get("baikeStep")
                .<BaiduBaikeClientBean, BaiduBaikeClientCardBean> chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
    


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

