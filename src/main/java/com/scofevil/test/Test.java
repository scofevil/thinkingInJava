package com.scofevil.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.scofevil.test.annotation.Feild;
import com.scofevil.test.annotation.MetaData;
import com.scofevil.util.Util;

public class Test {
    public static void main(String[] args) throws Throwable {
        MetaData md = new MetaData();
        md.setAge(14);
        md.setSalary("10");
        md.setSex("1");
        Field[] fields = md.getClass().getFields();
        for (Field each : fields) {
            if (each.isAnnotationPresent(Feild.class)) {
                Feild f = each.getAnnotation(Feild.class);
                Method method = md.getClass().getMethod(
                    "get" + Util.capitalizeFirstLetter(each.getName()));
                Object o = method.invoke(md);
                System.out.println(o.toString() + "-" + f.id() + "_" + f.name());
            }
        }
    }

}
