package com.vitoboy.leetcode.pointoffer;

import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/7/1 16:10
 * @Version: 1.0
 *
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 12
 *          1,10,11,12
 * 输出：5
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：6
 *
 *
 * 限制：
 *
 * 1 <= n < 2^31
 */
public class XLIII_CountDigitOne {

    public static void main(String[] args) {
        XLIII_CountDigitOne countDigitOne = new XLIII_CountDigitOne();
        for (int i = 1; i <= 100; i++) {
            System.out.println(countDigitOne.countDigitOne(i));
        }
    }

    /**
     * 1
     * 10
     * 11
     * 12
     * ...
     * 19
     * 20
     * 21
     * 31
     * ..
     * 91
     * 100
     * 101
     * 102
     * ..
     * 110
     *
     * 个位时, 有 1次
     * 两位时, 有 1*9+10=19次
     * 三位时, 有 19*9+100=271次
     * 四位时, 有 271*9+1000=2439次
     *
     * 2147483647
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int[] temp = new int[10];
        temp[0] = 1;
        int ten = 1;
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i-1]*9 + ten*10;
            ten = ten*10;
        }
        int time = 0;
        int bit = 0;
        int sum = 0;
        while (n > 0) {
            bit = n % 10;
            if (bit != 0) {
                if (time == 0) {
                    sum += temp[time];
                    time++;
                } else {
                    sum += bit*temp[time];
                }
                sum += bit*temp[time-1];
            }
            n = n/10;
        }
        return sum;

    }
}
