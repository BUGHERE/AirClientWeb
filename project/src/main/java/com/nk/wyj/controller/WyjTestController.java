package com.nk.wyj.controller;

import com.nk.wyj.domain.*;
import com.nk.wyj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WyjTestController {
    @Autowired
    private GenderService genderService;
    @Autowired
    private AgeCountService ageCountService;
    @Autowired
    private Data1Service data1Service;
    @Autowired
    private CityMax10Service cityMax10Service;
    @Autowired
    private FirstService firstService;
    @Autowired
    private SecondService secondService;
    @Autowired
    private GenderLeiDaService genderLeiDaService;
    @Autowired
    private LoginService loginService;
    @ResponseBody
    @RequestMapping("/gender.do")
    public List<Gender> genderdo(){
        return genderService.print();
    }
    @ResponseBody
    @RequestMapping("/agecount.do")
    public List<AgeCount> agecount(){
        return ageCountService.ageCount();
    }
    @ResponseBody
    @RequestMapping("/data.do")
    public List<Data1> data(){
        return data1Service.findAll();
    }

    @ResponseBody
    @RequestMapping("/data1.do")
    public List<List> data1(){
        List<List> oList=new ArrayList<>();
        List<Data1> iList=data1Service.findAll();
        List temp=null;
        temp=new ArrayList();
        temp.add("总飞行次数");
        temp.add("第一年飞行总次数");
        temp.add("第一年总票价");
        temp.add("第二年飞行总次数");
        temp.add("第二年总票价");
        temp.add("总积分");
        oList.add(temp);
        for(int i=0;i<iList.size();i++){
            Data1 data =iList.get(i);
            String s1=data.getFLIGHT_COUNT();
            String s2=data.getP1Y_Flight_Count();
            String s3=data.getSUM_YR_1();
            String s4=data.getL1Y_Flight_Count();
            String s5=data.getSUM_YR_2();
            String s6=data.getPoints_Sum();
            temp=new ArrayList();
            temp.add(s1);
            temp.add(s2);
            temp.add(s3);
            temp.add(s4);
            temp.add(s5);
            temp.add(s6);
            oList.add(temp);
        }
        return oList;
    }
    @ResponseBody
    @RequestMapping("/citymax10.do")
    public List<CityMax10> citymax10(){

        return cityMax10Service.findAll();
    }
    @ResponseBody
    @RequestMapping("/scorecount.do")
    public List<ScoreCount> scorecount(){
        List<First> firstList = firstService.findAll();
        List<Second> secondList = secondService.findAll();
        List<ScoreCount> scoreCounts = null;
        scoreCounts=new ArrayList<>();
        for(int i=0;i<firstList.size();i++){
            scoreCounts.add(new ScoreCount(firstList.get(i).getFirstscore(),firstList.get(i).getCount(),secondList.get(i).getSecondscore(),secondList.get(i).getCount()));
        }

        /*for(int i=0;i<firstList.size();i++){
            scoreCounts.get(i).setFirstscore(firstList.get(i).getFirstscore());
            scoreCounts.get(i).setFirstcount(firstList.get(i).getCount());
            scoreCounts.get(i).setSecondscore(secondList.get(i).getSecondscore());
            scoreCounts.get(i).setSecondcount(secondList.get(i).getCount());
        }*/
        return scoreCounts;
    }
    @ResponseBody
    @RequestMapping("/genderleida.do")
    public List<GenderLeiDa> genderleida(){

        return genderLeiDaService.findAll();
    }
    @RequestMapping("/login.do")
    public String logindo(String name,String passwd){
        Login login = loginService.checkUser(name, passwd);
        if (login==null||"".equals(login)){
            return "redirect:/asserts/login.html";
        }else{
            return "redirect:/asserts/index.html";
        }
    }
    @RequestMapping("/register.do")
    public String registerdo(){

        return "redirect:/asserts/register.html";
    }
    @RequestMapping("/registerAccount.do")
    public String registerAccount(String name,String passwd){
        loginService.register(name, passwd);
        return "redirect:/asserts/login.html";
    }
}
