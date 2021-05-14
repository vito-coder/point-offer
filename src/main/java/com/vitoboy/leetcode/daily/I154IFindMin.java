package com.vitoboy.leetcode.daily;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变
 * 化后可能得到：
 *  
 *  若旋转 4 次，则可以得到 [4,5,6,7,0,1,4] 
 *  若旋转 7 次，则可以得到 [0,1,4,4,5,6,7] 
 *  
 * 
 *  注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
 * ..., a[n-2]] 。 
 * 
 *  给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：nums = [1,3,5]
 * 输出：1
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  n == nums.length 
 *  1 <= n <= 5000 
 *  -5000 <= nums[i] <= 5000 
 *  nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
 *  
 * 
 *  
 * 
 *  进阶： 
 * 
 *  
 *  这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
 *  允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
 *  
 *  Related Topics 数组 二分查找 
 *  👍 334 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/4/9 下午10:52
 * @Version: 1.0
 */
public class I154IFindMin {
    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums = new int[]{1,3,5};
        System.out.println("result is : " + findMin.findMin(nums));
        System.out.println("expect is : 1");
        nums = new int[]{2,2,2,0,1};
        System.out.println("result is : " + findMin.findMin(nums));
        System.out.println("expect is : 0");
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.2 MB,击败了67.25% 的Java用户
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    static class FindMin {
        public int findMin(int[] nums) {
            int len = nums.length;
            if (nums[0] < nums[len - 1]) {
                return nums[0];
            }
            // 使用二分法处理
            if (nums[0] > nums[len - 1]) {
                int left = 0, right = len - 1;
                int mid = 0;
                while (left < right) {
                    mid = left + (right - left) / 2;
                    if (nums[mid] >= nums[left]) {
                        if (nums[mid] >= nums[0]) {
                            left = mid + 1;
                        } else {
                            return nums[left];
                        }
                    } else {
                        right = mid;
                    }
                }
                return nums[left];
            }
            // 使用夹逼法处理
            if (nums[0] == nums[len - 1]) {
                int equal = nums[0];
                int left = 0, right = len - 1;
                int mid = 0;
                while (left < right) {
                    if (nums[left] == equal && nums[right] == equal) {
                        left++;
                        right--;
                    } else if (nums[left] == nums[right]) {
                        if (nums[left] > equal) return equal;
                        return nums[left];
                    } else if (nums[left] < nums[right]) {
                        if (nums[left] > equal) return equal;
                        return nums[left];
                    } else {
                        mid = left + (right - left) / 2;
                        if (nums[mid] >= nums[left]) {
                            left = mid + 1;
                        } else {
                            right = mid;
                        }
                    }
                }
                return nums[left] > equal ? equal : nums[left];
            }
            return 0;
        }
    }
}
