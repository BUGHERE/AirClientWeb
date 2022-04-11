package com.nk.wyj.service.impl;

import com.nk.wyj.dao.CityMax10DAO;
import com.nk.wyj.domain.CityMax10;
import com.nk.wyj.service.CityMax10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityMax10ServiceImpl implements CityMax10Service {
    @Autowired
    private CityMax10DAO cityMax10DAO;
    @Override
    public List<CityMax10> findAll() {
        return cityMax10DAO.findAll();
    }
}
