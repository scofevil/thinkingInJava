package com.scofevil.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

interface China {
    public static final String name = "Rollen";
    public static       int    age  = 20;

    public void sayChina();

    public void sayHello(String name, int age);
}

public class Hello {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.scofevil.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method[] = demo.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> param[] = method[i].getParameterTypes();
            int tmp = method[i].getModifiers();
            System.out.print(Modifier.toString(tmp) + " ");
            System.out.print(returnType.getName() + " ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < param.length; ++j) {
                System.out.print(param[j].getName() + " arg" + j);
                if (j < param.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(" throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }

        System.out.println("===============本类属性========================");
        // 取得本类的全部属性
        Field[] field = demo.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }
        System.out.println("===============实现的接口或者父类的属性========================");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = demo.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }

        try {
            Method method1 = demo.getMethod("sayChina");
            method1.invoke(demo.newInstance());
            method1 = demo.getMethod("sayHello", String.class, int.class);
            method1.invoke(demo.newInstance(), "lu", 25);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}

class Person implements China {

    private String sex;

    public Person() {
    }

    public Person(String sex) {
        this.sex = sex;
    }

    public void sayChina() {
        System.out.println("Hello China");
    }

    public void sayHello(String name, int age) {
        System.out.println(name + " " + age);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
