package com.vitoboy.leetcode.tags.dp.midle;

import java.util.Arrays;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
 * 
 *  数组中的每个元素代表你在该位置可以跳跃的最大长度。 
 * 
 *  你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
 * 
 *  假设你总是可以到达数组的最后一个位置。 
 *
 *  示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *  
 * 
 *  示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *  提示:
 *  1 <= nums.length <= 10^4
 *  0 <= nums[i] <= 1000 
 *  
 *  Related Topics 贪心 数组 动态规划 
 *  👍 1065 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/20
 */
public class I45I_Jump_II {
    public static void main(String[] args) {
        I45I_Jump_II jump_ii = new I45I_Jump_II();
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump_ii.jump(nums));
        System.out.println("expect is : 2");
        nums = new int[]{2,3,0,1,4};
        System.out.println(jump_ii.jump(nums));
        System.out.println("expect is : 2");

    }

    /**
     * 				解答成功:
     * 				执行耗时:43 ms,击败了12.71% 的Java用户
     * 				内存消耗:38.9 MB,击败了47.32% 的Java用户
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;
        Arrays.fill(dp, 1, nums[0]+1, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                int index = i+j;
                if(index >= len-1) {
                    return dp[i]+1;
                }
                if (dp[index] == 0) {
                    dp[index] = dp[i] + 1;
                }
            }
        }
        return dp[len-1];
    }
}
