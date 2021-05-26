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
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        // todo
        return 0;

    }
}
