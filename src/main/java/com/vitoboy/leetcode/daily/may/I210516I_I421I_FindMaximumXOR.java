package com.vitoboy.leetcode.daily.may;

/**
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
 * 
 *  进阶：你可以在 O(n) 的时间解决这个问题吗？ 
 *
 *  示例 1：
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28. 
 * 
 *  示例 2：
 * 输入：nums = [0]
 * 输出：0
 *  
 * 
 *  示例 3：
 * 输入：nums = [2,4]
 * 输出：6
 *  
 * 
 *  示例 4：
 * 输入：nums = [8,10,2]
 * 输出：10
 *  
 * 
 *  示例 5：
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 *
 *  提示：
 *  1 <= nums.length <= 2 * 10^4
 *  0 <= nums[i] <= 2^31 - 1
 *
 *  Related Topics 位运算 字典树 
 *  👍 361 👎 0
 * 
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/31
 */
public class I210516I_I421I_FindMaximumXOR {
    public static void main(String[] args) {

    }


    /**
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                max = Math.max(nums[i]^nums[j], max);
            }
        }
        return max;
    }

}
