package com.nk.wyj.dao;

import com.nk.wyj.domain.GenderLeiDa;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenderLeidaDAO {
    public List<GenderLeiDa> findAll();
}
