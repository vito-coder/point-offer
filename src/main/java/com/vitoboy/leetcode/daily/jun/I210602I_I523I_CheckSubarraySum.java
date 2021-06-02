package com.vitoboy.leetcode.daily.jun;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组： 
 * 
 *  
 *  子数组大小 至少为 2 ，且 
 *  子数组元素总和为 k 的倍数。 
 *  
 * 
 *  如果存在，返回 true ；否则，返回 false 。 
 * 
 *  如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。 
 * 
 *  
 * 
 *  示例 1：
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。 
 * 
 *  示例 2：
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 *  
 * 
 *  示例 3：
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 * 
 *  
 * 
 *  提示：
 *  1 <= nums.length <= 10^5
 *  0 <= nums[i] <= 10^9
 *  0 <= sum(nums[i]) <= 2^31 - 1
 *  1 <= k <= 2^31 - 1
 *  
 *  Related Topics 数学 动态规划 
 *  👍 267 👎 0
 * 
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/2
 */
public class I210602I_I523I_CheckSubarraySum {
    public static void main(String[] args) {
        
    }


    /**
     * 超时了
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int idx = 0;
        int temp = 0;
        for (int i = 0; i < len; i++) {
            if(i>0) {
                if (sum[i] % k == 0) {
                    return true;
                }
            }
            for (int j = i+2; j < len; j++) {
                temp = sum[j] - sum[i];
                if (temp % k == 0) {
                    return true;
                }
            }
        }

        return  false;
    }


    /**
     * 记录评论题解
     *
     *     作者：AC_OIer
     *     链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/gong-shui-san-xie-tuo-zhan-wei-qiu-fang-1juse/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * 				解答成功:
     * 				执行耗时:20 ms,击败了54.79% 的Java用户
     * 				内存消耗:52.4 MB,击败了55.02% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumII(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }


}
