package com.zdx.impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.zdx.api.InfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@Component
@DubboService
public class InfoServiceImpl implements InfoService {


    @Override
    @SentinelResource(fallback = "helloError")
    public String getInfo() {

        return "hello，这里是dubbo-provider模块！";
    }

    @Override
    @SentinelResource(fallback = "helloError")
    public String getTest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test";
    }



    public String helloError(Throwable e) {
        return "error," + ((FlowException) e).getRule();
    }
}
