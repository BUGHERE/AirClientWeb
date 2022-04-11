package com.nk.wyj.service.impl;

import com.nk.wyj.dao.AgeCountDAO;
import com.nk.wyj.domain.AgeCount;
import com.nk.wyj.service.AgeCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgeCountServiceImpl implements AgeCountService {
    @Autowired
    private AgeCountDAO ageCountDAO;
    @Override
    public List<AgeCount> ageCount() {
        return ageCountDAO.ageCount();
    }
}
