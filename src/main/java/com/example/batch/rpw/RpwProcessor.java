package com.example.batch.rpw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class RpwProcessor implements ItemProcessor<String, String> {
    private static final Logger log = LoggerFactory.getLogger(RpwProcessor.class);

    @Override
    public String process(final String in) throws Exception {
        String out = in + ", world!";
        log.info("process (" + in + ") ,(" + out + ")");

        return out;
    }

}
