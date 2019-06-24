package com.xsyu.o2o.dao;

import com.xsyu.o2o.entity.Area;

import java.util.List;

/**
 * Created by HYDYD.
 * 2019/6/23 17:54
 */
public interface AreaDao {
    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
