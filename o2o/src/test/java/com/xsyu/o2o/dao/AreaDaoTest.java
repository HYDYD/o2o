package com.xsyu.o2o.dao;

import com.xsyu.BaseTest;
import com.xsyu.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/24 9:35
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        Assert.assertEquals(3,areaList.size());
    }
}
