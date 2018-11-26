package com.wochacha.algorithm.sort;

/**
 * @author wgh  2018/11/9
 * @add v1.0.0
 * @description
 */
public class Selection extends Example {

    public static void main(String[] args){
        Double[] a = getData(100);
        show(a);
        sort(a);
        show(a);
    }

    public static void sort(Comparable[] a){
        int length = a.length;
        for (int i = 0; i < length; i++){
            int minIndex = i;
            for (int j = i + 1; j < length; j++){
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
        }
    }
}
