package com.vitoboy.leetcode.daily.jul;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1
 * ) 的解决方案。 
 *
 *  示例 1：
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5 
 * 
 *  示例 2：
 * 输入：[3,2]
 * 输出：-1 
 * 
 *  示例 3：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2 
 *  Related Topics 数组 计数 
 *  👍 116 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/9
 */
public class I210709I_Iinterview17_10I_MajorityElement {
    public static void main(String[] args) {
        I210709I_Iinterview17_10I_MajorityElement element = new I210709I_Iinterview17_10I_MajorityElement();
        int[] nums = new int[]{1,2,5,9,5,9,5,5,5};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : 5");
        nums = new int[]{3,2};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : -1");
        nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : 2");
        nums = new int[]{1,2,3};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : -1");
        nums = new int[]{1,2,3,3};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : -1");
        nums = new int[]{3,2,3};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : 3");
        nums = new int[]{3,2,2};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : 2");
        nums = new int[]{10,9,9,9,10};
        System.out.println(element.majorityElement(nums));
        System.out.println("expect is : 9");

    }


    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:44.3 MB,击败了21.80% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int count = 1, cur = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            if (count == 0) {
                count++;
                cur = nums[i];
            } else {
                if (cur == nums[i]) {
                    count++;
                } else {
                    count--;
                }
                if (count <= 0) {
                    cur = nums[i];
                }
            }
        }
        if (count > 1) return  cur;
        count = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] == cur) {
                count++;
            }
        }
        return count > nums.length/2 ? cur : -1;
    }


    /**
     * 				解答成功:
     * 				执行耗时:11 ms,击败了24.51% 的Java用户
     * 				内存消耗:43.3 MB,击败了59.40% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int majorityElementII(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
        }
        int count = 0, num = -1;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (count < entry.getValue()) {
                num = entry.getKey();
                count = entry.getValue();
            }
        }
        if (count > nums.length/2) return num;
        return -1;
    }
}
