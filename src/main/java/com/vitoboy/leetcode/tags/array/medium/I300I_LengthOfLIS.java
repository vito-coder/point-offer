package com.vitoboy.leetcode.tags.array.medium;

import java.util.Map;

/**
 * @problem leetcode
 * @description 300.最长递增子序列
 * 
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
 * 
 *  子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
 * 列。 
 *  
 * 
 *  示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 *  示例 2：
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 *
 *  示例 3：
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 *
 *  提示：
 *  1 <= nums.length <= 2500 
 *  -10^4 <= nums[i] <= 10^4
 *
 *  进阶：
 *  你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
 *  你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
 *  
 *  Related Topics 数组 二分查找 动态规划 
 *  👍 1729 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/26
 */
public class I300I_LengthOfLIS {
    public static void main(String[] args) {
        I300I_LengthOfLIS lis = new I300I_LengthOfLIS();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lis.lengthOfLIS(nums));
        System.out.println("expect is : 4");
        nums = new int[]{10,9,2,5,3,7,101,18,19,20,21};
        System.out.println(lis.lengthOfLIS(nums));
        System.out.println("expect is : 7");
        nums = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(lis.lengthOfLIS(nums));
        System.out.println("expect is : 6");

    }

    /**
     * 				解答成功:
     * 				执行耗时:50 ms,击败了79.41% 的Java用户
     * 				内存消耗:38.2 MB,击败了19.37% 的Java用户
     *
     * 动态规划
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLISDP(int[] nums) {
        int max = 1, n =nums.length, tmp = 0;
        int[] dp = new int[n], tail = new int[n];
        dp[0] = 1;
        tail[0] = nums[0];
        for (int i = 1; i < n; i++) {
            tmp = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    tmp = Math.max(tmp, dp[j] + 1);
                }
            }
            dp[i] = tmp;
            max = Math.max(tmp, max);
        }
        return max;
    }


    /**
     * 考虑使用一个数组tail维护最长子序列, 及长度
     * 将原数组的每个元素, 以二分法的方式插入到tail里
     * 如果新加入的元素大于tail的最大元素, 则将新元素加入tail尾部, 长度加1
     * 如果新加入的元素小于tail, 以二分法的方式替换tail里比新元素大的最小元素值
     *
     * 虽然最长子序列不一定是单调递增, 但长度是满足要求的最长子单调增的长度
     *
     * 				解答成功:
     * 				执行耗时:3 ms,击败了93.25% 的Java用户
     * 				内存消耗:38.1 MB,击败了39.74% 的Java用户
     *
     * 时间复杂度: O(N logN)
     * 空间复杂度: O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n =nums.length, len = 0;
        int[] tail = new int[n];
        tail[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (tail[len] < nums[i]) {
                tail[++len] = nums[i];
            } else if (tail[len] > nums[i]){
                int low = 0, high = len;
                while (low < high) {
                    int mid = low + (high-low)/2;
                    if (tail[mid] == nums[i]) {
                        low = mid;
                        break;
                    }
                    else if (tail[mid] < nums[i]) low = mid+1;
                    else high = mid;
                }
                tail[low] = nums[i];
            }
        }
        return len+1;
    }

}
