package com.vitoboy.leetcode.tags.math;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。 
 * 
 *  给定一个 整数 n， 如果是完美数，返回 true，否则返回 false 
 *
 *  示例 1：
 *  输入：28
 * 输出：True
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 * 1, 2, 4, 7, 和 14 是 28 的所有正因子。 
 * 
 *  示例 2：
 *  输入：num = 6
 * 输出：true
 *
 *  示例 3：
 *  输入：num = 496
 * 输出：true
 *
 *  示例 4：
 *  输入：num = 8128
 * 输出：true
 *  
 * 
 *  示例 5：
 *  输入：num = 2
 * 输出：false
 *
 *  提示：
 *  1 <= num <= 10^8
 *  
 *  Related Topics 数学 
 *  👍 89 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/9
 */
public class I507I_CheckPerfectNumber {
    public static void main(String[] args) {
        I507I_CheckPerfectNumber number = new I507I_CheckPerfectNumber();
        System.out.println(number.checkPerfectNumber(28));
        System.out.println("expect is : true");
        System.out.println(number.checkPerfectNumber(496));
        System.out.println("expect is : true");
        System.out.println(number.checkPerfectNumber(8128));
        System.out.println("expect is : true");
        System.out.println(number.checkPerfectNumber(2));
        System.out.println("expect is : false");

    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了90.74% 的Java用户
     * 				内存消耗:35.1 MB,击败了73.92% 的Java用户
     *
     * 时间复杂度: O(logN)
     * 空间复杂度: 1
     *
     * @param num
     * @return
     */
    public boolean checkPerfectNumber(int num) {
        if(num <= 1) return false;
        int sum = 1, sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += (i + num/i);
            }
        }
        if (sum == num) return true;
        return false;
    }
}
