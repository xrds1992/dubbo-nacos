package com.zdx.impl;

import com.zdx.api.UserService;
import com.zdx.dao.UserDao;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@DubboService
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    @Transactional
    public void saveUser() {
        System.out.println("xid="+ RootContext.getXID());
        userDao.save();
    }
}
