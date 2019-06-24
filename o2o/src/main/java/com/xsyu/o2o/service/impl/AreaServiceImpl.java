package com.xsyu.o2o.service.impl;

import com.xsyu.o2o.dao.AreaDao;
import com.xsyu.o2o.entity.Area;
import com.xsyu.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/24 21:35
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
