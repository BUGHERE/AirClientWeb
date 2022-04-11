package com.nk.wyj.dao;

import com.nk.wyj.domain.Login;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDAO {
    public Login checkUser(String name,String passwd);
    public void  register(String name,String passwd);
}
