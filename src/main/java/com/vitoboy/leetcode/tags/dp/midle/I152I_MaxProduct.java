package com.vitoboy.leetcode.tags.dp.midle;

/**
 * @problem: leetcode
 * @description: 152.乘积最大的子数组
 * 
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
 *
 *  示例 1:
 *  输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 *  示例 2:
 *  输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
 *  Related Topics 数组 动态规划 
 *  👍 1191 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/21
 */
public class I152I_MaxProduct {
    public static void main(String[] args) {
        I152I_MaxProduct product = new I152I_MaxProduct();
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(product.maxProduct(nums));
        System.out.println("expect is : 6");
        nums = new int[]{-2,0,-1};
        System.out.println(product.maxProduct(nums));
        System.out.println("expcet is : 0");
        nums = new int[]{2,3,-2,4,-1,-8,9,3,2};
        System.out.println(product.maxProduct(nums));
        System.out.println("expect is : 1728");
    }

    /**
     *				解答成功:
     * 				执行耗时:2 ms,击败了87.65% 的Java用户
     * 				内存消耗:38.3 MB,击败了40.78% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(1)
     *
     * 	todo
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length, min = nums[0], max = nums[0], ans=nums[0];
        for (int i = 1; i < len; i++) {
            int mn = min, xn = max;
            min = Math.min(mn*nums[i], Math.min(nums[i], xn*nums[i]));
            max = Math.max(xn*nums[i], Math.max(nums[i], mn*nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
