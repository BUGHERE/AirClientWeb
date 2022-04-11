package com.nk.ycw.dao;

import com.nk.ycw.domain.Datanum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DatanumDAO {
    public List<Datanum> findALLBuy();
}
