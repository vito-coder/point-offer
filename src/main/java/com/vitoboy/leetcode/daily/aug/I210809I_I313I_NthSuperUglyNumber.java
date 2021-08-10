package com.vitoboy.leetcode.daily.aug;

import java.util.*;

/**
 * @problem leetcode
 * @description 313.超级丑数
 * 
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。 
 * 
 *  给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。 
 * 
 *  题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。 
 *
 *  示例 1：
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32 
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
 * 28,32] 。 
 * 
 *  示例 2：
 * 输入：n = 1, primes = [2,3,5]
 * 输出：1
 * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
 *
 *  提示：
 *  1 <= n <= 106 
 *  1 <= primes.length <= 100 
 *  2 <= primes[i] <= 1000 
 *  题目数据 保证 primes[i] 是一个质数 
 *  primes 中的所有值都 互不相同 ，且按 递增顺序 排列 
 *
 *  Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 
 *  👍 200 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/9
 */
public class I210809I_I313I_NthSuperUglyNumber {
    public static void main(String[] args) {
        I210809I_I313I_NthSuperUglyNumber uglyNumber = new I210809I_I313I_NthSuperUglyNumber();
        int[] primes = new int[]{2,7,13,19};
        System.out.println(uglyNumber.nthSuperUglyNumber(12, primes));
        System.out.println("expect is : 32");
    }


    /**
     * 				解答成功:
     * 				执行耗时:522 ms,击败了16.11% 的Java用户
     * 				内存消耗:163.7 MB,击败了21.42% 的Java用户
     *
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue = new PriorityQueue<>(n);
        queue.add(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        while (n-- > 0) {
            long x = queue.poll();
            if (n == 0) return (int) x;
            for (int prime : primes) {
                if (!set.contains(x*prime)){
                    set.add(x*prime);
                    queue.add(x*prime);
                }
            }
        }
        return -1;
    }
}
