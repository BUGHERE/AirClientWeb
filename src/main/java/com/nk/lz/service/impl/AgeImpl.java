package com.nk.lz.service.impl;

import com.nk.lz.dao.AgeDAO;
import com.nk.lz.domain.Age;
import com.nk.lz.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgeImpl implements AgeService {
    @Autowired
    private AgeDAO ageDAO;
    @Override
    public List<Age> findAAll(){return ageDAO.findAAll();}
}
