package com.nk.wyj.dao;

import com.nk.wyj.domain.Data1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Data1DAO {
    public List<Data1> findAll();
}
