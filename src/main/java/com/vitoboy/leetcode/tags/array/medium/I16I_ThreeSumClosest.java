package com.vitoboy.leetcode.tags.array.medium;

import java.util.Arrays;

/**
 * 
 * @problem leetcode
 * @description 16.最接近的三数之和
 * 
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
 * 。假定每组输入只存在唯一答案。 
 *
 *  示例：
 *  输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *  提示：
 *  3 <= nums.length <= 10^3 
 *  -10^3 <= nums[i] <= 10^3 
 *  -10^4 <= target <= 10^4 
 *  
 *  Related Topics 数组 双指针 排序 
 *  👍 848 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/16
 */
public class I16I_ThreeSumClosest {
    public static void main(String[] args) {
        
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) return Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int n = nums.length, cidx = binarySearchIndex(nums, target), sum = 0;
        if (target == 0) return nums[0] + nums[1] + nums[2];
        return 0;
    }

    private int binarySearchIndex(int[] sort, int target) {
        int n = sort.length;
        if (target >= sort[n-1]) return n;
        if (target <= sort[0]) return 0;
        int low =0, high = n;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (target == sort[mid]) return mid;
            else if (target < sort[mid]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    
}
