package com.vitoboy.leetcode.daily.jul;

import java.util.Arrays;
import java.util.Map;

/**
 * 
 * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。 
 *
 *  比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 
 * 8 。 
 *
 *  给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得： 
 *
 *  nums 中每个元素 恰好 在 一个 数对中，且 
 *  最大数对和 的值 最小 。 
 *
 *  请你在最优数对划分的方案下，返回最小的 最大数对和 。 
 *
 *  示例 1：
 *  输入：nums = [3,5,2,3]
 * 输出：7
 * 解释：数组中的元素可以分为数对 (3,3) 和 (5,2) 。
 * 最大数对和为 max(3+3, 5+2) = max(6, 7) = 7 。
 *  
 * 
 *  示例 2：
 *  输入：nums = [3,5,4,2,4,6]
 * 输出：8
 * 解释：数组中的元素可以分为数对 (3,5)，(4,4) 和 (6,2) 。
 * 最大数对和为 max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8 。
 *
 *  提示：
 *  n == nums.length 
 *  2 <= n <= 10^5
 *  n 是 偶数 。 
 *  1 <= nums[i] <= 10^5
 *  
 *  Related Topics 贪心 数组 双指针 排序 
 *  👍 21 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/20
 */
public class I210720I_I1877I_MinPairSum {
    public static void main(String[] args) {
        I210720I_I1877I_MinPairSum sum = new I210720I_I1877I_MinPairSum();
        int[] nums = new int[]{3,5,2,3};
        System.out.println(sum.minPairSum(nums));
        System.out.println("expect is : 7");
        nums = new int[]{3,5,4,2,4,6};
        System.out.println(sum.minPairSum(nums));
        System.out.println("expect is : 8");

    }

    /**
     * 				解答成功:
     * 				执行耗时:58 ms,击败了99.00% 的Java用户
     * 				内存消耗:54 MB,击败了53.00% 的Java用户
     *
     * 时间复杂度: O(logN + N)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0, j=nums.length-1; i < j; i++, j--) {
            max = Math.max(nums[i]+nums[j], max);
        }

        return max;
    }
}
