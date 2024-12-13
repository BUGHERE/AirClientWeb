package com.nk.lz.controller;

import com.nk.lz.domain.*;
import com.nk.lz.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LzTestController {
    @Autowired
    private WorkProvinceService workProvinceService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private AgeService ageService;
    @Autowired
    private YearChangeService yearChangeService;
    @Autowired
    private AvgDiscountService avgDiscountService;
    @ResponseBody
    @RequestMapping("/findwpall.do")
    public List<WorkProvince> findwpall(){
        List<WorkProvince> all = workProvinceService.findWPAll();
        return all;
    }
    @ResponseBody
    @RequestMapping("/findrall.do")
    public List<Region> findrall(){
        List<Region> all = regionService.findRAll();
        return all;
    }
    @ResponseBody
    @RequestMapping("/findaall.do")
    public List<Age> findaall(){
        List<Age> all = ageService.findAAll();
        return all;
    }
    @ResponseBody
    @RequestMapping("/findycall.do")
    public List<YearChange> findycall(){
        List<YearChange> all = yearChangeService.findYCAll();
        return all;
    }
    @ResponseBody
    @RequestMapping("/findadall.do")
    public List<AvgDiscount> findadall(){
        List<AvgDiscount> all = avgDiscountService.findADAll();
        return all;
    }
}
