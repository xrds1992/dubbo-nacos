package com.zdx.impl;

import com.zdx.api.OrderService;
import com.zdx.dao.Order;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@DubboService
public class OrderServiceImpl implements OrderService {
    @Autowired
    Order order;


    @Override
    @Transactional
    public void saveOrder() {
        System.out.println("xid="+ RootContext.getXID());
        order.save();
    }
}
