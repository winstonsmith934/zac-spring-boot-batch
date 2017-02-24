package com.example.batch.rpw;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.listener.JobCompletionNotificationListener;

// http://snona.hatenablog.com/entry/2016/02/25/043141
@Configuration
@EnableBatchProcessing
public class RpwBatchConfig {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean(name="RpwReader")
    public RpwReader reader() {
        return new RpwReader();
    }

    @Bean(name="RpwProcessor")
    public RpwProcessor processor() {
        return new RpwProcessor();
    }

    @Bean(name="RpwWriter")
    public RpwWriter writer() {
        return new RpwWriter();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionNotificationListener();
    }

    @Bean
    public Job rpwJob(Step rpwStep) {
        return jobs.get("rpwJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(rpwStep())
                .end()
                .build();
    }

    @Bean(name = "rpwStep")
    public Step rpwStep() {
        return steps.get("rpwStep")
                .<String, String> chunk(1)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
}
