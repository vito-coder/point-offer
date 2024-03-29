package com.vitoboy.leetcode.tags.math;

/**
 * 你和你的朋友，两个人一起玩 Nim 游戏： 
 *
 *  桌子上有一堆石头。 
 *  你们轮流进行自己的回合，你作为先手。 
 *  每一回合，轮到的人拿掉 1 - 3 块石头。 
 *  拿掉最后一块石头的人就是获胜者。 
 *
 *  假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。 
 *
 *  示例 1：
 * 输入：n = 4
 * 输出：false 
 * 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
 *      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 *
 *  示例 2：
 * 输入：n = 1
 * 输出：true
 *
 *  示例 3：
 * 输入：n = 2
 * 输出：true
 *
 *  提示：
 *  1 <= n <= 2^31 - 1
 *  
 *  Related Topics 脑筋急转弯 数学 博弈 
 *  👍 437 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/30
 */
public class I292I_CanWinNim {
    public static void main(String[] args) {
        I292I_CanWinNim winNim = new I292I_CanWinNim();
        System.out.println(winNim.canWinNim(8));
        
    }

    /**
     * 可以这么考虑,
     * 当 n=1时, true;
     * 当 n=2时, true;
     * 当 n=3时, true;
     * 当 n=4时, fase;
     * 当 n=5时, true;
     * 当 n=6时, true;
     * 当 n=7时, true;
     * 当 n=8时, fase;
     * 当 n=9时, true;
     *
     * 即, 能初4整除时, 不能赢, 其它情况都能赢
     *
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:35 MB,击败了84.01% 的Java用户
     *
     * 时间复杂度: O(1)
     * 空间复杂度: O(1)
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
}
