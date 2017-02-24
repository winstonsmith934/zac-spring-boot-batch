package com.example.batch.restartable;

import java.util.List;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
// restart可能な部品の仕組みと、その自作方法
// https://sites.google.com/site/soracane/home/springnitsuite/spring-batch/14-restart-ke-nengnisuru
public class RestartableListItemReader<T> implements ItemStreamReader<T> {

    private static final String KEY = "RestartableListItemReader.";
    private int index = 0;
    private int listSize = 0;
    private List<T> iterateData;

    /**
     * Listを設定するコンストラクタ。
     * 
     * @param list
     */
    public RestartableListItemReader(List<T> list) {
        this.iterateData = list;
        this.listSize = list.size();
    }

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException {
        int n = this.index;
        ++this.index;
        if (this.index > listSize)
            return null;
        return this.iterateData.get(n);
    }

    @Override
    public void close() throws ItemStreamException {
    }

    @Override
    public void open(ExecutionContext context) throws ItemStreamException {
        // 開始位置を取得
        this.index = context.getInt(KEY + "index", 0);
    }

    @Override
    public void update(ExecutionContext context) throws ItemStreamException {
        context.putInt(KEY + "index", this.index);
    }

}
