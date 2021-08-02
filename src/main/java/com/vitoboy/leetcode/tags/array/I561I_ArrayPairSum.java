package com.vitoboy.leetcode.tags.array;

import java.util.Arrays;

/**
 * @problem leetcode
 * @description 561.数组拆分 I
 * 
 * 
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得
 * 从 1 到 n 的 min(ai, bi) 总和最大。 
 * 
 *  返回该 最大总和 。 
 *
 *  示例 1：
 * 输入：nums = [1,4,3,2]
 * 输出：4
 * 解释：所有可能的分法（忽略元素顺序）为：
 * 1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
 * 2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
 * 3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
 * 所以最大总和为 4 
 * 
 *  示例 2：
 * 输入：nums = [6,2,6,5,1,2]
 * 输出：9
 * 解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 
 * 6 = 9
 *
 *  提示：
 *  1 <= n <= 10^4
 *  nums.length == 2 * n 
 *  -10^4 <= nums[i] <= 10^4
 *  
 *  Related Topics 贪心 数组 计数排序 排序 
 *  👍 255 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/2
 */
public class I561I_ArrayPairSum {
    public static void main(String[] args) {
        I561I_ArrayPairSum pairSum = new I561I_ArrayPairSum();
        int[] nums = new int[]{1,4,3,2};
        System.out.println(pairSum.arrayPairSum(nums));
        System.out.println("expect is : 4");
        nums = new int[]{6,2,6,5,1,2};
        System.out.println(pairSum.arrayPairSum(nums));
        System.out.println("expect is : 9");

    }


    /**
     * 				解答成功:
     * 				执行耗时:13 ms,击败了79.43% 的Java用户
     * 				内存消耗:41 MB,击败了7.21% 的Java用户
     *
     * 时间复杂度: O(nlogn + n)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, len = nums.length; i < len; i = i+2) {
            ans += (Math.min(nums[i], nums[i+1]));
        }
        return ans;
    }
}
