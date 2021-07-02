package com.vitoboy.leetcode.tags.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
 *
 *  示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。 
 * 
 *  示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *  
 * 
 *  示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * 
 *  提示：
 *  1 <= nums.length <= 10^4
 *  -2^31 <= nums[i] <= 2^31 - 1
 *
 *  进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
 *  Related Topics 数组 排序 
 *  👍 230 👎 0
 *
 *
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I414I_ThirdMax {
    public static void main(String[] args) {
        I414I_ThirdMax thirdMax = new I414I_ThirdMax();
        int[] nums = new int[]{3, 2, 1};
        System.out.println();
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : 1");
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 2};
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : 2");
        nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : 1");
        nums = new int[]{2, 2, 2, 1};
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : 2");
        nums = new int[]{2, 2, 2, 1,5,6,7,8,9,234};
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : 8");
        nums = new int[]{-2147483648,2,1};
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : -2147483648");
        nums = new int[]{1,-2147483648,2};
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : -2147483648");
        nums = new int[]{1,1,2};
        System.out.println(thirdMax.thridMaxI(nums));
        System.out.println("expect is : 2");


    }

    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了59.78% 的Java用户
     * 				内存消耗:37.8 MB,击败了96.42% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int thridMaxI(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length-1], count = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (count == 3) return max;
            if (nums[i] < max && count < 3) {
                count++;
                max = nums[i];
            }
        }
        if (count == 3) return max;
        return nums[nums.length-1];
    }

    public int thirdMax(int[] nums) {
        int third = Integer.MIN_VALUE;
        int max = third, secod = third, count = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (max < nums[i]) {
                third = secod;
                secod = max;
                max = nums[i];
                count++;
                continue;
            } else if (max == nums[i]) continue;
            if (secod < nums[i]) {
                third = secod;
                secod = nums[i];
                count++;
                continue;
            } else if (secod == nums[i]) {
                continue;
            }
            if (third <= nums[i]) {
                third = nums[i];
                count++;
            }
        }
        if (count < 3) return max;
        else return third;
    }
}
