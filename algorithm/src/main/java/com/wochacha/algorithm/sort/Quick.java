package com.wochacha.algorithm.sort;

/**
 * @author wgh  2018/11/26
 * @add v1.0.0
 * @description 快速排序
 */
public class Quick extends Example {

    public static void main(String[] args){
        Double[] a = getData(1000000);
//        show(a);
        long startTime = System.currentTimeMillis();
        sort(a, 0, a.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时 ：" + (endTime - startTime));
//        show(a);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if (lo >= hi){
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }



    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[i];
        while (true){
            while (less(a[++i], v)){
                if (i == hi){
                    break;
                }
            }
            while (less(v, a[--j])){
                if (j == lo){
                    break;
                }
            }
            if (i >= j){
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

}
