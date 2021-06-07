package com.vitoboy.leetcode.weekly.I244I;

import java.util.Arrays;

/**
 * 
 * 给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤： 
 *
 *  找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。 
 *  找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。 
 *  将 nums[i] 减少到 nextLargest 。 
 *
 *  返回使 nums 中的所有元素相等的操作次数。 
 * 
 *
 *  示例 1：
 * 输入：nums = [5,1,3]
 * 输出：3
 * 解释：需要 3 次操作使 nums 中的所有元素相等：
 * 1. largest = 5 下标为 0 。nextLargest = 3 。将 nums[0] 减少到 3 。nums = [3,1,3] 。
 * 2. largest = 3 下标为 0 。nextLargest = 1 。将 nums[0] 减少到 1 。nums = [1,1,3] 。
 * 3. largest = 3 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1] 。
 *  
 * 
 *  示例 2：
 * 输入：nums = [1,1,1]
 * 输出：0
 * 解释：nums 中的所有元素已经是相等的。
 *  
 * 
 *  示例 3：
 * 输入：nums = [1,1,2,2,3]
 * 输出：4
 * 解释：需要 4 次操作使 nums 中的所有元素相等：
 * 1. largest = 3 下标为 4 。nextLargest = 2 。将 nums[4] 减少到 2 。nums = [1,1,2,2,2] 。
 * 2. largest = 2 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1,2,2] 。 
 * 3. largest = 2 下标为 3 。nextLargest = 1 。将 nums[3] 减少到 1 。nums = [1,1,1,1,2] 。 
 * 4. largest = 2 下标为 4 。nextLargest = 1 。将 nums[4] 减少到 1 。nums = [1,1,1,1,1] 。
 *  
 *
 *  提示：
 *  1 <= nums.length <= 5 * 104 
 *  1 <= nums[i] <= 5 * 104 
 *  
 *  Related Topics 贪心算法 排序 
 *  👍 5 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/7
 */
public class I4I_I1887I_ReductionOperations {
    public static void main(String[] args) {
        I4I_I1887I_ReductionOperations reductionOperations
                 = new I4I_I1887I_ReductionOperations();
        int[] nums = new int[]{5,1,3};
        System.out.println("result is : " + reductionOperations.reductionOperations(nums));
        System.out.println("expect is : 3");
        nums = new int[]{1,1,1};
        System.out.println("result is : " + reductionOperations.reductionOperations(nums));
        System.out.println("expect is : 0");
        nums = new int[]{1,1,2,2,3};
        System.out.println("result is : " + reductionOperations.reductionOperations(nums));
        System.out.println("expect is : 4");
        nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println("result is : " + reductionOperations.reductionOperations(nums));
        System.out.println("expect is : 45");
    }

    /**
     * 				解答成功:
     * 				执行耗时:39 ms,击败了100.00% 的Java用户
     * 				内存消耗:47.5 MB,击败了100.00% 的Java用户
     *
     * 时间复杂度: O(n+n) 因为一次排序 和 一次遍历
     * 空间复杂度: 不算排序的话, O(1)
     *
     * @param nums
     * @return
     */
    public int reductionOperations(int[] nums) {
        if(nums == null || nums.length == 1) return 0;
        int n = nums.length;
        Arrays.sort(nums);
        int cur = nums[n-1], min = nums[0], count=0, temp =0;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] == min) return count+temp;
            if(cur == nums[i]) {
                temp++;
            } else {
                count += temp;
                cur = nums[i];
                temp++;
            }
        }
        return count;
    }
}
