package com.vitoboy.leetcode;

import java.util.Arrays;

/**
 * @Author: vito
 * @Date: 2020/6/27 17:04
 * @Version: 1.0
 *
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class XVI_PrintNumbers {
    public static void main(String[] args) {

        XVI_PrintNumbers printNumbers = new XVI_PrintNumbers();
        int[] print = printNumbers.printNumbers(0);
        System.out.println(Arrays.toString(print));

    }

    public int[] printNumbers(int n) {
        if (n <= 0) return new int[0];
        int max = pow(10, n);
        if (max < 10) return new int[0];
        int[] numbers = new int[max-1];
        for (int i = 0; i < max-1; ++i) {
            numbers[i] = i+1;
        }
        return numbers;
    }

    public int pow(int x, int n) {
        if (n == 0 || x == 1) return 1;
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        int res = 1;
        while (n > 0) {
            if (n%2 == 1) res *= x;
            x *= x;
            n = n /2;
        }
        return res;
    }

    /**
     * 官方解题
     *
     * @param n
     * @return
     */
    public int[] printNumbersOfficial(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] result = new int[end];
        for (int i = 0; i < end; i++) {
            result[i] = i+1;
        }
        return result;
    }
}
