package com.scofevil.util;

import org.apache.commons.lang3.StringUtils;

/**
 * <br>创建日期：2017年5月15日
 * <br><b>Copyright 2017 IWJW All Rights Reserved</b>
 * @author haifeng.lu
 * @since 1.0
 * @version 1.0
 */
public class Util {
    /**
     * 首字母大写，非法字段返回原字段
     * @since 1.0 
     * @param src
     * @return
     * <br><b>作者： @author haifeng.lu</b>
     * <br>创建时间：2017年5月15日 下午3:20:27
     */
    public static String capitalizeFirstLetter(String src) {
        if (StringUtils.isBlank(src)) {
            return src;
        }
        return src.substring(0, 1).toUpperCase() + src.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(capitalizeFirstLetter("ac"));
    }
}
