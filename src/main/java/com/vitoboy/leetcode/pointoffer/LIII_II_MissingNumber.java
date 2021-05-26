package com.vitoboy.leetcode.pointoffer;

/**
 * @Author: vito
 * @Date: 2020/7/2 00:58
 * @Version: 1.0
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 */
public class LIII_II_MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,3};
        LIII_II_MissingNumber number = new LIII_II_MissingNumber();
        System.out.println(number.missingNumber(arr));
        arr = new int[]{0,1,2,3,4,5,6,7,8,10};
        System.out.println(number.missingNumber(arr));

    }

    /**
     * 用二分查找实现
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] != 0) return 0;
        int height = nums.length;
        int low = 0;
        int half = (height + low)/ 2;
        while (half < height && half > low ) {
            if (half == nums[half]) {
                low = half;
                half = (height + low)/ 2;
            } else {
                height = half;
                half = (height + low)/ 2;
            }
        }
        if (half == nums[half]) {
            return half+1;
        }
        return half;
    }


    /**
     *

     作者：jyd
     链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

     * @return
     */
    public int missingNumberless(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
