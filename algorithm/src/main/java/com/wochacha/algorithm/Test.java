package com.wochacha.algorithm;

import com.wochacha.algorithm.utils.StdRandom;

/**
 * @author wgh  2018/10/26
 * @add v1.0.0
 * @description
 */
public class Test {

    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.printf("%.2f\n", StdRandom.INSTANCE.random());
        }
    }

}
