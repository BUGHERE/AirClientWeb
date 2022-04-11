package com.nk.wyh.dao;

import com.nk.wyh.domain.AirCommonCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AirCommonCountDAO {
    public List<AirCommonCount> getAllWorkProvinceCNCount();
    public List<AirCommonCount> getAllFfpTierCount();
    public List<AirCommonCount> getAllFfpDateYearCount();
    public List<AirCommonCount> getAllFiveCount();
}
