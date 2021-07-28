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
     * 定义 dp[n][3]{买入, 卖出, 冷冻} 表示三种状态下的收益情况
     * dp[n][0] = max(dp[n-1]
     * [1,2,3,0,2]
     * 第一天: (-1,1,0)
     * 第二天: (-1,(2-1)=1,1)
     * 第三天: (-2,(3-1)=2,1)
     * 第四天: (dp[i-1][2]-p[i]=1, p[i]+dp[i-1][0]=-2, dp[i-1][1]=2)
     * 第五天: (dp[i-1][2]-p[i]=0, dp[i-1][0]-p[i]=-1, dp[i-1][1]=-2)
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0]; dp[0][1] = prices[0]; dp[0][2] = 0;
        int ans = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
        for (int i = 1; i < len; i++) {
            // 买入 ==> 上次是冻结的, 才能买入
            dp[i][0] = dp[i-1][2] - prices[i];
            // 卖出 ==> 上次买入的, 可以卖; 上次冻结, 也可以卖
            dp[i][1] = Math.max(dp[i-1][0] + prices[i], dp[i-1][2] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
            ans = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
        }
        return ans;
    }
}
