package com.nk.lz.service.impl;

import com.nk.lz.dao.RegionDAO;
import com.nk.lz.domain.Region;
import com.nk.lz.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionImpl implements RegionService {
    @Autowired
    private RegionDAO regionDAO;
    @Override
    public List<Region> findRAll(){return regionDAO.findRAll();}
}
