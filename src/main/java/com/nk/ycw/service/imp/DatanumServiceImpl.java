package com.nk.ycw.service.imp;

import com.nk.ycw.dao.DatanumDAO;
import com.nk.ycw.domain.Datanum;
import com.nk.ycw.service.DatanumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatanumServiceImpl implements DatanumService {
    @Autowired
    DatanumDAO datanumDAO;

    @Override
    public List<Datanum> findAllBuy() {
        return datanumDAO.findALLBuy();
    }
}
