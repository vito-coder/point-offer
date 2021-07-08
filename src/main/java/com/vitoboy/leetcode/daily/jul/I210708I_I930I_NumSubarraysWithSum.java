package com.vitoboy.leetcode.daily.jul;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
 * 
 *  子数组 是数组的一段连续部分。 
 *
 *  示例 1：
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *  
 * 
 *  示例 2：
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 *
 *  提示：
 *  1 <= nums.length <= 3 * 10^4
 *  nums[i] 不是 0 就是 1 
 *  0 <= goal <= nums.length 
 *  
 *  Related Topics 数组 哈希表 前缀和 滑动窗口 
 *  👍 127 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/8
 */
public class I210708I_I930I_NumSubarraysWithSum {
    public static void main(String[] args) {
        I210708I_I930I_NumSubarraysWithSum withSum = new I210708I_I930I_NumSubarraysWithSum();
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println(withSum.numSubarraysWithSumIII(nums, 2));
        System.out.println("expect is : 4");
        nums = new int[]{0,0,0,0,0};
        System.out.println(withSum.numSubarraysWithSumIII(nums, 0));
        System.out.println("expect is : 15");
        nums = new int[]{0,0,0,0,0};
        System.out.println(withSum.numSubarraysWithSumIII(nums, 1));
        System.out.println("expect is : 0");
    }

    /**
     * 				解答成功:
     * 				执行耗时:1747 ms,击败了5.54% 的Java用户
     * 				内存消耗:42.2 MB,击败了58.32% 的Java用户
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            sum[i] += (sum[i-1] + nums[i]);
        }
        int count = 0;
        for (int i = 0, len = sum.length; i < len; i++) {
            if (sum[i] == goal) count++;
            for (int j = i+1; j < len; j++) {
                if (sum[j]-sum[i] == goal) count++;
                if (sum[j] - sum[i] > goal) break;
            }
        }
        return count;
    }


    /**
     * 优化, 使用窗口(模拟窗口)
     *
     * 				解答成功:
     * 				执行耗时:2002 ms,击败了5.10% 的Java用户
     * 				内存消耗:41.8 MB,击败了74.28% 的Java用户
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSumII(int[] nums, int goal) {
        int count = 0, sum = 0;
        for (int i = 0, len = nums.length; i < len ; i++) {
            sum = nums[i];
            if (sum == goal) {
                count++;
            } else if (sum > goal) {
                continue;
            }
            for (int j = i+1; j < len; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                } else if (sum > goal) {
                    break;
                }
            }
        }

        return count;
    }


    /**
     * 前缀和 + 哈希
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSumIII(int[] nums, int goal) {
        int[] sum = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        sum[0] = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        map.put(0, 1);
        int count = 0;
        for (int i = 0, len = sum.length; i < len; i++) {
            int n = sum[i], l = goal-n;
            count += map.getOrDefault(l, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return count;
    }
}
