package com.vitoboy.leetcode.tags.array;

/**
 * 
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *  
 * 
 *  示例 2：
 * 输入：nums = [1]
 * 输出：1
 *  
 * 
 *  示例 3：
 * 输入：nums = [0]
 * 输出：0
 *  
 * 
 *  示例 4：
 * 输入：nums = [-1]
 * 输出：-1
 *  
 * 
 *  示例 5：
 * 输入：nums = [-100000]
 * 输出：-100000
 *  
 *
 *  提示：
 *  1 <= nums.length <= 3 * 104 
 *  -105 <= nums[i] <= 105 
 *  
 *
 *  进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
 *  Related Topics 数组 分治算法 动态规划 
 *  👍 3265 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/31
 */
public class I53I_MaxSubArray {
    public static void main(String[] args) {


    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了95.37% 的Java用户
     * 				内存消耗:38.4 MB,击败了44.21% 的Java用户
     *
     * 时间复杂度: O(N) 只需要遍历数组一遍即可
     * 空间复杂度: O(1) 使用了固定数量的变量
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE < nums[0] ? nums[0] : Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i]+nums[i-1]);
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * 记录官方题解
     *
     * 时间复杂度与空间复杂度与自己实现的差不多
     *
     * @param nums
     * @return
     */
    public int maxSubArrayII(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
