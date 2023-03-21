package com.zdx.controller;

import com.zdx.dao.UserDao;
import com.zdx.api.InfoService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class InfoController {
    //dumbo提供的Reference注解，用于调用远程服务
    @DubboReference( cluster = "failfast", check = false)
    private InfoService infoService;

    @Resource
    UserDao userDao;
    @GetMapping("/getInfo")
    public String getInfo(){

        return infoService.getInfo();
    }

    @GetMapping("/getTest")

    public String getTest(){
        return infoService.getTest();
    }

}
