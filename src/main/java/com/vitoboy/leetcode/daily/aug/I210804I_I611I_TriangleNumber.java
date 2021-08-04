package com.vitoboy.leetcode.daily.aug;

import java.util.Arrays;

/**
 * @problem leetcode
 * @description 611.有效三解形的个数
 * 
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
 * 
 *  示例 1:
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是: 
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *  
 * 
 *  注意:
 *  数组长度不超过1000。 
 *  数组里整数的范围为 [0, 1000]。 
 *  
 *  Related Topics 贪心 数组 双指针 二分查找 排序 
 *  👍 225 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/4
 */
public class I210804I_I611I_TriangleNumber {
    public static void main(String[] args) {
        I210804I_I611I_TriangleNumber triangle = new I210804I_I611I_TriangleNumber();
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangle.triangleNumber(nums));
        System.out.println("expect is : 3");
        nums = new int[]{2,2,3,4,5,6,7,8,9,9};
        System.out.println(triangle.triangleNumber(nums));
        System.out.println("expect is : 62");
        nums = new int[]{2,2,3,4,5,6,7,8,9,9,9,9};
        System.out.println(triangle.triangleNumber(nums));
        System.out.println("expect is : 132");
        nums = new int[]{2,2,3,4,5,6,7,8,9,9,9,9,111};
        System.out.println(triangle.triangleNumber(nums));
        System.out.println("expect is : 132");
    }

    /**
     * 				解答成功:
     * 				执行耗时:202 ms,击败了33.95% 的Java用户
     * 				内存消耗:38.5 MB,击败了5.07% 的Java用户
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int len = nums.length, total = 0, index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int[] range = getThirdSide(nums[i], nums[j]);
                index = findMaxSideIndex(nums, range[0], range[1], j+1);
                if (index > 0) {
                    total += (index - j);
                }
            }
        }
        return total;
    }

    private int[] getThirdSide(int x, int y) {
        return new int[]{Math.abs(x-y)+1,x+y-1};
    }

    private int findMaxSideIndex(int[] nums, int minTarget, int maxTarget, int low) {
        int high = nums.length;
        if (low >= high) return -1;
        if (maxTarget < nums[low]) return -1;
        if (minTarget > nums[high-1]) return -1;
        if (maxTarget >= nums[high-1]) return high-1;
        while (low < high) {
            int mid = low+(high-low)/2;
            if (maxTarget == nums[mid]) {
                if (mid < nums.length-1 && nums[mid+1] == maxTarget) {
                    low = mid+1;
                } else {
                    return mid;
                }
            } else if (maxTarget > nums[mid]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        if (nums[low] <= maxTarget) return low;
        return low-1;
    }
}
