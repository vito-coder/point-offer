package com.vitoboy.leetcode.pointoffer;

/**
 * @Author: vito
 * @Date: 2020/7/1 16:03
 * @Version: 1.0
 *
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class XLII_MaxSubArray {

    public static void main(String[] args) {
        XLII_MaxSubArray maxSubArray = new XLII_MaxSubArray();
        int[] num = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("result is : " + maxSubArray.maxSubArray(num));
        System.out.println("expcet is : 6");
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了98.51% 的Java用户
     * 				内存消耗:44.9 MB,击败了58.36% 的Java用户
     *
     * nums = {6,-1,3,-4,-6,9,2,-2,5}
     * result = {6, max(-1, 6-1)=5, max(3, 5+3)=8, max(-4, 8-4)=4, max(-6, 4-6)=-2, max(9, 9-2)=9, max(2,9+2)=11, max(-2, 11-2)=9, max(5, 9+5)=14}
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 0; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
