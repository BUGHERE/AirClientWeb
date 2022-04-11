package com.nk.lz.dao;

import com.nk.lz.domain.WorkProvince;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkProvinceDAO {
    public List<WorkProvince> findWPAll();
}
