package com.vitoboy.leetcode;

import javax.swing.plaf.IconUIResource;

/**
 * @Author: vito
 * @Date: 2020/7/2 00:34
 * @Version: 1.0
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 */
public class LII_Search {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        LII_Search search = new LII_Search();
        System.out.println(search.search(nums, 6));
        nums = new int[]{2,2};
        System.out.println(search.search(nums, 2));
    }


    /**
     * 利用题目的规则  有序增
     * 使用二分查找即可实现 双100%
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length-1]) return 0;
        int height = nums.length;
        int low = 0;
        int half = (height + low) / 2;
        while (half < height && half > low && height > low && nums[half] != target){
            if (nums[half] > target) {
                height = half;
                half = (height+low) / 2;
            } else {
                low = half;
                half = (height + low) / 2;
            }
        }
        int count = 0;
        if (nums[half] == target) {
            count++;
            height = half+1;
            while (height < nums.length && nums[height] == target) {
                count++;
                height++;
            }
            low = half-1;
            while (low >= 0 && nums[low] == target) {
                count++;
                low--;
            }
        }
        return count;
    }
}
