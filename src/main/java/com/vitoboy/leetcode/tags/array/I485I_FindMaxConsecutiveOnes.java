package com.vitoboy.leetcode.tags.array;

/**
 * 
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。 
 *
 *  示例：
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * 
 *  提示：
 *  输入的数组只包含 0 和 1 。 
 *  输入数组的长度是正整数，且不超过 10,000。 
 *  
 *  Related Topics 数组 
 *  👍 249 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/7
 */
public class I485I_FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        I485I_FindMaxConsecutiveOnes consecutiveOnes = new I485I_FindMaxConsecutiveOnes();
        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println(consecutiveOnes.findMaxConsecutiveOnes(nums));
        System.out.println("expect is : 3");


    }


    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:40 MB,击败了44.30% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     * 
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, count);
                count = 0;
            } else {
                count++;
            }
        }
        return Math.max(max, count);
    }
    
}
