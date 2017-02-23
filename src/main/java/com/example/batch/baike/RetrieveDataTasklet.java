package com.example.batch.baike;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.bean.BaiduBaikeClientBean;
import com.example.bean.BaiduBaikeClientCardBean;
import com.example.dao.UserMapper;
import com.example.entity.User;
// http://www.yihaomen.com/article/java/434.htm
// zacTODO tasklet做什么用？
@Component
public class RetrieveDataTasklet implements Tasklet{
    private static final Logger log = LoggerFactory.getLogger(RetrieveDataTasklet.class);
    private UserMapper userMapper;
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        BaiduBaikeClientBean baiduBaikeClientBean = null;
        ClientConfig cc = new ClientConfig();
        Client client = ClientBuilder.newClient(cc);
        WebTarget target = client.target(getBaseURI()).path("BaikeLemmaCardApi");
        Form form = fillUpForm();
        Response res = target.request(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

        if (res.getStatus() != 200) {
            log.debug("==========");
        } else {
            String resBody = res.readEntity(String.class);
            baiduBaikeClientBean = JSON.parseObject(resBody, BaiduBaikeClientBean.class);
        }
        List<BaiduBaikeClientCardBean> cardBeanList = JSON.parseArray(baiduBaikeClientBean.getCard(),BaiduBaikeClientCardBean.class);
        for(BaiduBaikeClientCardBean cardObject : cardBeanList){
            try {
                User user = new User();
                user.setFirstName(cardObject.getName());
                user.setLastName(cardObject.getName());
                user.setAge(39);
                user.setCreateTime(new Date());
                user.setUpdateTime(new Date());
                userMapper.insert(user);
            }catch (Exception e) {
                log.error("Error",e);
                continue;
            }  
        }
        return RepeatStatus.FINISHED;
    }
    
    private static Form fillUpForm() {
        Form form = new Form();
        form.param("scope", "103");
        form.param("format", "json");
        form.param("appid", "379020");
        form.param("bk_key", "China");
        form.param("bk_length", "600");
        return form;
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://baike.baidu.com/api/openapi").build();

    }

}
