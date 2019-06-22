package com.xsyu.entity;

import java.util.Date;

/**
 * Created by HYDYD.
 * 2019/6/21 20:58
 */
public class WechatAuth {
    private Long wechatAuthId;
    //与本地账号关联的唯一标识符
    private String openId;
    private Date createData;
    private PersonInfo personInfo;


    public Long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(Long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
