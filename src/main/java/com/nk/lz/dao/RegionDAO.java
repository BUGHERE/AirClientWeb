package com.nk.lz.dao;

import com.nk.lz.domain.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionDAO {
    public List<Region> findRAll();
}
