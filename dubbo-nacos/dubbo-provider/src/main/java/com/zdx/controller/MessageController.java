package com.zdx.controller;

import com.zdx.config.JmsConfig;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;//注入Mq

    @RequestMapping(value = "/CreateProduct",method = RequestMethod.GET)
    public String  createProduct(String s) {
        //添加信息
        rocketMQTemplate.convertAndSend(JmsConfig.TOPIC,"添加信息为：==="+s);
        return "添加成功";
    }
}
