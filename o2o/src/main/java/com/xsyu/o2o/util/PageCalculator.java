package com.xsyu.o2o.util;

/**
 * Created by HYDYD.
 * 2019/7/7 13:46
 */
public class PageCalculator {
    /**
     * 选第几页如：第一页为（1-1）*5 从0开始到pageSize 第二页从（2-1）*5 从第五条开始筛选
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int calculatorRowIndex(int pageIndex, int pageSize){
        return (pageIndex > 0) ? (pageIndex - 1)*pageSize : 0;
    }
}
