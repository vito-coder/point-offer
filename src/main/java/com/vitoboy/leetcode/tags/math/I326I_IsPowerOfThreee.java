package com.vitoboy.leetcode.tags.math;

/**
 * 
 * 
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
 * 
 *  整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x 
 *
 *  示例 1：
 * 输入：n = 27
 * 输出：true
 *  
 * 
 *  示例 2：
 * 输入：n = 0
 * 输出：false
 *  
 * 
 *  示例 3：
 * 输入：n = 9
 * 输出：true
 *  
 * 
 *  示例 4：
 * 输入：n = 45
 * 输出：false
 *
 *  提示：
 *  -2^31 <= n <= 2^31 - 1
 *
 *  进阶：
 *  你能不使用循环或者递归来完成本题吗？ 
 *  
 *  Related Topics 递归 数学 
 *  👍 167 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/1
 */
public class I326I_IsPowerOfThreee {
    public static void main(String[] args) {
        I326I_IsPowerOfThreee powerOfThreee = new I326I_IsPowerOfThreee();
        System.out.println(powerOfThreee.isPowerOfThree(27));
        System.out.println("expce is : true");
        System.out.println(powerOfThreee.isPowerOfThree(9));
        System.out.println("expect is : true");
        System.out.println(powerOfThreee.isPowerOfThree(45));
        System.out.println("expect is : false");

    }


    /**
     * 				解答成功:
     * 				执行耗时:16 ms,击败了64.75% 的Java用户
     * 				内存消耗:37.9 MB,击败了95.45% 的Java用户
     *
     * 时间复杂度: O(logN)
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        return true;
    }
    
}
