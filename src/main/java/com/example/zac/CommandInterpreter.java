package com.example.zac;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandInterpreter {
    @Autowired
    private JobRegistry jobRegistry;
    @Autowired
    private JobLauncher jobLauncher;

    private Options opts;
    private CommandLine cl;
    private List<String> argList;
    private static final Logger log = LoggerFactory.getLogger(CommandInterpreter.class);
    
    public CommandInterpreter() {
        opts = new Options();        
        opts.addOption("d", "date", true, "The timestamp of the job in ISO 8601 date format. Give this parameter to resume a previous job, or by default system will use current timestamp to start a new job.");
        opts.addOption("t", "timestamp", true, "The UTC timestamp in milliseconds. Give this parameter to resume a previous job, or by default system will use current timestamp to start a new job.");
        opts.addOption("f", "file", true, "The name of the file to process. Shortcut for -Pfile=<filename>. Will be passed as JobParameter to the job.");
        opts.addOption("h", "help", false, "Print Help (this message) and exit");
        opts.addOption(Option.builder("P")
                                .hasArgs()
                                .valueSeparator('=')
                                .desc("Pass other custom JobParameter to the job")
                                .build());
    }
    
    
    public int run (String[] args) {
        try {
            log.debug("CLI runner framework start.");
            DefaultParser parser = new DefaultParser();
            cl = parser.parse(opts, args);
            argList = cl.getArgList();        
    
            if (cl.hasOption('h')) {
                return showUsage(null);
            }
            if (argList.size() < 2) {
                return showUsage("Not enough arguments!");
            }
            int exitCode;
            switch ((String)argList.get(0)) {
            case "job" : exitCode = runJob(); break;
            default: return showUsage("Invalid command:" + argList.get(0));
            }
            log.debug("CLI runner normal finish");
            return exitCode;
        } catch (ParseException e) {
            log.error("Running from CLI with parameter [" + args + "] parse failed:" + e.getMessage(), e);
            return showUsage(e.getMessage());
        }
    }
    
    private int runJob() throws ParseException {
        log.debug("Registered jobs: " + jobRegistry.getJobNames());
        String jobName = (String)argList.get(1);
        log.debug("Job to launch: " + jobName);
        
        // 方法1
//        try {
//            Job job = jobRegistry.getJob(jobName);
//
//            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
//
//            JobExecution execution = jobLauncher.run(job, jobParameters);
//            
//            System.out.println("Exit Status : " + execution.getStatus());
//            
//        } catch (NoSuchJobException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JobExecutionAlreadyRunningException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JobRestartException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JobInstanceAlreadyCompleteException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (JobParametersInvalidException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        // 方法2
        JobParametersBuilder paramBuilder = new JobParametersBuilder();
        try {
            Job job = jobRegistry.getJob(jobName);
            if (cl.hasOption('t')) { // Give a specific time tag
                paramBuilder.addDate("date", parseTimestamp(cl.getOptionValue('t')));
            } else if (cl.hasOption('d')) { // Give a specific date time
                paramBuilder.addDate("date", parseDate(cl.getOptionValue('d')));
            } else { // By Default, set current time to JobParameter so that job can run multiple times.
                paramBuilder.addDate("date", new Date());
            }
            if (cl.hasOption('f')) {
                paramBuilder.addString("file", cl.getOptionValue('f'));
            }
            for(Entry<Object, Object> entry : cl.getOptionProperties("P").entrySet()) {
                String key = (String)entry.getKey();
                String value = (String)entry.getValue();
                paramBuilder.addString(key, value);
            }
            jobLauncher.run(job, paramBuilder.toJobParameters());
        } catch (org.springframework.batch.core.launch.NoSuchJobException e) {
            return showUsage("Job does not exist with name: " + jobName);
        } catch (org.springframework.batch.core.repository.JobRestartException e) {
            return showUsage("Job " + jobName + " JobRestartException: " + paramBuilder.toJobParameters());
        } catch (org.springframework.batch.core.repository.JobExecutionAlreadyRunningException e) {
            return showUsage("Job " + jobName + " is already running with this parameter set: " + paramBuilder.toJobParameters());
        } catch (org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException e) {
            return showUsage("Job " + jobName + " is already finished with this parameter set: " + paramBuilder.toJobParameters());
        } catch (org.springframework.batch.core.JobParametersInvalidException e) {
            return showUsage("Invalid parameters: "  + paramBuilder.toJobParameters());
        }
        // 方法2
//        JobParametersBuilder paramBuilder = new JobParametersBuilder();
//        try {
//            Job job = jobRegistry.getJob(jobName);
//            if (cl.hasOption('t')) { // Give a specific time tag
//                paramBuilder.addDate("date", new Date());
//            }
//            if (cl.hasOption('f')) {
//                paramBuilder.addString("file", cl.getOptionValue('f'));
//            }
//            for(Entry<Object, Object> entry : cl.getOptionProperties("P").entrySet()) {
//                String key = (String)entry.getKey();
//                String value = (String)entry.getValue();
//                paramBuilder.addString(key, value);
//            }
//            
//            jobLauncher.run(job, paramBuilder.toJobParameters());
//            
//        } catch (org.springframework.batch.core.launch.NoSuchJobException e) {
//            return showUsage("Job does not exist with name: " + jobName);
//        } catch (org.springframework.batch.core.repository.JobRestartException e) {
//            return showUsage("Job " + jobName + " JobRestartException: " + paramBuilder.toJobParameters());
//        } catch (org.springframework.batch.core.repository.JobExecutionAlreadyRunningException e) {
//            return showUsage("Job " + jobName + " is already running with this parameter set: " + paramBuilder.toJobParameters());
//        } catch (org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException e) {
//            return showUsage("Job " + jobName + " is already finished with this parameter set: " + paramBuilder.toJobParameters());
//        } catch (org.springframework.batch.core.JobParametersInvalidException e) {
//            return showUsage("Invalid parameters: "  + paramBuilder.toJobParameters());
//        }
        return 0;
    }
    
    private Date parseTimestamp(String tsStr) throws ParseException {
        try {
            log.debug("Timestamp to parse:" + tsStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(Long.parseLong(tsStr));
            return calendar.getTime();
        } catch (java.lang.NumberFormatException e) {
            throw new ParseException("Invalid timestamp:" + tsStr);
        }
    }
    
    private Date parseDate(String dateStr) throws ParseException {
        try {
            log.debug("Date string to parse:" + dateStr);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
            return format.parse(dateStr);
        } catch (java.text.ParseException e) {
            throw new ParseException("Invalid date string:" + dateStr 
                        + "\nThis -d option takes ISO 8601 date format like: 2010-01-02T03:04:05h.678+09");
        }
    }
    private int showUsage(String errorMsg) {
        int errorCode;
        if (errorMsg == null) {
            errorCode = 0;
        } else {
            errorCode = -1;
            log.error(errorMsg + " Please check the usage below!");
        }
        String appFileName = "application.jar";
        try {
            String path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            String decodedPath = URLDecoder.decode(path, "UTF-8");
            appFileName = new File(decodedPath).getName();
        } catch (java.io.UnsupportedEncodingException e) {
            log.warn("Wierd, this should never happen", e);
        }
        
        // http://blog.csdn.net/mxj588love/article/details/54928480
        String cmdLineSyntax = "java -jar " + appFileName + " Command parms [Options]";
        String helpHeader = "Valid commands are:\n" + " job jobNameToLunch [Options]\n" + " service [start|stop|restart]\n";
        String helpFooter = "Copyright(c) zac.com 2017";
        HelpFormatter hf = new HelpFormatter();
        hf.printHelp(cmdLineSyntax, helpHeader, opts, helpFooter);
        
        return errorCode;
    }
}
