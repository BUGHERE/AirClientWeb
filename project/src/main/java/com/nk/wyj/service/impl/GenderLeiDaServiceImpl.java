package com.nk.wyj.service.impl;

import com.nk.wyj.dao.GenderLeidaDAO;
import com.nk.wyj.domain.GenderLeiDa;
import com.nk.wyj.service.GenderLeiDaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderLeiDaServiceImpl implements GenderLeiDaService {
    @Autowired
    private GenderLeidaDAO genderLeidaDAO;
    @Override
    public List<GenderLeiDa> findAll() {
        return genderLeidaDAO.findAll();
    }
}
