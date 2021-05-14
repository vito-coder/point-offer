package com.vitoboy.other;

import java.util.*;

/**
 * 林新居先生的《满溪流水香》中， 记载了一首著名的茶壶诗（《清心也可以》）》）
 *
 * 心也可以清
 * 清心也可以
 * 以清心也可
 * 可以清心也
 *
 * 这句诗的妙处在于，从句中任意一个字开始读，都是一个有完整意义的句子。
 *
 * 正题
 * 数字中也有这样奇妙的例子。我们拿1/7举例
 *
 * 1/7 = 0.142857...无限循环
 * 2/7 = 0.285714...
 * 3/7 = 0.428571...
 * 4/7 = 0.571428...
 * 5/7 = 0.714285...
 * 6/7 = 0.857142...
 * 任意一个小于7的数字，除以7的结果，都等于1/7左移L位的小数部分（例如2/7的结果是1/7结果小数左移2位）。
 * 那我们定义这个数字7，是一个上帝的数字，包含了无限轮回。
 *
 * 请编写程序算出小于某自然数100的所有轮回数，语言不限。
 *
 * @Author: vito
 * @Date: 2021/2/5 下午3:40
 * @Version: 1.0
 */
public class UnLimitCycle {
    // todo 待解决问题
    public static void main(String[] args) {
        UnLimitCycle cycle = new UnLimitCycle();
        List<Integer> list = cycle.getUnlimitCycle(100);
        System.out.println(list);

    }

    /**
     * 解,
     * 1.从需要被1到数字之间都不能整除, 是否可以认定符合题目的数, 首先是质数? --> 可以
     * 2. 从质数暴力计算, 每个质数是否满足要求
     */
    public Set<Integer> prime(int len) {
        if (len > 100000 || len <= 0) {
            return null;
        }
        Set<Integer> integers = new HashSet<>();
        boolean[] primeNum = new boolean[len+1];
        Arrays.fill(primeNum, true);
        for (int i = 2; i <= Math.sqrt(len); i++) {
            for (int j = 2; i*j <= len; j++) {
                primeNum[i*j] = false;
            }
        }
        for (int i = 2; i <= len; i++) {
            if (primeNum[i]){
                integers.add(i);
            }
        }
        return integers;
    }


    public List<Integer> getUnlimitCycle(int len) {
        Set<Integer> set = prime(len);
        if (set.size() <= 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : set) {
            if (integer < 7){
                continue;
            }
            boolean[] array = new boolean[integer];
            Arrays.fill(array, false);
            int count = 10;
            int i = 0;
            for (; i < integer && count != 1 ; i++) {
                if (count > integer) {
                    if (array[count%integer]) {
                        break;
                    } else {
                        array[count%integer] = true;
                        count = count%integer;
                    }
                } else {
                    count = count * 10;
                    if (count > integer) {
                        if (array[count%integer]) {
                            break;
                        } else {
                            array[count%integer] = true;
                            count = count%integer;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (count == 1 ) {
                list.add(integer);
            }
        }
        return list;
    }


    public List<Integer> getUnlimitCycleI(int len) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        for (int i = 8; i < len; i++) {
            int temp = 10;
            for (int j = 1; j < i; j++) {

            }
        }
        return list;
    }

}
