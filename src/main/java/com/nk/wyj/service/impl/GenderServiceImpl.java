package com.nk.wyj.service.impl;

import com.nk.wyj.dao.GenderDAO;
import com.nk.wyj.domain.Gender;
import com.nk.wyj.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderDAO genderDAO;
    @Override
    public List<Gender> print() {
        return genderDAO.print();
    }
}
