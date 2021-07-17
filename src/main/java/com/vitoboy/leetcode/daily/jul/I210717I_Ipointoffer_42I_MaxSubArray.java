package com.vitoboy.leetcode.daily.jul;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
 * 
 *  要求时间复杂度为O(n)。 
 *
 *  示例1:
 *  输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
 *
 *  提示：
 *  1 <= arr.length <= 10^5 
 *  -100 <= arr[i] <= 100 
 *
 *  注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
 * 
 *  
 *  Related Topics 数组 分治 动态规划 
 *  👍 318 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/17
 */
public class I210717I_Ipointoffer_42I_MaxSubArray {
    public static void main(String[] args) {
        I210717I_Ipointoffer_42I_MaxSubArray array = new I210717I_Ipointoffer_42I_MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(array.maxSubArray(nums));
        System.out.println("expect is : 6");
    }

    /**
     * 最初最大子串一定为自己
     * 比较自己 与 自己和上一次的最大子串的和 谁大, 则当前位置即为 最大者(可以是自己, 也可以是 自己 + 上个子串的和)
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了98.83% 的Java用户
     * 				内存消耗:45 MB,击败了31.88% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(1)
     *
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if (nums.length == 1) return nums[0]; // ?
        int sum = nums[0], max = sum;
        for (int i = 1, len = nums.length; i < len; i++) {
            if (nums[i] > nums[i] + sum) {
                sum = nums[i];
            } else {
                sum += nums[i];
                nums[i] = sum;
            }
            max = Math.max(sum, max);
        }

        return max;
    }
}
