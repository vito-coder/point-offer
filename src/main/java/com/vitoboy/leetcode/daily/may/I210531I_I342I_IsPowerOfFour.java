package com.vitoboy.leetcode.daily.may;

/**
 * 
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。 
 * 
 *  整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 * 
 *  
 * 
 *  示例 1：
 * 输入：n = 16
 * 输出：true
 *  
 * 
 *  示例 2：
 * 输入：n = 5
 * 输出：false
 *  
 * 
 *  示例 3：
 * 输入：n = 1
 * 输出：true
 *  
 * 
 *  
 * 
 *  提示：
 *  -2^31 <= n <= 2^31 - 1
 *
 *  进阶：
 *  你能不使用循环或者递归来完成本题吗？ 
 *  
 *  Related Topics 位运算 
 *  👍 208 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/31
 */
public class I210531I_I342I_IsPowerOfFour {
    public static void main(String[] args) {

    }

    /**
     * 执行结果：通过
     * 执行用时： 1 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.4 MB, 在所有 Java 提交中击败了 79.95% 的用户
     */
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        if(n == 1 || n == 4) return true;
        while(n > 0) {
            if(n == 4) return true;
            if(n%4 != 0) return false;
            n = n/4;
        }
        return false;
    }


}
