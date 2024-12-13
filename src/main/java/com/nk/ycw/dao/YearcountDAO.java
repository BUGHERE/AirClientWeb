package com.nk.ycw.dao;

import com.nk.ycw.domain.Yearcount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YearcountDAO {
    public List<Yearcount> findAllRelation();

}
