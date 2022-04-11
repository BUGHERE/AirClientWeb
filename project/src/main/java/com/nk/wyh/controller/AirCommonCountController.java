package com.nk.wyh.controller;
import com.nk.wyh.domain.AirCommonCount;
import com.nk.wyh.service.AirCommonCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AirCommonCountController {
    @Autowired
    private AirCommonCountService airCommonCountService;
    @ResponseBody
    @RequestMapping("getAllWorkProvinceCNCount")
    public List<AirCommonCount> getAllWorkProvinceCNCount(){
        return airCommonCountService.getAllWorkProvinceCNCount();
    }
    @ResponseBody
    @RequestMapping("getAllFfpTierCount")
    public List<AirCommonCount> getAllFfpTierCount(){
        return airCommonCountService.getAllFfpTierCount();
    }
    @ResponseBody
    @RequestMapping("getAllFfpDateYearCount")
    public List<AirCommonCount> getAllFfpDateYearCount(){
        return airCommonCountService.getAllFfpDateYearCount();
    }
    @ResponseBody
    @RequestMapping("getAllFiveCount")
    public List<AirCommonCount> getAllFiveCount(){
        return airCommonCountService.getAllFiveCount();
    }
}
