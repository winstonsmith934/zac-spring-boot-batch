package com.zac.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.util.CsvUtils;



/**
 * CSV操作(导出和导入)
 * 
 * @author zac
 * @version 1.0 Jan 27, 2014 4:17:02 PM
 */
public class CsvTest {

    /**
     * CSV导出
     * 
     * @throws Exception
     */
    @Test
    public void exportCsv() {
        List<String> dataList=new ArrayList<String>();
        dataList.add("1,张三,男");
        dataList.add("2,李四,男");
        dataList.add("3,小红,女");
        boolean isSuccess=CsvUtils.exportCsv(new File("ljq.csv"), dataList);
        System.out.println(isSuccess);
    }
    
    /**
     * CSV导出
     * 
     * @throws Exception
     */
    @Test
    public void importCsv()  {
        List<String> dataList=CsvUtils.importCsv(new File("ljq.csv"));
        if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                System.out.println(data);
            }
        }
    }
    
    
}