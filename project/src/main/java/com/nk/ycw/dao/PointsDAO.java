package com.nk.ycw.dao;

import com.nk.ycw.domain.Points;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointsDAO {
    public List<Points> findTenMem();
}
