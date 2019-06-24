package com.xsyu.o2o.service;

import com.xsyu.BaseTest;
import com.xsyu.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/24 21:37
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> list = areaService.getAreaList();
        Assert.assertEquals("小吃街",list.get(0).getAreaName());
    }
}
