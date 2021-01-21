package com.vitoboy.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: vito
 * @Date: 2020/7/2 12:59
 * @Version: 1.0
 *
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 *
 */
public class LVII_SingleNumbers {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        LVII_SingleNumbers singleNumbers = new LVII_SingleNumbers();
        System.out.println(Arrays.toString(singleNumbers.singleNumbersFaster(nums)));


        nums = new int[]{1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(singleNumbers.singleNumbersFaster(nums)));

    }

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 2) return nums;
        Map<Integer, Integer> map = new HashMap<>();
        int[] single = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if (value == 1 && count < 2) {
                single[count] = key;
                count++;
            }
        };
        return single;
    }


    /**
     *
     * 作者：eddieVim
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jie-di-qi-jiang-jie-fen-zu-wei-yun-suan-by-eddievi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] singleNumbersFaster(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}
