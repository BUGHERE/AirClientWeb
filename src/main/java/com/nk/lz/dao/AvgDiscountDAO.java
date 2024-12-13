package com.nk.lz.dao;

import com.nk.lz.domain.AvgDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AvgDiscountDAO {
    public List<AvgDiscount> findADAll();
}
