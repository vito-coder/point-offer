package com.vitoboy.leetcode.tags.array;

/**
 * 
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。 
 * 
 *  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
 * 
 *  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
 *
 *  示例 1:
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *  
 * 
 *  示例 2:
 * 输入: prices = [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 *  示例 3:
 * 输入: prices = [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
 *
 *  提示：
 *  1 <= prices.length <= 3 * 10^4
 *  0 <= prices[i] <= 10^4
 *  
 *  Related Topics 贪心算法 数组 
 *  👍 1229 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/25 下午1:26
 * @Version: 1.0
 */
public class I122I_MaxProfit {
    public static void main(String[] args) {

        I122I_MaxProfit maxProfit = new I122I_MaxProfit();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println("result is : " + maxProfit.maxProfit(prices));
        System.out.println("expect is : 7");
        prices = new int[]{1,2,3,4,5};
        System.out.println("result is : " + maxProfit.maxProfit(prices));
        System.out.println("expect is : 4");
        prices = new int[]{7,6,4,3,1};
        System.out.println("result is : " + maxProfit.maxProfit(prices));
        System.out.println("expect is : 0");
    }

    /**
     *  * 输入: prices = [7,1,5,3,6,4]
     *  * 输出: 7
     *  * 输入: prices = [1,2,3,4,5]
     *  * 输出: 4
     *  * 输入: prices = [7,6,4,3,1]
     *  * 输出: 0
     *
     *  1.取第一个数值, 与第二个数值比较
     *      如果第二个数值大于第一个数值, 则认为在第一个数值里买入是可以的
     *      如果第一个数值大于第二个数值, 则认为在第二个数值可能可以买入, 能否买入得看第三个数值是否大于第二个数值
     *          如果第三个数值大物第二个数值, 则认为第二个数值可以买入, 而第三个数值可能可以买出, 能否买出, 得看第四个数值是否小于第三个数值
     *
     * 2. 大体的规律:
     *      a.递增数组, 从第一个数值买入, 最后一个数值卖出
     *      b.递减数据, 不买入卖出
     *      c.有增有减, 从每个数值低谷买入, 下一下数值高峰卖出
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.62% 的Java用户
     * 				内存消耗:38.5 MB,击败了16.69% 的Java用户
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.62% 的Java用户
     * 				内存消耗:38.2 MB,击败了63.93% 的Java用户
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        if (prices.length == 2) {
            if (prices[1] > prices[0]) {
                return prices[1] - prices[0];
            }
            return 0;
        }
        int lowIdx = -1;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                if (lowIdx >= 0) {
                    profit += (prices[i-1] - prices[lowIdx]);
                    lowIdx = i;
                }
            } else if(prices[i] > prices[i-1]){
                if (lowIdx < 0) {
                    lowIdx = i-1;
                }
            }
        }
        if (lowIdx < prices.length -1 && lowIdx >= 0) {
            profit += (prices[prices.length -1] - prices[lowIdx]);
        }
        return profit;
    }
}
