package com.example.rpw;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class RpwWriter implements ItemWriter<String> {
    private static final Logger log = LoggerFactory.getLogger(RpwWriter.class);

    @Override
    public void write(List<? extends String> items) throws Exception {
        for (String string : items) {
            log.info("write (" + string + ")");
        }
    }
}
