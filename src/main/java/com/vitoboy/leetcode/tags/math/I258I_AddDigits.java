package com.vitoboy.leetcode.tags.math;

/**
 * 
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。 
 * 
 *  示例: 
 * 
 *  输入: 38
 * 输出: 2 
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 *  
 * 
 *  进阶: 
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？ 
 *  Related Topics 数学 数论 模拟 
 *  👍 346 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/30
 */
public class I258I_AddDigits {
    public static void main(String[] args) {
        I258I_AddDigits digits = new I258I_AddDigits();
        System.out.println(digits.addDigits(123));
        System.out.println(digits.addDigits(38));

    }


    /**
     * 解答成功:
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:35 MB,击败了99.85% 的Java用户
     * 时间复杂度: O(log10 N)
     * 空间复杂度: O(1)
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (true) {
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            if (sum < 10) return sum;
            num = sum;
        }
    }

    /**
     * 思考一下:
     *  num = x*100 + y*10 + z
     *  ==> x*99 + y*9 + x+y+z
     *  ==> num % 9 == (x+y+z) % 9
     *  再考虑一下特殊值 : 81 , 9, 99 等
     *  ==> (num - 1) % 9 + 1 == 80 % 9 +1 == 9
     *
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     *
     * @param num
     * @return
     */
    public int addDigitsII(int num) {
        return (num-1) % 9 + 1;
    }
}
