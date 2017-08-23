package com.scofevil.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Random;

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

    public static int[] getRandomArray(Integer count, Integer start, Integer end) {
        if (count == null || count < 1)
            throw new IllegalArgumentException();
        if (start == null)
            start = Integer.MIN_VALUE;
        if (end == null)
            end = Integer.MAX_VALUE;
        if (start >= end)
            throw new IllegalArgumentException();
        int re[] = new int[count];
        for (int i = 0; i < count; i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt((end - start) + 1) + start;
            re[i] = randomNum;
        }
        return re;
    }

    public static void main(String[] args) {
        int a[] = getRandomArray(100000000, 0, 2000000000);
        System.out.println(a.length);
    }

}
