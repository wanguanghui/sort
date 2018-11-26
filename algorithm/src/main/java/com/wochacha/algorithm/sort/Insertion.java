package com.wochacha.algorithm.sort;

/**
 * @author wgh  2018/11/13
 * @add v1.0.0
 * @description
 */
public class Insertion extends Example {

    public static void main(String[] args){
        Double[] a = getData(100000);
        show(a);
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时 ：" + (endTime - startTime));
        show(a);
    }

    public static void sort(Comparable[] a){
        int length = a.length;
        int num = 0;
        for (int i = 0; i < length; i++){
//            for (int j = i; j > 0 && less(a[j], a[j-1]); j--){
//                exch(a, j, j-1);
//                num++;
//            }
            Comparable temp = a[i];
            int j = i;
            for (;j > 0 && less(temp, a[j-1]); j--){
                a[j] = a[j-1];
                num++;
            }
            a[j] = temp;
        }
        System.out.println("num = " + num);
    }

}
