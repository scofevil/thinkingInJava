package com.scofevil.thinkingInJava.util;

import java.util.Arrays;
import java.util.Collection;

/**
 * 输出工具类
 * @author luhaifeng
 */
public class PPrint {
    /**
     * 集合类格式化为字符串
     * @param src
     * @return
     */
    public static String pformat(Collection<?> src) {
        if (U.isNull(src))
            return "[]";
        StringBuilder result = new StringBuilder("[");
        for (Object each : src) {
            if (src.size() != 1)
                result.append("\n ");
            result.append(each);
        }
        if (src.size() != 1)
            result.append("\n");
        result.append("]");
        return result.toString();
    }

    /**
     * 数组格式化为字符串
     * @param src
     * @return
     */
    public static String pformat(Object[] src) {
        return pformat(Arrays.asList(src));
    }

    /**
     * 控制台打印格式化集合类字符串
     * @param src
     */
    public static void pprint(Collection<?> src) {
        System.out.println(pformat(src));
    }

    /**
     * 控制台打印格式化数组字符串
     * @param src
     */
    public static void pprint(Object[] src) {
        if (U.isNull(src))
            src = new Object[0];
        System.out.println(pformat(src));
    }
}
