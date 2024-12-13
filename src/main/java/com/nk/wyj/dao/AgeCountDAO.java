package com.nk.wyj.dao;

import com.nk.wyj.domain.AgeCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AgeCountDAO {
    public List<AgeCount> ageCount();
}
