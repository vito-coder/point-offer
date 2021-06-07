package com.vitoboy.leetcode.daily.jun;

import java.util.HashMap;

/**
 * 
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
 * 
 *  
 * 
 *  示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
 * 
 *  示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
 * 
 *  
 * 
 *  提示：
 *  1 <= nums.length <= 105 
 *  nums[i] 不是 0 就是 1 
 *  
 *  Related Topics 哈希表 
 *  👍 262 👎 0
 * 
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/3
 */
public class I210603I_I525I_FindMaxLength {
    public static void main(String[] args) {
        
    }

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(count, -1);
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1){
                count++;
            } else {
                count--;
            }
            if(map.containsKey(count)) {
                max = Math.max(i - map.get(count), max);
            } else {
                map.put(count, i);
            }
        }
        return max;
    }


    /**
     * 记录速度最快的模板(6ms)
     *
     * 				解答成功:
     * 				执行耗时:6 ms,击败了100.00% 的Java用户
     * 				内存消耗:47.1 MB,击败了96.23% 的Java用户
     *
     * @param nums
     * @return
     */
    public int findMaxLengthII(int[] nums) {
        int res = 0, n = nums.length, preSum = 0;
        int[] hash = new int[2 * n + 1];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) nums[i] = -1;
        }
        for (int i = 0; i < n; ++i) {
            preSum += nums[i];
            if (preSum == 0) res = i + 1;
            else if (hash[preSum + n] != 0) res = Math.max(res, i + 1 - hash[preSum + n]);
            else hash[preSum + n] = i + 1;
        }
        return res;
    }
}
