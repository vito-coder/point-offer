package com.vitoboy.leetcode.pointoffer;

import java.util.Arrays;

/**
 * @Author: vito
 * @Date: 2020/7/2 17:24
 * @Version: 1.0
 *
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，
 * 在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 *
 * 限制：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class LVII_TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{10,26,30,31,47,60};
        LVII_TwoSum sum = new LVII_TwoSum();
        System.out.println(Arrays.toString(sum.twoSum(nums, 40)));
//
//
        nums = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(sum.twoSum(nums, 9)));

        // [14,15,16,22,53,60]
        //76
        nums = new int[]{14,15,16,22,53,60};
        System.out.println(Arrays.toString(sum.twoSumUpdate(nums, 76)));


    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) return new int[0];
        int height = nums.length;
        for (int i = 0; i < nums.length && i<height; i++) {
            int low = i;
            for (int j = (low+height)/2; j < height && j > low ;) {
                if (nums[i] + nums[j] == target) return new int[]{nums[i], nums[j]};
                if (nums[i] + nums[j] > target) {
                    // 向下找
                    height = j;
                    j = (low+height)/2;
                } else {
                    // 向上找
                    low = j;
                    j = (low+height)/2;
                }
            }
        }
        return new int[0];
    }


    public int[] twoSumUpdate(int[] nums, int target) {
        if (nums == null || nums.length <= 1) return new int[0];
        for (int i = 0, j = nums.length-1; j > i; ) {
            if (nums[i] + nums[j] == target) return new int[]{nums[i],nums[j]};
            if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return  new int[0];
    }
}
