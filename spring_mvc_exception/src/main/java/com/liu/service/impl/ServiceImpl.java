package com.liu.service.impl;

import com.liu.dao.TestDao;
import com.liu.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("service")
public class ServiceImpl implements TestService {
    @Resource(name = "dao")
    private TestDao dao;
    @Override
    public String show() {
        return dao.show();
    }
}
