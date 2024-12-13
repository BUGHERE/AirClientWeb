package com.nk.ycw.service.imp;

import com.nk.ycw.dao.PointsDAO;
import com.nk.ycw.domain.Points;
import com.nk.ycw.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointsServiceImpl implements PointsService {
    @Autowired
    PointsDAO pointsDAO;
    @Override
    public List<Points> findTenMem() {
        return pointsDAO.findTenMem();
    }
}
