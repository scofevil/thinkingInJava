package com.scofevil.thinkInJava.util;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
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

    public static void pprint(Collection<?> src) {
        System.out.println(pformat(src));
    }

    public static void pprint(Object[] src) {
        if (U.isNull(src))
            src = new Object[0];
        System.out.println(pformat(Arrays.asList(src)));
    }
}
