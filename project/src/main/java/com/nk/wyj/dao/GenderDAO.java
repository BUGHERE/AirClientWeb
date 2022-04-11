package com.nk.wyj.dao;

import com.nk.wyj.domain.Gender;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenderDAO {
    public List<Gender> print();
}
