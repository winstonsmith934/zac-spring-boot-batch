package com.example.batch.staff;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.example.dao.TransactionStaffMapper;
import com.example.entity.TransactionStaff;
import com.example.entity.TransactionStaffExample;
import com.example.util.ZacException;

public class StaffItemProcessor implements ItemProcessor<TransactionStaff, TransactionStaff> {
    private static final Logger log = LoggerFactory.getLogger(StaffItemProcessor.class);

    @Value("${zac.timezone}")
    private String zacTimezone;
    
    @Autowired
    TransactionStaffMapper transactionStaffMapper;
    
    @Override
    public TransactionStaff process(final TransactionStaff transactionStaff) throws Exception {
        TransactionStaffExample example = new TransactionStaffExample();
        example.createCriteria().andStaffCodeEqualTo(transactionStaff.getStaffCode());
        List<TransactionStaff> list = transactionStaffMapper.selectByExample(example);
        if (list.size() > 0) {
            return null;
        }
        // 異常を取得テスト
        try {
            testException();
        } catch (Exception e) {
            log.debug("Test exception done");
        }

        return transactionStaff;
    }

    // 異常を取得テスト
    protected void testException() throws ZacException {
        log.debug("Test exception");
        log.debug(zacTimezone);
        throw new ZacException("This is a error msg.", "testException");
    }

}
