package com.example.batch.sample;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.example.bean.Person;
import com.example.dao.UserMapper;
import com.example.entity.User;
import com.example.entity.UserExample;
import com.example.util.ZacException;

public class SampleItemProcessor implements ItemProcessor<Person, Person> {
    private static final Logger log = LoggerFactory.getLogger(SampleItemProcessor.class);

    @Value("${zac.timezone}")
    private String zacTimezone;
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName();
        final String lastName = person.getLastName();
        log.debug(lastName);
        
        // Userテーブル全件検索例
        UserExample example = new UserExample();
        List<User> list = userMapper.selectByExample(example);
        log.debug("cnt:" + list.size());
        for(User rec : list){
            log.debug(rec.getFirstName());
        }
        
        // UserテーブルfirstName指定で検索例
        UserExample example2 = new UserExample();
        example2.createCriteria().andLastNameEqualTo(firstName);
        List<User> list２ = userMapper.selectByExample(example2);
        log.debug("cnt:" + list２.size());
        for(User rec : list２){
            log.debug(rec.getFirstName());
        }

        final Person transformedPerson = new Person(firstName, lastName);

        // 異常を取得テスト
        try {
            testException();
        } catch (Exception e) {
            log.debug("Test exception done");
        }

        return transformedPerson;
    }

    // 異常を取得テスト
    protected void testException() throws ZacException {
        log.debug("Test exception");
        log.debug(zacTimezone);
        throw new ZacException("This is a error msg.", "testException");
    }

}
