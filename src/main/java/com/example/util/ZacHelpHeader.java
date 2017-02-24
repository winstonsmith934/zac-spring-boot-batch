package com.example.util;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class ZacHelpHeader {
    public static void main(String[] args) {
        Options opt = new Options();
        opt.addOption(Option.builder("host").desc("IP/HOST").numberOfArgs(1).build());
        opt.addOption(Option.builder("port").desc("服务器的端口信息").build());
        opt.addOption(Option.builder("user").desc("服务器用户名").build());
        opt.addOption(Option.builder("pwd").desc("服务器密码").build());
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("put.sh {local|dev|test|prod}", opt);
    }
}
