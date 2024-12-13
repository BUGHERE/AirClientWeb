package com.nk.wyj.service.impl;

import com.nk.wyj.dao.Data1DAO;
import com.nk.wyj.domain.Data1;
import com.nk.wyj.service.Data1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Data1ServiceImpl implements Data1Service {
    @Autowired
    private Data1DAO data1DAO;

    @Override
    public List<Data1> findAll() {
        List<Data1> all = data1DAO.findAll();
        return all;

    }
}
