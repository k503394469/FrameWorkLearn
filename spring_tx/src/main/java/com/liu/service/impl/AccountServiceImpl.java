package com.liu.service.impl;

import com.liu.dao.AccountDao;
import com.liu.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao dao;
    @Override
    public void transfer(int inId,int outId, double money) {
        dao.out(outId,money);
//        int i=1/0;
        dao.in(inId,money);
    }
}
