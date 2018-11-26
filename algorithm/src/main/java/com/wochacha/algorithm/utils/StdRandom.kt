package com.wochacha.algorithm.utils

import android.support.annotation.NonNull

/**
 * @author wgh  2018/10/26
 * @add v1.0.0
 * @description
 */
object StdRandom {

    fun random(): Double{
        return Math.random()
    }

    fun setSeed(seed: Long){

    }

    /**
     * 随机返回[0, N)之间的一个int值
     */
    fun uniform(N: Int) : Int{
        if (N < 0){
            throw IllegalArgumentException("Parameter N must be positive")
        }
        return (StdRandom.random() * N).toInt()
    }

    /**
     * 随机返回[lo, hi)之间的一个int值
     */
    fun uniform(lo: Int, hi: Int) : Int {
        if (hi < lo) {
            throw IllegalArgumentException("Invalid range")
        }
        return lo + StdRandom.uniform(hi - lo)
    }

    /**
     * 随机返回[0, N)之间的一个double值
     */
    fun uniform(N: Double) : Double{
        if (N < 0){
            throw IllegalArgumentException("Parameter N must be positive")
        }
        return (StdRandom.random() * N)
    }

    /**
     * 随机返回[lo, hi)之间的一个double值
     */
    fun uniform(lo: Double, hi: Double) : Double{
        if (hi < lo) {
            throw IllegalArgumentException("Invalid range")
        }
        return (((lo + StdRandom.uniform(hi - lo)) * 100).toInt()) / 100.0
    }

    /**
     * 根据离散概率随机返回的int值（出现i的概率为a[index]）
     */
    fun discrete(@NonNull list : List<Double>) : Int{
        //a中的各元素之和必须等于1
        val r = StdRandom.random()
        var sum = 0.0
        for ((index, i) in list.withIndex()){
            sum += i
            if (sum >= r){
                return index
            }
        }
        return -1
    }

    /**
     * 随机将double数据中的元素排序
     */
    fun shuffle(@NonNull list : MutableList<Double>){
        for ((index, i) in list.withIndex()){
            val r = index + StdRandom.uniform(list.size - 1)
            var temp = list[index]
            list[index] = list[r]
            list[r] = temp
        }
    }
}