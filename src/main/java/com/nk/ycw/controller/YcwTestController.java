package com.nk.ycw.controller;

import com.nk.ycw.domain.*;
import com.nk.ycw.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class YcwTestController {

    @Autowired
    private SexService sexService;
    @Autowired
    private DatanumService datanumService;
    @Autowired
    private YearcountService yearcountService;
    @Autowired
    private PointsService pointsService;
    @Autowired
    private ManyavgService manyavgService;

    @ResponseBody
    @RequestMapping("/findsex.do")
    public List<Sex> findallsex(){
        List<Sex> all = sexService.findAllSex();
        return all;

    }
    @ResponseBody
    @RequestMapping("/finddatebuy.do")
    public List<List> findallbuy(){
        List<Datanum> all = datanumService.findAllBuy();
        List<List> map1 = new ArrayList<>();
        List map=null;
        int i=0;
        for(i=0;i<all.size();i++){
            Datanum datanum = all.get(i);
            String s1 = datanum.getDatebuy();
            Integer s2 = datanum.getSumnum();
            map = new ArrayList();
            map.add(s1);
            map.add(s2);
            map1.add(map);

        }
        return map1;

    }
    @ResponseBody
    @RequestMapping("/findyearrelation.do")
    public List<List> findallrelation(){
        List<Yearcount> all = yearcountService.findAllRelation();
        List<List> map1 = new ArrayList<>();
        List map=null;
        int i=0;
        for(i=0;i<all.size();i++){
            Yearcount yearcount = all.get(i);
            Integer s1 = yearcount.getFirst();
            Integer s2 = yearcount.getSecond();
            map = new ArrayList();
            map.add(s1);
            map.add(s2);
            map1.add(map);

        }
        return map1;

    }
    @ResponseBody
    @RequestMapping("/pointsresult.do")
    public List<List> findpoints(){
        List<Points> all = pointsService.findTenMem();
        List<List> map1 = new ArrayList<>();
        List map=null;
        int i=0;
        map = new ArrayList();
        map.add("乘机次数");
        map.add("积分总数");
        map.add("客户编号");
        map1.add(map);
        for(i=0;i<all.size();i++){
            Points points = all.get(i);
            Integer s1 = points.getFcount();
            Integer s2 = points.getPoints();
            Integer s3 = points.getMem();
            map = new ArrayList();
            map.add(s1);
            map.add(s2);
            map.add(s3);
            map1.add(map);

        }
        return map1;

    }
    @ResponseBody
    @RequestMapping("/avg.do")
    public List<List> findallavg(){
        List<Manyavg> all = manyavgService.findAllAvg();
        List<List> map1 = new ArrayList<>();
        List map=null;
        int i=0;
        map = new ArrayList();
        map.add("工作国家");
        map.add("总人数");
        map.add("平均年龄");
        map.add("平均总飞行里程数");
        map1.add(map);
        for(i=0;i<all.size();i++){
            Manyavg manyavg = all.get(i);
            String s1 = manyavg.getCountry();
            Integer s2 = manyavg.getSumnum();
            Double s3 = manyavg.getAvgage();
            Double s4 = manyavg.getAvgkm();
            map = new ArrayList();
            map.add(s1);
            map.add(s2);
            map.add(s3);
            map.add(s4);
            map1.add(map);

        }
        return map1;

    }

}
