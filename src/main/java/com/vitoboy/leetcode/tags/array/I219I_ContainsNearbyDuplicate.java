package com.vitoboy.leetcode.tags.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
 *  至多为 k。 
 * 
 *  
 * 
 *  示例 1:
 *  输入: nums = [1,2,3,1], k = 3
 * 输出: true 
 * 
 *  示例 2:
 *  输入: nums = [1,0,1,1], k = 1
 * 输出: true 
 * 
 *  示例 3:
 *  输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false 
 *  Related Topics 数组 哈希表 滑动窗口 
 *  👍 280 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/25
 */
public class I219I_ContainsNearbyDuplicate {
    public static void main(String[] args) {
        
    }

    /**
     * 				解答成功:
     * 				执行耗时:25 ms,击败了23.69% 的Java用户
     * 				内存消耗:47.2 MB,击败了5.32% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(N)
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) return true;
                else map.put(nums[i], i);
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }
}
