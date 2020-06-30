package com.vitoboy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: vito
 * @Date: 2020/7/1 00:09
 * @Version: 1.0
 *
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 50000
 */
public class XXXIX_MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                Integer value = map.get(nums[i]) + 1;
                if (value > half) return nums[i];
                map.put(nums[i], map.get(nums[i])+1);
            }else {
                map.put(nums[i], 1);
            }
        }
        return nums[0];
    }

    /**
     * 解题思路
     * 方法一：正常思路可以先排序，再取中间值，中间值就是数组中出现次数超过一半的数字。
     *
     * 方法二：不正常思路的话，用target记录上一次访问的值，count表明当前值出现的次数，如果下一个值和当前值相同那么count++；如果不同count--，减到0的时候就要更换新的target值了，因为如果存在超过数组长度一半的值，那么最后target一定会是该值。可以这样理解，count的自加和自减就是在描述一种抵消关系，由于超过一半的出现次数，导致最后的target一定会是该值。（这种方法的时间复杂度自然会小些）
     *
     * 作者：mu-yi-wei-lan
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/qiao-miao-jie-ti-bi-pai-xu-shi-xian-geng-gao-xiao-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int majorityElementUpdate(int[] nums) {
        int target = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (target == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                target = nums[i];
                count = 1;
            }
        }
        return target;
    }
}
