package com.nk.lz.service.impl;

import com.nk.lz.dao.YearChangeDAO;
import com.nk.lz.domain.YearChange;
import com.nk.lz.service.YearChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearChangeImpl implements YearChangeService {
    @Autowired
    private YearChangeDAO yearChangeDAO;
    @Override
    public List<YearChange> findYCAll(){return yearChangeDAO.findYCAll();}
}
