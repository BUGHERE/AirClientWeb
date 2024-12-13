package com.nk.lz.dao;

import com.nk.lz.domain.Age;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AgeDAO {
    public List<Age> findAAll();
}
