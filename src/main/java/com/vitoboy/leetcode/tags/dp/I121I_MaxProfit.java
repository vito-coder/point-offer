package com.vitoboy.leetcode.tags.dp;

/**
 * @problem leetcode
 * @description 121.买卖股票的最佳时机
 * 
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
 * 
 *  你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
 * 
 *  返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
 *
 *  示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 *  示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *  提示：
 *  1 <= prices.length <= 10^5
 *  0 <= prices[i] <= 10^4
 *  
 *  Related Topics 数组 动态规划 
 *  👍 1737 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/27
 */
public class I121I_MaxProfit {
    public static void main(String[] args) {
        I121I_MaxProfit profit = new I121I_MaxProfit();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(profit.maxProfit(prices));
        System.out.println("expect is : 5");
        prices = new int[]{7,6,5,4,3,2,1};
        System.out.println(profit.maxProfit(prices));
        System.out.println("expect is : 0");

    }

    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了97.86% 的Java用户
     * 				内存消耗:51.3 MB,击败了58.27% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int curMin = prices[0], profit = 0;
        for (int i = 0, len = prices.length; i < len; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - curMin);
            }
        }
        return profit;
    }

    /**
     * 超时
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfitViolence(int[] prices) {
        int ans = 0;
        for (int i = 0, len = prices.length; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int diff = prices[j] - prices[i];
                ans = Math.max(diff, ans);
            }
        }
        return ans;
    }
}
