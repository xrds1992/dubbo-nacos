package com.zdx.controller;

import com.zdx.api.OrderService;
import com.zdx.api.UserService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    //dumbo提供的Reference注解，用于调用远程服务
    @DubboReference( cluster = "failfast", check = false)
    private OrderService orderService;

    @DubboReference( cluster = "failfast", check = false)
    private UserService userService;

    @GetMapping("/save")
    @GlobalTransactional

    public String save() throws InterruptedException {
        System.out.println("xid="+RootContext.getXID());

        orderService.saveOrder();


        userService.saveUser();
        System.out.println(1/0);

        return "ok";
    }
}
