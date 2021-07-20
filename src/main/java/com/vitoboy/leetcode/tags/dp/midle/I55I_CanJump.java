package com.vitoboy.leetcode.tags.dp.midle;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
 * 
 *  数组中的每个元素代表你在该位置可以跳跃的最大长度。 
 * 
 *  判断你是否能够到达最后一个下标。 
 *
 *  示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 *
 *  示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *  提示：
 *  1 <= nums.length <= 3 * 10^4
 *  0 <= nums[i] <= 10^5
 *  
 *  Related Topics 贪心 数组 动态规划 
 *  👍 1274 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/20
 */
public class I55I_CanJump {
    public static void main(String[] args) {
        I55I_CanJump jump = new I55I_CanJump();
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump.canJump(nums));
        System.out.println("expect is : true");
        nums = new int[]{3,2,1,0,4};
        System.out.println(jump.canJump(nums));
        System.out.println("expect is : false");
        nums = new int[]{3,2,3,0,0,0,0,4};
        System.out.println(jump.canJump(nums));
        System.out.println("expect is : false");

    }

    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了48.04% 的Java用户
     * 				内存消耗:39.6 MB,击败了79.53% 的Java用户
     *
     * 考虑这种情况
     * 1. 如果数组内的值都大于0, 则无论如何跳, 都能到终点
     * 2. 如果数组内的值包含0, 则需要保证, 在零之前, 存在可以跳过这个零的地方, 则能到达终点, 否则不行
     *
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length, index = 0, tmp = 0;
        for (int i = 0; i < len; i++) {
            tmp = Math.max(index, i+nums[i]);
            if (tmp >= len-1) return true;
            if (tmp <= index && i == index) return false;
            index = tmp;
        }
        return false;
    }
}
