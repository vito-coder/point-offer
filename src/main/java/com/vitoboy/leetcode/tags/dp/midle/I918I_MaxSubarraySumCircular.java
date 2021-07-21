package com.vitoboy.leetcode.tags.dp.midle;

/**
 * @problem leet-code
 * @description 918.环形子数组的最大和
 *
 * 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。 
 * 
 *  在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 
 * C[i+A.length] = C[i]） 
 * 
 *  此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, 
 * k2 <= j 其中 k1 % A.length = k2 % A.length） 
 *
 *  示例 1：
 *  输入：[1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 *  
 * 
 *  示例 2：
 *  输入：[5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 *  
 * 
 *  示例 3：
 *  输入：[3,-1,2,-1]
 * 输出：4
 * 解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
 *
 *  示例 4：
 *  输入：[3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 *
 *  示例 5：
 *  输入：[-2,-3,-1]
 * 输出：-1
 * 解释：从子数组 [-1] 得到最大和 -1
 *
 *  提示：
 *  -30000 <= A[i] <= 30000 
 *  1 <= A.length <= 30000 
 *  
 *  Related Topics 队列 数组 分治 动态规划 单调队列 
 *  👍 175 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/21
 */
public class I918I_MaxSubarraySumCircular {
    public static void main(String[] args) {
        I918I_MaxSubarraySumCircular circular = new I918I_MaxSubarraySumCircular();
        int[] nums = new int[]{3,-1,2,-1};
        System.out.println(circular.maxSubarraySumCircular(nums));
        System.out.println("expect is : 4");
        nums = new int[]{-2,-3,-1};
        System.out.println(circular.maxSubarraySumCircular(nums));
        System.out.println("expect is : -1");
        nums = new int[]{3,-2,2,-3};
        System.out.println(circular.maxSubarraySumCircular(nums));
        System.out.println("expect is : 3");
        nums = new int[]{5,-3,5};
        System.out.println(circular.maxSubarraySumCircular(nums));
        System.out.println("expect is : 10");

    }

    /**
     * Time Limit Exceeded
     *
     * 以每个值为起点, 到当前值的前一个值为终点, 计算最大和, 并取这些最大和的最大值, 即为题目所求
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircularFail(int[] nums) {
        int max = nums[0];
        for (int i = 0, len = nums.length; i < len; i++) {
            int pre = nums[i];
            max = Math.max(pre, max);
            for (int j = i+1; j !=i ; j++) {
                if (j == len) {
                    if (i == 0) break;
                    j=0;
                }
                pre = Math.max(pre+nums[j], nums[j]);
                max = Math.max(pre, max);
            }
        }
        return max;
    }


    /**
     * 考虑这种情况(相反思路)
     * 设
     *
     * 				解答成功:
     * 				执行耗时:6 ms,击败了44.66% 的Java用户
     * 				内存消耗:44.3 MB,击败了75.04% 的Java用户
     *
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dpx = nums[0], len = nums.length, sum = nums[0];
        int max = dpx, min = Math.min(dpx, 0), dpm = min;
        for (int i = 1; i < len; i++) {
            dpx = Math.max(dpx + nums[i], nums[i]);
            max = Math.max(max, dpx);
            if (i < len -1) {
                dpm = Math.min(dpm + nums[i], nums[i]);
                min = Math.min(min, dpm);
            }
            sum += nums[i];
        }
        return Math.max(max, sum-min);
    }
}
