package com.wochacha.algorithm.sort;

/**
 * @author wgh  2018/11/22
 * @add v1.0.0
 * @description 归并排序
 */
public class Merge extends Example{

    private static Comparable[] aux;

    public static void main(String[] args){
        Double[] a = getData(1000000);
//        show(a);
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时 ：" + (endTime - startTime));
//        show(a);
    }

    private static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo){
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);

    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++){
            if (i > mid){
                //左侧归并完
                a[k] = aux[j++];
            } else if (j > hi){
                //右侧归并完
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])){
                //右侧数据较小
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

}
