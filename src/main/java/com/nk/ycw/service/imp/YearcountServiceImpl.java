package com.nk.ycw.service.imp;

import com.nk.ycw.dao.YearcountDAO;
import com.nk.ycw.domain.Yearcount;
import com.nk.ycw.service.YearcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearcountServiceImpl implements YearcountService {
    @Autowired
    private YearcountDAO yearcountDAO;
    @Override
    public List<Yearcount> findAllRelation() {
        return yearcountDAO.findAllRelation();
    }
}
