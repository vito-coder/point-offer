package com.vitoboy.leetcode.daily.aug;

import java.util.Stack;

/**
 * @problem leetcode
 * @description 581.最短无序连续子数组
 * 
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
 * 
 *  请你找出符合题意的 最短 子数组，并输出它的长度。 
 *
 *  示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *  
 * 
 *  示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *  
 * 
 *  示例 3：
 * 输入：nums = [1]
 * 输出：0
 *
 *  提示：
 *  1 <= nums.length <= 10^4
 *  -10^5 <= nums[i] <= 10^5
 *
 *  进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
 *  
 *  
 *  Related Topics 栈 贪心 数组 双指针 排序 单调栈 
 *  👍 612 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/3
 */
public class I210803I_I581I_FindUnsortedSubarray {
    public static void main(String[] args) {
        I210803I_I581I_FindUnsortedSubarray subarray = new I210803I_I581I_FindUnsortedSubarray();
        int[] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(subarray.findUnsortedSubarray(nums));
        System.out.println("expect is : 5");
        nums = new int[]{1,2,3,4};
        System.out.println(subarray.findUnsortedSubarray(nums));
        System.out.println("expect is : 0");
        nums = new int[]{1};
        System.out.println(subarray.findUnsortedSubarray(nums));
        System.out.println("expect is : 0");
        nums = new int[]{2,1};
        System.out.println(subarray.findUnsortedSubarray(nums));
        System.out.println("expect is : 0");

    }

    /**
     * 				解答成功:
     * 				执行耗时:6 ms,击败了60.08% 的Java用户
     * 				内存消耗:39.2 MB,击败了91.91% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> increase = new Stack<>();
        Stack<Integer> decrease = new Stack<>();
        int len = nums.length;
        boolean inadd = true, deadd = true;
        increase.add(nums[0]);
        decrease.add(nums[len-1]);
        for (int i = 1; i < len; i++) {
            inadd = checkIncrease(increase, nums[i], inadd);
            deadd = checkDecrease(decrease, nums[len-i-1], deadd);
        }
        if (increase.size() == len) return 0;
        return len-increase.size()-decrease.size();
    }

    private boolean checkIncrease(Stack<Integer> increase, int target, boolean inadd) {
        if ( increase.peek() <= target) {
            if (inadd) {
                increase.add(target);
            }
        } else {
            inadd = false;
            while (!increase.isEmpty()) {
                increase.pop();
                if (!increase.isEmpty() && increase.peek() <= target) {
                    break;
                }
            }
        }
        return inadd;
    }

    private boolean checkDecrease(Stack<Integer> decrease, int target, boolean deadd) {
        if ( decrease.peek() >= target) {
            if (deadd) {
                decrease.add(target);
            }
        } else {
            deadd = false;
            while (!decrease.isEmpty()) {
                decrease.pop();
                if (!decrease.isEmpty() && decrease.peek() >= target) {
                    break;
                }
            }
        }
        return deadd;
    }
}
