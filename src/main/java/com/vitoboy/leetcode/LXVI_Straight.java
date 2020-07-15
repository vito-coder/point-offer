package com.vitoboy.leetcode;

import java.util.*;

/**
 * @Author: vito
 * @Date: 2020/7/6 14:08
 * @Version: 1.0
 *
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 */
public class LXVI_Straight {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,2,5};
        LXVI_Straight straight = new LXVI_Straight();
        System.out.println(straight.isStraight(nums));

        nums = new int[]{1,2,3,4,5};
        System.out.println(straight.isStraight(nums));

        nums = new int[]{11,0,9,0,0};
        System.out.println(straight.isStraight(nums));


    }

    /**
     * see isStraightSort(...)
     *
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) return false;
        int count = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } else if (nums[i] == nums[j] && nums[i] != 0) {
                    return false;
                }
            }
            if (nums[i] == 0) {
                count++;
            }
        }
        if (count >= 0) {
            if (nums[nums.length-1] - nums[count+1] > 4) return false;
            else return true;
        } else if (nums[nums.length-1] - nums[0] == 4) return true;
        return false;
    }


    /**
     * 集合 Set + 遍历
     * 遍历五张牌，遇到大小王（即 0 ）直接跳过。
     * 判别重复： 利用 Set 实现遍历判重， Set 的查找方法的时间复杂度为 O(1) ；
     * 获取最大 / 最小的牌： 借助辅助变量 max 和 min ，遍历统计即可。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean isStraightUpdate(int[] nums) {
        if (nums == null || nums.length != 5) return false;
        Set<Integer> norepeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if (num == 0) continue;
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (norepeat.contains(num)) return false;
            norepeat.add(num);
        }
        return max - min < 5;
    }


    /**
     * 排序 + 遍历
     * 先对数组执行排序。
     * 判别重复： 排序数组中的相同元素位置相邻，因此可通过遍历数组，判断 nums[i] ==nums[i+1] 是否成立来判重。
     * 获取最大 / 最小的牌： 排序后，数组末位元素 nums[4] 为最大牌；元素 nums[joker] 为最小牌，其中 joker 为大小王的数量。
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean isStraightSort(int[] nums) {
        if (nums == null || nums.length != 5) return false;
        int joker = 0;
        Arrays.sort(nums); // 数组排序
        for (int i=0; i<4; i++) {
            if (nums[i] == 0) joker++;      // 统计大小王
            else if (nums[i] == nums[i+1]) return false;    // 重复牌直接false
        }
        return nums[4] - nums[joker] < 5;   // 最大值 - 最小值 < 5, 则可成顺子
    }

}
