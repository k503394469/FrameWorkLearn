package com.liu.service.impl;

import com.liu.dao.AccountDao;
import com.liu.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("accountService")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao dao;

    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void transfer(int inId,int outId, double money) {
        dao.out(outId,money);
//        int i=1/0;
        dao.in(inId,money);
    }
}
