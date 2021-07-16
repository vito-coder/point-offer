package com.vitoboy.leetcode.tags.dp.midle;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 * 给你一个整数数组 nums ，你可以对它进行一些操作。 
 * 
 *  每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
 *  + 1 的元素。 
 * 
 *  开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
 *
 *  示例 1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 *  
 * 
 *  示例 2：
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 *  提示：
 *  1 <= nums.length <= 2 * 104 
 *  1 <= nums[i] <= 104 
 *  
 *  Related Topics 数组 哈希表 动态规划 
 *  👍 368 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/16
 */
public class I740I_DeleteAndEarn {
    public static void main(String[] args) {
        I740I_DeleteAndEarn earn = new I740I_DeleteAndEarn();
        int[] nums = new int[]{3,4,2};
        System.out.println(earn.deleteAndEarn(nums));
        System.out.println("expect is : 6");
        nums = new int[]{2,2,3,3,3,4};
        System.out.println(earn.deleteAndEarn(nums));
        System.out.println("expect is : 9");
        nums = new int[]{1,6,3,3,8,4,8,10,1,3};
        System.out.println(earn.deleteAndEarn(nums));
        System.out.println("expect is : 43");
    }

    /**
     *
     * 				解答成功:
     * 				执行耗时:11 ms,击败了6.74% 的Java用户
     * 				内存消耗:38.2 MB,击败了34.21% 的Java用户
     *
     * f(n) = num[n] + max(f(n-2), f(n-3))
     *
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        if (map.size() ==1) {
            return map.firstKey()*map.get(map.firstKey());
        }
        int[][] dp = new int[map.size()][2];
        dp[0] = new int[]{map.firstKey(), map.get(map.firstKey())*map.firstKey()};
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int i = 1,l=list.size(); i < l; i++) {
            int idx = list.get(i);
            if (idx == dp[i-1][0]+1) {
                dp[i][0] = idx;
                if (i == 2) {
                    dp[i][1] = map.get(idx)*idx + dp[i-2][1];
                } else if (i > 2){
                    dp[i][1] = map.get(idx)*idx + Math.max(dp[i-2][1], dp[i-3][1]);
                } else {
                    dp[i][1] = map.get(idx)*idx;
                }
            } else {
                dp[i][0] = idx;
                if (i >= 2) {
                    dp[i][1] = map.get(idx)*idx + Math.max(dp[i-2][1], dp[i-1][1]);
                } else {
                    dp[i][1] = map.get(idx) * idx + dp[i - 1][1];
                }
            }
        }
        return Math.max(dp[list.size()-1][1], dp[list.size()-2][1]);
    }
}
