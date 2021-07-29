package com.vitoboy.leetcode.tags.dp.midle;

/**
 * @problem leetcode
 * @description 1014.最佳观光组合
 * 
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。 
 * 
 *  一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离
 * 。 
 * 
 *  返回一对观光景点能取得的最高分。 
 *
 *  示例 1：
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 * 
 *  示例 2：
 * 输入：values = [1,2]
 * 输出：2
 *
 *  提示：
 *  2 <= values.length <= 5 * 10^4
 *  1 <= values[i] <= 1000 
 *  
 *  Related Topics 数组 动态规划 
 *  👍 206 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/28
 */
public class I1014I_MaxScoreSightseeingPair {
    public static void main(String[] args) {
        I1014I_MaxScoreSightseeingPair pair = new I1014I_MaxScoreSightseeingPair();
        int[] values = new int[]{8,1,5,2,6};
        System.out.println(pair.maxScoreSightseeingPair(values));
        System.out.println("expect is : 11");
        values = new int[]{1,2};
        System.out.println(pair.maxScoreSightseeingPair(values));
        System.out.println("expect is : 2");
    }

    /**
     * 				解答成功:
     * 				执行耗时:4 ms,击败了55.14% 的Java用户
     * 				内存消耗:47.6 MB,击败了38.60% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0], curMax = max, len = values.length;
        for (int i = 1; i < len ; i++) {
            --curMax;
            int val = Math.max(values[i],curMax + values[i]);
            curMax = Math.max(values[i], curMax);
            max = Math.max(val, max);
        }
        return max;
    }


    /**
     * 暴力法(估计大概可以要超时)
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPairViolence(int[] values) {
        int max = values[0], len = values.length;
        for (int i = 0; i < len; i++) {
            int val = values[i];
            for (int j = i+1; j < len; j++) {
                val = Math.max(val, values[i]+values[j]+i-j);
            }
            max = Math.max(val, max);
        }
        return max;
    }
}
