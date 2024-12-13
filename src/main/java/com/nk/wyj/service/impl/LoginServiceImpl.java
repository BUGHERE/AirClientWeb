package com.nk.wyj.service.impl;

import com.nk.wyj.dao.LoginDAO;
import com.nk.wyj.domain.Login;
import com.nk.wyj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDAO loginDAO;
    @Override
    public Login checkUser(String name, String passwd) {
        return loginDAO.checkUser(name,passwd);
    }

    @Override
    public void register(String name, String passwd) {
        loginDAO.register(name, passwd);
    }
}
