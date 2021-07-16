package com.vitoboy.leetcode.daily.jul;

/**
 * 
 * 统计一个数字在排序数组中出现的次数。 
 *
 *  示例 1:
 *  输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2 
 * 
 *  示例 2:
 *  输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0 
 *
 *  限制：
 *  0 <= 数组长度 <= 50000 
 *
 *  注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
 * position-of-element-in-sorted-array/ 
 *  Related Topics 数组 二分查找 
 *  👍 165 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/16
 */
public class I210716I_Ipointoffer_53_I_I_Search {
    public static void main(String[] args) {
        I210716I_Ipointoffer_53_I_I_Search search = new I210716I_Ipointoffer_53_I_I_Search();
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(search.search(nums, 8));
        System.out.println("expect is : 2");
        System.out.println(search.search(nums, 6));
        System.out.println("expect is : 0");
        System.out.println(search.search(nums,7));
        System.out.println("expect is : 2");
        System.out.println(search.search(nums,5));
        System.out.println("expect is : 1");
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:41.5 MB,击败了23.91% 的Java用户
     * 	时间复杂度: O(logN)
     * 	空间复杂度: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (target < nums[0] || target > nums[nums.length-1]) return 0;
        int count = 0, low = 0, high = nums.length;
        while (low<high) {
            int mid = low + (high-low)/2;
            if (nums[mid] == target) {
                for (int i = mid; i < nums.length ; i++) {
                    if (nums[i] == target) count++;
                    else break;
                }
                for (int i=mid-1; i>=0; i--) {
                    if (nums[i] == target) count++;
                    else break;
                }
                return count;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return count;
    }
}
