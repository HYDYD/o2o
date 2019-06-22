package com.xsyu.entity;

import java.util.Date;

/**
 * Created by HYDYD.
 * 2019/6/21 20:36
 */
public class Area {
    /**
     * 区域：东门，小吃街
     * 若integer为int的话会为我们的初始值赋0；
     * 我们希望空值就是空值
     */
    private Integer areaId;
    private String areaName;
    //店铺的权重 (展示)
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
