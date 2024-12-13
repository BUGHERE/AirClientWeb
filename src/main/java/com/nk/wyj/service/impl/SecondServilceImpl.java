package com.nk.wyj.service.impl;

import com.nk.wyj.dao.SecondDAO;
import com.nk.wyj.domain.Second;
import com.nk.wyj.service.SecondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecondServilceImpl implements SecondService {
    @Autowired
    private SecondDAO secondDAO;
    @Override
    public List<Second> findAll() {
        return secondDAO.findAll();
    }
}
