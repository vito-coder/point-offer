package com.vitoboy.leetcode.daily.aprilbefore;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。 
 * 
 *  我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。 
 * 
 *  
 * 
 *  示例 1: 
 * 
 *  输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *  
 * 
 *  示例 2: 
 * 
 *  输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 * 
 *  
 * 
 *  说明： 
 * 
 *  
 *  1 <= n <= 10 ^ 4 
 *  - 10 ^ 5 <= nums[i] <= 10 ^ 5 
 *  
 *  Related Topics 数组 
 *  👍 465 👎 0
 * 
 * @Author: vito
 * @Date: 2021/2/7 下午1:16
 * @Version: 1.0
 */
public class CheckPossibilitySolution {
    public static void main(String[] args) {
        CheckPossibilitySolution solution = new CheckPossibilitySolution();
        int[] nums = new int[]{4,2,3};
        System.out.println("result is : " + solution.checkPossibility(nums));
        System.out.println("expect is : true");
        nums = new int[]{4,2,1};
        System.out.println("result is : " + solution.checkPossibility(nums));
        System.out.println("expect is : false");
        nums = new int[]{3,4,2,3};
        System.out.println("result is : " + solution.checkPossibility(nums));
        System.out.println("expect is : false");
        nums = new int[]{4,2,3};
        System.out.println("result is : " + solution.checkPossibility(nums));
        System.out.println("expect is : true");
        nums = new int[]{2,3,3,2,2};
        System.out.println("result is : " + solution.checkPossibility(nums));
        System.out.println("expect is : false");
        nums = new int[]{5,7,1,8};
        System.out.println("result is : " + solution.checkPossibility(nums));
        System.out.println("expect is : true");

    }


    /**
     * 				解答成功:(copy)
     * 				执行耗时:1 ms,击败了99.88% 的Java用户
     * 				内存消耗:39.8 MB,击败了60.91% 的Java用户
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
