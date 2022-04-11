package com.nk.lz.dao;

import com.nk.lz.domain.YearChange;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YearChangeDAO {
    public List<YearChange> findYCAll();
}
