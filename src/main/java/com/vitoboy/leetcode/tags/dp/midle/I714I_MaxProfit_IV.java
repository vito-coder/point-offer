package com.vitoboy.leetcode.tags.dp.midle;

/**
 * @problem leetcode
 * @description 714.买卖股票的最佳时机含手续费
 * 
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。 
 * 
 *  你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。 
 * 
 *  返回获得利润的最大值。 
 * 
 *  注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。 
 *
 *  示例 1：
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:  
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8 
 * 
 *  示例 2：
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 *
 *  提示：
 *  1 <= prices.length <= 5 * 10^4
 *  1 <= prices[i] < 5 * 10^4
 *  0 <= fee < 5 * 10^4
 *  
 *  Related Topics 贪心 数组 动态规划 
 *  👍 517 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/29
 */
public class I714I_MaxProfit_IV {
    public static void main(String[] args) {
        I714I_MaxProfit_IV profitIv = new I714I_MaxProfit_IV();
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        System.out.println(profitIv.maxProfit(prices, 2));
        System.out.println("expect is : 8");
        prices = new int[]{1,3,7,5,10,3};
        System.out.println(profitIv.maxProfit(prices, 3));
        System.out.println("expect is : 6");
    }

    /**
     * 动态规划
     * dp[n][2]={手上有股票的最大收益, 手上没有股票的最大收益}
     * [1, 3, 2, 8, 4, 9]
     * dp[0][2]={-1,0}
     * dp[1][2]={-1,(3-1)-2=0}
     * dp[2][2]={-1,max(0,-1+2-2)=0}
     * dp[3][2]={-1,max(0,-1+8-2)=5}
     * dp[4][2]={max(-1,5-4)=1,max(5,-1+4-2)=5}
     * dp[5][2]={max(2,5-9)=2,max(5,1+9-2)=8}
     *
     *
     * ==> 手上有股票的收益 = max(上次手上有股票的收益, 上次没股票, 但这次买入股票的收益)
     * ==> 手上没股票的收益 = max(上次手上没股票的收益, 上次有股票, 这次卖出股票的收益)
     *
     * 				解答成功:
     * 				执行耗时:4 ms,击败了99.14% 的Java用户
     * 				内存消耗:47.7 MB,击败了40.43% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int dpIn = -prices[0], dpOut = 0;
        for (int i = 1; i < len; i++) {
            int tmpIn = Math.max(dpIn, dpOut-prices[i]);
            int tmpOut = Math.max(dpOut, dpIn+prices[i]-fee);
            dpIn = tmpIn;
            dpOut = tmpOut;
        }
        return Math.max(dpIn, dpOut);
    }
}
