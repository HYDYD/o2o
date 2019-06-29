package com.xsyu.o2o.util;

/**
 * Created by HYDYD.
 * 2019/6/28 20:27
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";

        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/TheDataOfJava/GitRepository/o2o/o2o/image";
        }else {
            basePath = "/home/verge/image/";
        }

        basePath = basePath.replace("/",separator);
        return basePath;
    }

    public static String getShopImgPath(Long shopId){
        String imagePath="/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/",separator);
    }
}
