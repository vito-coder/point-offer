package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/26 21:41
 * @Version: 1.0
 * <p>
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class MyPower {
    public static void main(String[] args) {
        MyPower power = new MyPower();
        System.out.println(Integer.toBinaryString(10));
        System.out.println(power.myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        boolean negative = false;
        if (n < 0) {
            negative = true;
            n = (-1) * n;
        } else if (n == 0) {
            return 1.0;
        }
        if (x == 1.0) {
            return 1.0;
        }
        double sum = myPow(x, n-1) * x;
        if (negative) {
            return 1 / sum;
        }
        return sum;
    }
}
