package com.nk.wyj.service;

import com.nk.wyj.domain.Login;

public interface LoginService {
    public Login checkUser(String name, String passwd);
    public void  register(String name,String passwd);
}
