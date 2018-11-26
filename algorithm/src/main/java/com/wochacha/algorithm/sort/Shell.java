package com.wochacha.algorithm.sort;

/**
 * @author wgh  2018/11/13
 * @add v1.0.0
 * @description 希尔排序
 */
public class Shell extends Example {

    public static void main(String[] args){
        Double[] a = getData(1000000);
//        Double[] a = {6.0, 5.0, 4.0, 3.0,2.0,1.0};
//        show(a);
        long startTime = System.currentTimeMillis();
        sort(a);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时 ：" + (endTime - startTime));
//        show(a);
    }

    public static void sort(Comparable[] a){
        int length = a.length;
        int h = 1;
        while (h < length / 3){
            //1, 4, 13, 40, 121...
            h = h * 3 + 1;
        }
        int num = 0;
        while (h >= 1){
            for (int i = h; i < length; i++){
//                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h){
//                    exch(a, j, j-h);
////                    show(a);
//                    num++;
//                }
                Comparable temp = a[i];
                int j = i;
                for (; j >= h && less(temp, a[j-h]); j -= h){
                    a[j] = a[j-h];
//                    show(a);
                    num++;
                }
                a[j] = temp;
            }
            h = h / 3;
        }
        System.out.println("num = " + num);
    }

}
