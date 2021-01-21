package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/19 14:59
 * @Version: 1.0
 *
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 * @see     VII_Fibonacci
 */
public class VIII_NumWays {
    public static void main(String[] args) {

        System.out.println(numWays(7));
    }

    public static int numWays(int n) {
        int f1 = 1;
        int f2 = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
}
