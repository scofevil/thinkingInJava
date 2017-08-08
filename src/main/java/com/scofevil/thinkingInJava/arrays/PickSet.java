package com.scofevil.thinkingInJava.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * <br>创建日期：2016年12月21日
 * <br><b>Copyright 2016 scofevil</b>
 * @author haifeng.lu
 * @since 1.0
 * @version 1.0
 */
public class PickSet<T> {
    private static final Object[] defaultPickSet = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
                                                     "9" };
    private static Random rand = new Random(System.currentTimeMillis());
    private Object[] pickSet;

    private int pickSetSize;

    public PickSet() {
        this(defaultPickSet);
    }

    public PickSet(Object[] pickSet) {
        if (pickSet == null)
            throw new IllegalArgumentException("pickSet can't be null");
        if (pickSet.length < 1)
            throw new IllegalArgumentException("pickSet size must be more than one element");
        this.pickSet = pickSet;
        this.pickSetSize = pickSet.length;
    }

    public PickSet(Collection<T> pickSet) {
        this(pickSet.toArray(new Object[] {}));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 7; i++)
            System.out.println(Arrays.toString(
                    new PickSet<String>(Arrays.asList(new String[] { "1", "2", "3" })).pick()));
    }

    /**
     * 选择 pickSetSize 数量的元素出来
     * @since 1.0
     * @return
     * <br><b>作者： @author haifeng.lu</b>
     * <br>创建时间：2016年12月21日 下午5:00:14
     */
    public T[] pick() {
        return pick(pickSetSize);
    }

    /**
     * 在pickSet中随机选择 n个元素
     * @since 1.0
     * @param n
     * @return
     * <br><b>作者： @author haifeng.lu</b>
     * <br>创建时间：2016年12月21日 下午4:30:23
     */
    @SuppressWarnings("unchecked")
    public T[] pick(int n) {
        if (n > pickSetSize)
            throw new IllegalArgumentException("n too big ,must be less than " + pickSetSize);
        Object[] results = new Object[n];
        boolean[] picked = new boolean[pickSetSize];
        for (int i = 0; i < n; i++) {
            int t;
            do
                t = rand.nextInt(pickSetSize); while (picked[t]);
            results[i] = pickSet[t];
            picked[t] = true;
        }
        return (T[]) results;
    }
}
