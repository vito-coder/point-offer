package com.vitoboy.leetcode.tags.array;

/**
 * 
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击
 * 的中毒持续时间，你需要输出艾希的中毒状态总时长。 
 * 
 *  你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。 
 *
 *  示例1:
 *  输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 *  
 * 
 *  示例2:
 *  输入: [1,2], 2
 * 输出: 3
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
 * 所以最终输出 3 。
 *
 *  提示：
 *  你可以假定时间序列数组的总长度不超过 10000。 
 *  你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。 
 *  
 *  Related Topics 数组 模拟 
 *  👍 157 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/7
 */
public class I495I_FindPoisonedDuration {
    public static void main(String[] args) {
        I495I_FindPoisonedDuration duration = new I495I_FindPoisonedDuration();
        int[] time = new int[]{1,4};
        System.out.println(duration.findPoisonedDuration(time, 2));
        System.out.println("expect is : 4");
        time = new int[]{1,2};
        System.out.println(duration.findPoisonedDuration(time, 2));
        System.out.println("expect is : 3");
    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了98.98% 的Java用户
     * 				内存消耗:40.2 MB,击败了48.36% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0, tmp = 0;
        for (int i = 0, len = timeSeries.length; i < len; i++) {
            if (tmp > timeSeries[i]) {
                sum = sum - (tmp - timeSeries[i]) + duration;
            } else {
                sum += duration;
            }
            tmp = timeSeries[i]+duration;
        }
        return sum;
    }
}
