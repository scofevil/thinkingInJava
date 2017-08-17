package com.scofevil.test.lambda;

import lombok.Data;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author haifeng.lu
 * @since 1.0
 */
@Data
public class Test {

    String s;

    private int i = 3;

    public void test(Add a) {
        System.out.println(a.add(1, 2));
    }

    public static void main(String[] args) {
                Test t = new Test();
                t.test((x, y) -> x * y);
        //        new Thread(() -> System.out.println("haha")).start();
        //        List features = Arrays
        //                .asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        //        for (Object each : features) {
        //            System.out.println(each);
        //        }
        //        features.forEach((e) -> System.out.println(e));
        //        features.forEach(System.out::println);
//        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        //        System.out.println("Languages which starts with J :");
        //        filter(languages, (str) -> str.startsWith("J"));
        //
        //        System.out.println("Languages which ends with a ");
        //        filter(languages, (str) -> str.endsWith("a"));
        //
        //        System.out.println("Print all languages :");
        //        filter(languages, (str) -> true);
        //
        //        System.out.println("Print no language : ");
        //        filter(languages, (str) -> false);
        //
        //        System.out.println("Print language whose length greater than 4:");
        //        filter2(languages, (str) -> str.length() > 4);
//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            System.out.println(price);
//        }

         //使用lambda表达式
//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
    }

    public static void filter(List names, Predicate<String> condition) {
        for (Object name : names) {
            if (condition.test(name.toString())) {
                System.out.println(name + " ");
            }
        }
    }

    public static void filter2(List<String> names, Predicate<String> condition) {
        names.stream().filter((e) -> (condition.test(e)))
                .forEach((e) -> System.out.println(e + " "));
    }

    interface Add {
        int add(int x, int y);
    }

}
