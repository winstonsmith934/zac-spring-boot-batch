package com.example.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;

public class CsvOutput {
    public static final String REPORT_FILE_NAME = "deails";

    public static void main(String[] args) throws Exception, BeansException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String fullPath = "C:" + File.separator + REPORT_FILE_NAME + "_" + simpleDateFormat.format(new Date()) + ".csv";
        generateReportDetailFile(fullPath);
    }

    private static void generateReportDetailFile(String path) throws Exception {
        File detailsFile = new File(path);

        FileUtils.touch(detailsFile);
        StringBuilder sbd = new StringBuilder();
        sbd.append("aaa, bbb, ccc, ddd, eee\r\n");
        sbd.append("\r\n");
        FileUtils.writeStringToFile(detailsFile, sbd.toString());
    }
}
