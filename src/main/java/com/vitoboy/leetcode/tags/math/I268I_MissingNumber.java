package com.vitoboy.leetcode.tags.math;

/**
 * 
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。 
 *
 * 
 *  进阶：
 *  你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题? 
 *
 * 
 *  示例 1：
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
 * 
 *  示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。 
 * 
 *  示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。 
 * 
 *  示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。 
 *
 *  提示：
 *  n == nums.length 
 *  1 <= n <= 10^4
 *  0 <= nums[i] <= n 
 *  nums 中的所有数字都 独一无二 
 *  
 *  Related Topics 位运算 数组 哈希表 数学 排序 
 *  👍 409 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/30
 */
public class I268I_MissingNumber {
    public static void main(String[] args) {
//        (n + 1) * (n / 2) = (n^2 + n) / 2 = 100*100 + 100 = 5050
//        int sum = 0;
//        for (int i = 0; i <= 9; i++) {
//            sum += i;
//        }
//        System.out.println(sum);
        I268I_MissingNumber number = new I268I_MissingNumber();
        int[] nums = new int[]{3,0,1};
        System.out.println("result is : " + number.missingNumber(nums));
        System.out.println("expect is : 2");
        nums = new int[]{0,1};
        System.out.println("result is : " + number.missingNumber(nums));
        System.out.println("expect is : 2");
        nums = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println("result is : " + number.missingNumber(nums));
        System.out.println("expect is : 8");
        nums = new int[]{0};
        System.out.println("result is : " + number.missingNumber(nums));
        System.out.println("expect is : 1");

    }


    /**
     * 数据求解
     *
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.7 MB,击败了79.38% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n*n + n)/2, tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp += nums[i];
        }
        return sum - tmp;
    }
}
