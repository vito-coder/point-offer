package com.vitoboy.leetcode.daily.aug;

/**
 * @problem leetcode
 * @description 413.等差数列划分
 * 
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
 *
 *  例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。 
 *
 *  给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。 
 * 
 *  子数组 是数组中的一个连续序列。 
 *
 *  示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：3
 * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
 *  
 * 
 *  示例 2：
 * 输入：nums = [1]
 * 输出：0
 *
 *  提示：
 *  1 <= nums.length <= 5000 
 *  -1000 <= nums[i] <= 1000 
 *
 *  Related Topics 数组 动态规划 
 *  👍 298 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/10
 */
public class I210810I_I413I_NumberOfArithmeticSlices {
    public static void main(String[] args) {
        I210810I_I413I_NumberOfArithmeticSlices slices = new I210810I_I413I_NumberOfArithmeticSlices();
        int[] nums = new int[]{1,2,3,4};
        System.out.println(slices.numberOfArithmeticSlices(nums));
        System.out.println("expect is : 3");
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.2 MB,击败了54.57% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) return 0;
        int count = 2, diff = nums[1] - nums[0], ans = 0;
        for (int i = 2; i < nums.length; i++) {
            if (diff == nums[i] - nums[i-1]) {
                count++;
            } else {
                ans += (count-2)*(count-1)/2;
                count = 2;
                diff = nums[i] - nums[i-1];
            }
        }
        ans += (count-2)*(count-1)/2;

        return ans;
    }
}
