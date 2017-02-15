package com.zac.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.StepRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.util.ZacLogUtil;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( classes = {ZacTestBatchConfiguration.class,} )
public class BatchTest {
    private static final Logger log = LoggerFactory.getLogger(BatchTest.class);
    private String className = this.getClass().getName();

    
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobRegistry jobRegistry;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private StepRunner stepRunner;
    
    @ClassRule
    public static WireMockClassRule wireMockRule;
    
    @Rule
    public WireMockClassRule instanceRule = wireMockRule;
    
    // test DB
    private static EmbeddedDatabase testDataBase;
    private static ScriptRunner scriptRunner;
    @SuppressWarnings("unused")
    private static ExecutionContext executionContext;
    @SuppressWarnings("unused")
    private static Pattern dbBean2StrPattern;
    
    private static JobLauncherTestUtils jobLauncherTestUtils;
    @SuppressWarnings("unused")
    private static JobParameters jobParameters;
    
    private static User user;
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    public static BatchTestData batchTestDatas;
    
    
    // Test Parameter
    String userId01 = "1";
    List<User> userTblListBefore;
    List<User> userTblListAfter;
    
    private SimpleDateFormat sdf;
    @Value("${zac.timezone}")
    private String zacTimeZone;    
    @Value("${date.format.short}")
    private String dateFormatShort;
    
    @Value("${zac.timezone}")
    private String zacTimezone;
    
    static int cnt = 0;
    
    @BeforeClass
    public static void execBeforeClass() throws SQLException{
        cnt = cnt + 1;
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String logFormatStr = ZacLogUtil.logFormat("execBeforeClass?????", methodName);
        log.debug(logFormatStr + "*** START ***" + cnt);
        
        testDataBase = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .continueOnError(true)
                .addScript("classpath:SQLs/zac_db_schema.sql")
                .ignoreFailedDrops(true)
                .build();
        wireMockRule = new WireMockClassRule(18088);

        scriptRunner = new ScriptRunner(testDataBase.getConnection());
        
        executionContext = new ExecutionContext();
        
        dbBean2StrPattern = Pattern.compile("^\\S+@\\w+\\[(.+)\\]$", Pattern.CASE_INSENSITIVE);
        
        log.debug(logFormatStr + "*** END ***" + cnt);
    }
    
    @SuppressWarnings("static-access")
    @Before
    public void execBefore() throws Exception{
        cnt = cnt + 1;
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String logFormatStr = ZacLogUtil.logFormat(className, methodName);
        log.debug(logFormatStr + "*** START ***" + cnt);
        
        log.debug(zacTimezone);
        
        if(this.sdf == null){
            this.sdf = new SimpleDateFormat(this.dateFormatShort);
            this.sdf.setTimeZone(TimeZone.getTimeZone(this.zacTimeZone));
        }
        
        if (null == jobLauncherTestUtils) {
            jobLauncherTestUtils = new JobLauncherTestUtils();
            jobLauncherTestUtils.setJobRepository(jobRepository);
            jobLauncherTestUtils.setJobLauncher(jobLauncher);
            jobLauncherTestUtils.setJob(jobRegistry.getJob("testJob04"));
        }
        
        JobParametersBuilder jpb = new JobParametersBuilder();
        jobParameters = jpb.addString("testCd", "999")
                            .addString("UUID", UUID.randomUUID().toString())
                            .toJobParameters();
        
        if(null == user){
            user = new User();
        }

        batchTestDatas.cleanTables(scriptRunner);
        
        log.debug(logFormatStr + "*** END ***" + cnt);
    }

    @SuppressWarnings("static-access")
    @Test
    public void test01() throws Exception{
        cnt = cnt + 1;
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String logFormatStr = ZacLogUtil.logFormat(className, methodName);
        log.debug(logFormatStr + "*** START ***" + cnt);
        
        batchTestDatas.prepareData(scriptRunner,"SQLs/test01.sql");
                
        User userReturn = userMapper.selectByPrimaryKey(1);
//        String firstName = userReturn.getFirstName();
        
        assertEquals("19780219", this.sdf.format(userReturn.getCreateTime()));
        
        String testDayPlus3 = BatchTestData.getDay(3);
        String time ="00:00:00";
        batchTestDatas.updateUpdate_time(scriptRunner, testDayPlus3, time, userId01);
        
        
        
//        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
        
//        MyBatisPagingItemReader<User> userReader = new MyBatisPagingItemReader<User>();
//        userReader.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
//        userReader.setQueryId(CBT_SELECT_CONDITION);
//        userReader.setPageSize(10);
//        userReader.
        
        log.debug(logFormatStr + "*** END ***" + cnt);
    }
    @Test
    public void test02() throws Exception{
        cnt = cnt + 1;
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String logFormatStr = ZacLogUtil.logFormat(className, methodName);
        log.debug(logFormatStr + "*** START ***" + cnt);
        
        
        log.debug(logFormatStr + "*** END ***" + cnt);
    }


    @After
    public void execAfter() {
        cnt = cnt + 1;
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String logFormatStr = ZacLogUtil.logFormat(className, methodName);
        log.debug(logFormatStr + "*** START ***" + cnt);


        log.debug(logFormatStr + "*** END ***" + cnt);
    }

    @AfterClass
    public static void execAfterClass() {
        cnt = cnt + 1;
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String logFormatStr = ZacLogUtil.logFormat("execAfterClass?????", methodName);
        log.debug(logFormatStr + "*** START ***" + cnt);
        
        log.debug(logFormatStr + "*** END ***" + cnt);
    }
}
