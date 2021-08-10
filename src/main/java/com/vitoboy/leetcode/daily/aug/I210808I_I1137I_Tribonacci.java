package com.vitoboy.leetcode.daily.aug;

/**
 * @problem leetcode
 * @description 1137.第N个泰波那契数
 * 
 * 泰波那契序列 Tn 定义如下： 
 * 
 *  T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
 * 
 *  给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
 *
 *  示例 1：
 *  输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 *
 *  示例 2：
 *  输入：n = 25
 * 输出：1389537
 *
 *  提示：
 *  0 <= n <= 37 
 *  答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
 *  
 *  Related Topics 记忆化搜索 数学 动态规划 
 *  👍 115 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/8
 */
public class I210808I_I1137I_Tribonacci {
    public static void main(String[] args) {
        I210808I_I1137I_Tribonacci tribonacci = new I210808I_I1137I_Tribonacci();
        System.out.println(tribonacci.tribonacci(4));
        System.out.println("expect is : 4");
        System.out.println(tribonacci.tribonacci(25));
        System.out.println("expect is : 1389537");
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35 MB,击败了78.84% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int T0 = 0, T1 = 1, T2 = 1;
        int count = 2;
        while (count < n) {
            T0 = T0 + T1 + T2;
            if (++count == n) return T0;
            T1 = T0 + T1 + T2;
            if (++count == n) return T1;
            T2 = T0 + T1 + T2;
            ++count;
        }
        return T2;
    }
}
