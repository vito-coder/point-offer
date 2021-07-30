package com.vitoboy.leetcode.tags.dp.midle;

/**
 * @problem leetcode
 * @description 309.最佳买卖股票时机含冷冻期
 * 
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
 * 
 *  设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
 *
 *  你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
 *  卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
 *  
 * 
 *  示例:
 *  输入: [1,2,3,0,2]
 * 输出: 3 
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
 *  Related Topics 数组 动态规划 
 *  👍 834 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/27
 */
public class I309I_MaxProfit_III {
    public static void main(String[] args) {
        I309I_MaxProfit_III profit = new I309I_MaxProfit_III();
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(profit.maxProfit(prices));
        System.out.println("expect is : 3");
    }

    /**
     * 动态规划
     * dp[][3]{买入, 卖出, 冻结}状态收益
     * [1,2,3,0,2]
     * dp[0][3] = {-1,0,0}
     * dp[1][3] = {-1,2-1=1,0}
     * dp[2][3] = {-1,3-1=2,1}
     * dp[3][3] = {1,2,2}
     * dp[4][3] = {1,1+2=3,2}
     *
     * 买入 = max(冻结-当前收益, 上次的买入收益)
     * 卖出 = max(当前收益+上次的买入收益, 上次的卖出收益)
     * 冻结 = max(冻结, 上次的卖出收益)
     *
     * 				解答成功:
     * 				执行耗时:2 ms,击败了19.52% 的Java用户
     * 				内存消耗:37.8 MB,击败了37.44% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0, len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1] = dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][2] - prices[i], dp[i-1][0]);
            dp[i][1] = Math.max(prices[i] + dp[i-1][0], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
            max = Math.max(max, Math.max(dp[i][0], Math.max(dp[i][1],dp[i][2])));
        }
        return max;
    }
}
