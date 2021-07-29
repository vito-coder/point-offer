package com.vitoboy.leetcode.daily.jul;

import java.util.Arrays;

/**
 * 元素的 频数 是该元素在一个数组中出现的次数。 
 * 
 *  给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。 
 * 
 *  执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。 
 *
 *  示例 1：
 * 输入：nums = [1,2,4], k = 5
 * 输出：3
 * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
 * 4 是数组中最高频元素，频数是 3 。 
 * 
 *  示例 2：
 * 输入：nums = [1,4,8,13], k = 5
 * 输出：2
 * 解释：存在多种最优解决方案：
 * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
 * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
 * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
 *  
 * 
 *  示例 3：
 * 输入：nums = [3,9,6], k = 2
 * 输出：1
 *
 *  提示：
 *  1 <= nums.length <= 105 
 *  1 <= nums[i] <= 105 
 *  1 <= k <= 105 
 *  
 *  Related Topics 数组 二分查找 前缀和 滑动窗口 
 *  👍 137 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/19
 */
public class I210719I_I1838I_MaxFrequency {
    public static void main(String[] args) {
        I210719I_I1838I_MaxFrequency frequency = new I210719I_I1838I_MaxFrequency();
        int[] nums = new int[]{1,2,4};
        System.out.println(frequency.maxFrequency(nums, 5));
        System.out.println("expect is : 3");
        nums = new int[]{1,4,8,13};
        System.out.println(frequency.maxFrequency(nums, 5));
        System.out.println("expect is : 2");
        nums = new int[]{3,9,6};
        System.out.println(frequency.maxFrequency(nums, 2));
        System.out.println("expect is : 1");
        nums = new int[]{9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        System.out.println(frequency.maxFrequency(nums, 3056));
        System.out.println("expect is : 73");
        nums = new int[]{7,1,5,5};
        System.out.println(frequency.maxFrequency(nums, 2));
        System.out.println("expect is : 2");
    }


    /**
     * 				解答成功:
     * 				执行耗时:33 ms,击败了39.89% 的Java用户
     * 				内存消耗:47.3 MB,击败了96.70% 的Java用户
     *
     * 时间复杂度: O(	nlogn + n)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int flow = 0, fast = 1, len = nums.length, ans = 1;
        while (fast < len && flow <= fast) {
            int tmp = nums[fast]*(fast-flow+1) + sum[flow] - nums[flow] - sum[fast];
            if (tmp <= k) {
                ans = Math.max(ans, fast-flow+1);
                fast++;
            } else {
                flow++;
            }
        }
        return ans;
    }
}
