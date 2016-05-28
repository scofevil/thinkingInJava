package com.scofevil.thinkInJava.util;

import java.util.Collection;

public class U {

    /**
     * 集合类判空，null||size()==0 return true
     * @param src
     * @return
     */
    public static boolean isNull(Collection<?> src) {
        return null == src || src.size() == 0;
    }

    /**
     * 对象判空，null return true
     * @param src
     * @return
     */
    public static boolean isNull(Object src) {
        return null == src;
    }

    /**
     * 字符串判空,null||空字符串 return true
     * @param src
     * @return
     */
    public static boolean isNull(String src) {
        return null == src || "".equals(src.trim());
    }

}
