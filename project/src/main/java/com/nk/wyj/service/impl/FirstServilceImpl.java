package com.nk.wyj.service.impl;

import com.nk.wyj.dao.FirstDAO;
import com.nk.wyj.domain.First;
import com.nk.wyj.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstServilceImpl implements FirstService {
    @Autowired
    private FirstDAO firstDAO;
    @Override
    public List<First> findAll() {
        return firstDAO.findAll();
    }
}
