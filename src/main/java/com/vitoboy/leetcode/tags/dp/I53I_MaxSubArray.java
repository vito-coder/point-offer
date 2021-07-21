package com.vitoboy.leetcode.tags.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
 *
 *  示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 *  示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 *  示例 3：
 * 输入：nums = [0]
 * 输出：0
 *
 *  示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 *
 *  示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *  提示：
 *  1 <= nums.length <= 3 * 104 
 *  -105 <= nums[i] <= 105 
 *
 *  进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
 *  Related Topics 数组 分治 动态规划 
 *  👍 3449 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/21
 */
public class I53I_MaxSubArray {
    public static void main(String[] args) {
        I53I_MaxSubArray subArray = new I53I_MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(subArray.maxSubArray(nums));
        System.out.println("expect is : 6");
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了94.94% 的Java用户
     * 				内存消耗:38.4 MB,击败了56.91% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0], tmp = 0;
        for (int i = 1, len = nums.length; i < len; i++) {
            tmp = nums[i] + nums[i-1];
            if (tmp > nums[i]) {
                nums[i] = tmp;
            }
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
