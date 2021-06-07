package com.vitoboy.leetcode.daily.jun;

/**
 * 给你一个整数数组 nums 和一个整数 target 。 
 * 
 *  向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
 *
 *  例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
 *
 *  返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *  
 * 
 *  示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 * 
 *  提示：
 *  1 <= nums.length <= 20 
 *  0 <= nums[i] <= 1000 
 *  0 <= sum(nums[i]) <= 1000 
 *  -1000 <= target <= 100 
 *  
 *  Related Topics 深度优先搜索 动态规划 
 *  👍 756 👎 0
 * 
 *
 * todo 待自己实现
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/7
 */
public class I210607I_I494I_FindTargetSumWays {
    public static void main(String[] args) {

    }

    /**
     * 记录官方题解(回朔法)
     *
     * 时间复杂度：O(2^n)，其中 n 是数组 nums 的长度。回溯需要遍历所有不同的表达式，共有 2^n
     *   种不同的表达式，每种表达式计算结果需要 O(1) 的时间，因此总时间复杂度是 O(2^n)。
     * 空间复杂度：O(n)，其中 n 是数组 nums 的长度。空间复杂度主要取决于递归调用的栈空间，栈的深度不超过 n。
     *
     */
    class Solution {
        int count = 0;
        public int findTargetSumWays(int[] nums, int target) {
            count = 0;
            backpath(nums, target, 0, 0);
            return count;
        }

        private void backpath(int[] nums, int target, int index, int sum) {
            if(index == nums.length) {
                if(target == sum) {
                    count++;
                }
            } else {
                backpath(nums, target, index+1, sum + nums[index]);
                backpath(nums, target, index+1, sum - nums[index]);
            }
        }
    }
}
