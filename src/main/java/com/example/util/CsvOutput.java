package com.example.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.BeansException;

public class CsvOutput {
    private static final Logger log = LoggerFactory.getLogger(CsvOutput.class);
    public static final String REPORT_FILE_NAME = "deails";

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws Exception, BeansException {

        String outputPath = "C:/csv";
        List csvList = new ArrayList();
        csvList.add("aaa, bbb, ccc, ddd, eee\r\n");
        csvList.add("111, 222, 333, 444, 555\r\n");
        RepeatStatus res = generateReportDetailFile(outputPath, csvList);
        log.debug("" + res);
    }

    @SuppressWarnings("rawtypes")
    public static RepeatStatus generateReportDetailFile(String path, List list) throws Exception {

//        File outputPath = new File(path);
//        if (!outputPath.exists()) {
//            outputPath.mkdir();
//        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fullPath = path + File.separator + REPORT_FILE_NAME + "_" + simpleDateFormat.format(new Date()) + ".csv";

        File detailsFile = new File(fullPath);

//        if (detailsFile.exists() || detailsFile.isDirectory()) {
//            log.error("Could not found report data from previous steps.");
//            return RepeatStatus.FINISHED;
//        }

        FileUtils.touch(detailsFile);
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sbd.append(list.get(i));
        }
        sbd.append("\r\n");
        FileUtils.writeStringToFile(detailsFile, sbd.toString());

        return RepeatStatus.FINISHED;
    }
}
