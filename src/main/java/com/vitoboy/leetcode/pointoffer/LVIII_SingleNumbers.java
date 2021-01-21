package com.vitoboy.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: vito
 * @Date: 2020/7/2 14:57
 * @Version: 1.0
 *
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 *
 * 限制：
 *
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 *
 */
public class LVIII_SingleNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{9,1,7,9,7,9,7};
        LVIII_SingleNumbers singleNumbers = new LVIII_SingleNumbers();
        System.out.println(singleNumbers.singleNumber(nums));
        nums = new int[]{3,4,3,3};
        System.out.println(singleNumbers.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if (nums == null) return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        for (Integer key : map.keySet()) {
            Integer val = map.get(key);
            if (val == 1) return key;
        }
        return -1;
    }


    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int singleNumberOfficial(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }


}
