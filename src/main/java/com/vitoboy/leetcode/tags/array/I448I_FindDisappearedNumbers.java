package com.vitoboy.leetcode.tags.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
 * 字，并以数组的形式返回结果。 
 *
 *  示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *  
 * 
 *  示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 *  提示：
 *  n == nums.length 
 *  1 <= n <= 10^5
 *  1 <= nums[i] <= n 
 *  
 * 
 *  进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
 *  Related Topics 数组 哈希表 
 *  👍 768 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/5
 */
public class I448I_FindDisappearedNumbers {
    public static void main(String[] args) {
        I448I_FindDisappearedNumbers disappearedNumbers = new I448I_FindDisappearedNumbers();
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(disappearedNumbers.findDisappearedNumbers(nums));
        nums = new int[]{1,1};
        System.out.println(disappearedNumbers.findDisappearedNumbers(nums));
    }

    /**
     *
     * 				解答成功:
     * 				执行耗时:4 ms,击败了99.36% 的Java用户
     * 				内存消耗:47.8 MB,击败了5.50% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] tmp = new int[nums.length+1];
        for (int i = 0, len = nums.length; i < len; i++) {
            tmp[nums[i]]++;
        }
        for (int i = 1, len = tmp.length; i < len; i++) {
            if (tmp[i] == 0) list.add(i);
        }
        return list;
    }
}
