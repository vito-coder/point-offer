package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/7/15 16:45
 * @Version: 1.0
 *
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，
 * 从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class LXVII_LastRemaining {
    public static void main(String[] args) {
        LXVII_LastRemaining remaining = new LXVII_LastRemaining();

        remaining.lastRemaining(0, 0);
    }

    public int lastRemaining(int n, int m) {

        return 0;
    }

}
