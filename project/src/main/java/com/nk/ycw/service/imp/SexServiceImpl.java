package com.nk.ycw.service.imp;

import com.nk.ycw.dao.SexDAO;
import com.nk.ycw.domain.Sex;
import com.nk.ycw.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexServiceImpl implements SexService {
    @Autowired
    SexDAO sexDAO;
    @Override
    public List<Sex> findAllSex() {
        return sexDAO.findAllSex();
    }
}
