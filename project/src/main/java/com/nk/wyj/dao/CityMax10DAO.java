package com.nk.wyj.dao;

import com.nk.wyj.domain.CityMax10;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityMax10DAO {
    public List<CityMax10> findAll();
}
