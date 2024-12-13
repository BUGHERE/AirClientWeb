package com.nk.wyj.dao;

import com.nk.wyj.domain.Second;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecondDAO {
    public List<Second> findAll();
}
