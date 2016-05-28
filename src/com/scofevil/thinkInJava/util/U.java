package com.scofevil.thinkInJava.util;

import java.util.Collection;

public class U {

    public static boolean isNull(Collection<?> src) {
        return null == src || src.size() == 0;
    }

    public static boolean isNull(Object src) {
        return null == src;
    }

    public static boolean isNull(String src) {
        return null == src || "".equals(src.trim());
    }

}
