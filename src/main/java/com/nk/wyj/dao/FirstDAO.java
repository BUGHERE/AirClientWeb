package com.nk.wyj.dao;

import com.nk.wyj.domain.First;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FirstDAO {
    public List<First> findAll();
}
