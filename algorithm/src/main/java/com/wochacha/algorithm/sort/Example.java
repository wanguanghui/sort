package com.wochacha.algorithm.sort;

import com.wochacha.algorithm.utils.StdRandom;

/**
 * @author wgh  2018/11/9
 * @add v1.0.0
 * @description
 */
public class Example {

    protected static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    protected static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }

    protected static Double[] getData(int length){
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++){
            a[i] = StdRandom.INSTANCE.uniform(0.0, 100);
        }
        return a;
    }

}
