package com.nk.lz.service.impl;

import com.nk.lz.dao.WorkProvinceDAO;
import com.nk.lz.domain.WorkProvince;
import com.nk.lz.service.WorkProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkProvinceImpl implements WorkProvinceService {
    @Autowired
    private WorkProvinceDAO workProvinceDAO;
    @Override
    public List<WorkProvince> findWPAll(){return workProvinceDAO.findWPAll();}
}
