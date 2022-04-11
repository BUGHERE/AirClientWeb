package com.nk.wyh.service.impl;

import com.nk.wyh.dao.AirCommonCountDAO;
import com.nk.wyh.domain.AirCommonCount;
import com.nk.wyh.service.AirCommonCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirCommonCountServiceImpl implements AirCommonCountService {
    @Autowired
    private AirCommonCountDAO airCommonCountDAO;
    @Override
    public List<AirCommonCount> getAllWorkProvinceCNCount() {
        return airCommonCountDAO.getAllWorkProvinceCNCount();
    }
    @Override
    public List<AirCommonCount> getAllFfpTierCount() { return airCommonCountDAO.getAllFfpTierCount(); }
    @Override
    public List<AirCommonCount> getAllFfpDateYearCount() { return airCommonCountDAO.getAllFfpDateYearCount(); }
    @Override
    public List<AirCommonCount> getAllFiveCount() { return airCommonCountDAO.getAllFiveCount(); }
}
