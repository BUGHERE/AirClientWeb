package com.nk.wyh.service;
import com.nk.wyh.domain.AirCommonCount;
import java.util.List;

public interface AirCommonCountService {
    public List<AirCommonCount> getAllWorkProvinceCNCount();
    public List<AirCommonCount> getAllFfpTierCount();
    public List<AirCommonCount> getAllFfpDateYearCount();
    public List<AirCommonCount> getAllFiveCount();
}
