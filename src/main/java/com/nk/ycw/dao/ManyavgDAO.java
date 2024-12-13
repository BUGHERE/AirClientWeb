package com.nk.ycw.dao;

import com.nk.ycw.domain.Manyavg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManyavgDAO {
    public List<Manyavg> findAllAvg();
}
