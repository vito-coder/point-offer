package com.vitoboy.leetcode.tags.math;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
 * 
 *  进阶：不要 使用任何内置的库函数，如 sqrt 。 
 *
 *  示例 1：
 * 输入：num = 16
 * 输出：true
 *  
 * 
 *  示例 2：
 * 输入：num = 14
 * 输出：false
 *
 *  提示：
 *  1 <= num <= 2^31 - 1 
 *  
 *  Related Topics 数学 二分查找 
 *  👍 229 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/1
 */
public class I367I_IsPerfectSquare {
    public static void main(String[] args) {
        I367I_IsPerfectSquare square = new I367I_IsPerfectSquare();
        System.out.println(square.isPerfectSquare(16));
        System.out.println("expect is : true");
        System.out.println(square.isPerfectSquare(14));
        System.out.println("expect is : false");
        System.out.println(square.isPerfectSquare(345));
        System.out.println("expect is : false");

    }

    /**
     * todo
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num, mid = 1, tmp = 0;
        while (low < high) {
            mid = low + (high-low)/2;
            tmp = num/mid;
            if (tmp == mid) return true;
            else if (tmp > mid) {
                high = mid-1;
            } else {
                low = mid;
            }
        }
        return false;
    }
}
