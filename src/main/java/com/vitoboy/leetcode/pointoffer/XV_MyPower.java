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
public class XV_MyPower {
    public static void main(String[] args) {
        XV_MyPower power = new XV_MyPower();
//        System.out.println(Integer.toBinaryString(10));
        System.out.println(power.myPow(2.0, -1));
        System.out.println(power.myPow(0.00001,2147483647));
    }

    /**
     * 解题思路：
     * 求 x^n
     *  最简单的方法是通过循环将 n 个 x 乘起来，依次求 x^1, x^2, ..., x^{n-1}, x^n, 时间复杂度为 O(n) 。
     * 快速幂法 可将时间复杂度降低至 O(log_2 n) ，以下从 “二分法” 和 “二进制” 两个角度解析快速幂法。
     *
     * 算法流程：
     * 当 x = 0x=0 时：直接返回 00 （避免后续 x = 1 / xx=1/x 操作报错）。
     * 初始化 res = 1res=1 ；
     * 当 n < 0n<0 时：把问题转化至 n \geq 0n≥0 的范围内，即执行 x = 1/xx=1/x ，n = - nn=−n ；
     * 循环计算：当 n = 0n=0 时跳出；
     * 当 n \& 1 = 1n&1=1 时：将当前 xx 乘入 resres （即 res *= xres∗=x ）；
     * 执行 x = x^2（即 x *= x ）；
     * 执行 nn 右移一位（即 n >>= 1n>>=1）。
     * 返回 resres 。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
