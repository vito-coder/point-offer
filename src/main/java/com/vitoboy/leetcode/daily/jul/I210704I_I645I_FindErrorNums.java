package com.vitoboy.leetcode.daily.jul;

import java.util.Arrays;

/**
 * 
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
 * 一个数字重复 。 
 * 
 *  给定一个数组 nums 代表了集合 S 发生错误后的结果。 
 * 
 *  请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
 *
 * 
 *  示例 1：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 *
 *  示例 2：
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 *  提示：
 *  2 <= nums.length <= 10^4
 *  1 <= nums[i] <= 10^4
 *  
 *  Related Topics 位运算 数组 哈希表 排序 
 *  👍 197 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/4
 */
public class I210704I_I645I_FindErrorNums {
    public static void main(String[] args) {
        I210704I_I645I_FindErrorNums errorNums = new I210704I_I645I_FindErrorNums();
        int[] nums = new int[]{1,2,2,4};
        System.out.println(Arrays.toString(errorNums.findErrorNums(nums)));
        System.out.println("expect is : [2,3]");
        nums = new int[]{1,1};
        System.out.println(Arrays.toString(errorNums.findErrorNums(nums)));
        System.out.println("expect is : [1,2]");

    }

    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了70.15% 的Java用户
     * 				内存消耗:40.1 MB,击败了30.97% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int tmp = 0, repet = 0;
        int[] back = new int[nums.length];
        for (int i = 0, len = nums.length; i < len; i++) {
            tmp = tmp ^ (i+1) ^ nums[i];
            if (back[nums[i]-1] != 0) repet = nums[i];
            else back[nums[i]-1] = nums[i];
        }
        int[] res = new int[2];
        res[0] = repet;
        res[1] = repet ^ tmp;
        return res;
    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了91.50% 的Java用户
     * 				内存消耗:40.4 MB,击败了12.89% 的Java用户
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int[] findErrorNumsII(int[] nums) {
        int len = nums.length;
        int[] count = new int[len+1];
        for (int num : nums) {
            count[num]++;
        }
        int[] res = new int[2];
        for (int i = 1; i < len+1; i++) {
            if (count[i] == 0) res[1] = i;
            if (count[i] == 2) res[0] = i;
        }
        return res;
    }
    
    
}
