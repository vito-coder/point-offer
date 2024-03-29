package com.vitoboy.leetcode.tags.dp.midle;

/**
 * @problem leetcode
 * @description 1567.乘积为正数的最长子数组长度
 * 
 * 给你一个整数数组 nums ，请你求出乘积为正数的最长子数组的长度。 
 * 
 *  一个数组的子数组是由原数组中零个或者更多个连续数字组成的数组。 
 * 
 *  请你返回乘积为正数的最长子数组长度。 
 *
 *  示例 1：
 *  输入：nums = [1,-2,-3,4]
 * 输出：4
 * 解释：数组本身乘积就是正数，值为 24 。
 *  
 * 
 *  示例 2：
 *  输入：nums = [0,1,-2,-3,-4]
 * 输出：3
 * 解释：最长乘积为正数的子数组为 [1,-2,-3] ，乘积为 6 。
 * 注意，我们不能把 0 也包括到子数组中，因为这样乘积为 0 ，不是正数。 
 * 
 *  示例 3：
 *  输入：nums = [-1,-2,-3,0,1]
 * 输出：2
 * 解释：乘积为正数的最长子数组是 [-1,-2] 或者 [-2,-3] 。
 *  
 * 
 *  示例 4：
 *  输入：nums = [-1,2]
 * 输出：1
 * 
 *  示例 5：
 *  输入：nums = [1,2,3,5,-6,4,0,10]
 * 输出：4
 *
 *  提示：
 *  1 <= nums.length <= 10^5 
 *  -10^9 <= nums[i] <= 10^9 
 *  
 *  Related Topics 贪心 数组 动态规划 
 *  👍 40 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/22
 */
public class I1567I_GetMaxLen {
    public static void main(String[] args) {
        I1567I_GetMaxLen maxLen = new I1567I_GetMaxLen();
        int[] nums = new int[]{1,2,3,5,-6,4,0,10};
        System.out.println(maxLen.getMaxLen(nums));
        System.out.println("expect is : 4");
        nums = new int[]{-1,-2,-3,0,1};
        System.out.println(maxLen.getMaxLen(nums));
        System.out.println("expect is : 2");
        nums = new int[]{1,-2,-3,4};
        System.out.println(maxLen.getMaxLen(nums));
        System.out.println("expect is : 4");
        nums = new int[]{5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2};
        System.out.println(maxLen.getMaxLen(nums));
        System.out.println("expect is : 8");
        nums = new int[]{1,2,3,5,-6,4,0,10};
        System.out.println(maxLen.getMaxLen(nums));
        System.out.println("expect is : 4");
        nums = new int[]{-16,0,-5,2,2,-13,11,8};
        System.out.println(maxLen.getMaxLen(nums));
        System.out.println("expect is : 6");
    }

    /**
     *
     * nums = [1,2,3,5,-6,4,0,10]
     * ==>
     * nums = [1,1,1,1,-1,1,0,1]
     * dp[0][0] = 1
     * dp[0][1] = 0
     *
     * dp[1][0] = 2
     * dp[1][1] = 0
     *
     * dp[2][0] = 3
     * dp[2][1] = 0
     *
     * dp[3][0] = 4
     * dp[3][1] = 0
     *
     * dp[4][0] = 0
     * dp[4][1] = 5
     *
     * dp[5][0] = 1
     * dp[5][1] = 5
     *
     * dp[6][0] = 0
     * dp[6][1] = 0
     *
     * dp[7][0] = 1
     * dp[7][1] = 0
     *
     * 				解答成功:
     * 				执行耗时:17 ms,击败了6.68% 的Java用户
     * 				内存消耗:53.7 MB,击败了98.43% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int getMaxLen(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0] > 0 ? 1 : 0;
        dp[0][1] = nums[0] < 0 ? 1 : 0;
        int max = dp[0][0];
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] > 0) {
                dp[i][0] = 1 + dp[i-1][0];
                dp[i][1] = dp[i-1][1] > 0 ? dp[i-1][1] + 1: 0;
            } else if (nums[i] < 0) {
                dp[i][0] = dp[i-1][1] > 0 ? dp[i-1][1]+1 : 0;
                dp[i][1] = 1 + dp[i-1][0];
            } else {
                dp[i][0] = dp[i][1] = 0;
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
    
}
