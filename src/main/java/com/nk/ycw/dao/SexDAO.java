package com.nk.ycw.dao;

import com.nk.ycw.domain.Sex;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SexDAO {
    public List<Sex> findAllSex();
}
