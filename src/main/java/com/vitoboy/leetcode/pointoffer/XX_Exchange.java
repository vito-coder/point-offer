package com.vitoboy.leetcode;

import java.util.Arrays;

/**
 * @Author: vito
 * @Date: 2020/6/28 19:04
 * @Version: 1.0
 *
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
public class XX_Exchange {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        XX_Exchange exchange = new XX_Exchange();
//        System.out.println(Arrays.toString(exchange.exchange(nums)));
        nums = new int[]{2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        System.out.println(Arrays.toString(exchange.exchange(nums)));


    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     *
     * @param nums      原数组
     * @return
     *      已经互换后的数组
     */
    public int[] exchange(int[] nums) {
        // 如果数据长度小于1, 或数据是个空, 直接返回原数组
        if (nums == null || nums.length <=1) return nums;
        // 得到数据的长度, 用来从后往前遍历
        int len = nums.length;
        // 先从第0位开始判断, "前序遍历"的位数, 不能大于需要检查的位数
        for (int i = 0; i < len; i++) {
            // 如果是奇数, 判断下一个
            if (nums[i] % 2 != 0) continue;
            // 如果是偶数, 从第(len-1)位判断, 且 len > i ("后序遍历"的位数不能大于"前序遍历"的位数
            for (; len > i ;) {
                // 第(len--)位为奇数, 与第i位互换
                if (nums[len-1] % 2 != 0) {
                    int temp = nums[i];
                    nums[i] = nums[len-1];
                    nums[len-1] = temp;
                    // 互换成功后, 长度len--, 同时退出循环
                    len--;
                    break;
                }
                // 没有互换, 长度len--
                len--;
            }
        }
        // 返回互换后的结果
        return nums;
    }
}
