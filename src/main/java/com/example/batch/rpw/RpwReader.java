package com.example.batch.rpw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

public class RpwReader implements ItemReader<String> {
    private static final Logger log = LoggerFactory.getLogger(RpwReader.class);

    @Override
    public String read() throws Exception {
        String out = "hello ";
        log.info("read (" + out + ")");

        return out;
    }
}