package com.nk.lz.service.impl;

import com.nk.lz.dao.AvgDiscountDAO;
import com.nk.lz.domain.AvgDiscount;
import com.nk.lz.service.AvgDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvgDiscountImpl implements AvgDiscountService {
    @Autowired
    private AvgDiscountDAO avgDiscountDAO;
    @Override
    public List<AvgDiscount> findADAll(){return avgDiscountDAO.findADAll();}
}
