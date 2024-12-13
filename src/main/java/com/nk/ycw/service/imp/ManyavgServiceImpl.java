package com.nk.ycw.service.imp;

import com.nk.ycw.dao.ManyavgDAO;
import com.nk.ycw.domain.Manyavg;
import com.nk.ycw.service.ManyavgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyavgServiceImpl implements ManyavgService {
    @Autowired
    ManyavgDAO manyavgDAO;
    @Override
    public List<Manyavg> findAllAvg() {
        return manyavgDAO.findAllAvg();
    }
}
