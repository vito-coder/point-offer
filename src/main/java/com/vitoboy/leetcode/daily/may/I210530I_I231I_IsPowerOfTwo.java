package com.vitoboy.leetcode.daily.may;

/**
 * 
 * 
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 
 * 
 *  如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 *  
 * 
 *  示例 3： 
 * 
 *  
 * 输入：n = 3
 * 输出：false
 *  
 * 
 *  示例 4： 
 * 
 *  
 * 输入：n = 4
 * 输出：true
 *  
 * 
 *  示例 5： 
 * 
 *  
 * 输入：n = 5
 * 输出：false
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  -2^31 <= n <= 2^31 - 1
 *  
 * 
 *  
 * 
 *  进阶：你能够不使用循环/递归解决此问题吗？ 
 *  Related Topics 位运算 数学 
 *  👍 366 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/30
 */
public class I210530I_I231I_IsPowerOfTwo {
    public static void main(String[] args) {

    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if(n == 1 || n == 2) {
            return true;
        }
        while (n > 0) {
            if(n == 2) return true;
            if(n%2 == 1) return false;
            n = n/2;
        }
        return true;

    }
}
