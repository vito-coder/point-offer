package com.vitoboy.leetcode.tags.array;

import java.util.Arrays;

/**
 * 
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
 * 
 *  对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i
 * ]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
 *  
 * 
 *  示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释: 
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 *  
 * 
 *  示例 2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释: 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 *  提示：
 *  1 <= g.length <= 3 * 10^4
 *  0 <= s.length <= 3 * 10^4
 *  1 <= g[i], s[j] <= 2^31 - 1
 *  
 *  Related Topics 贪心 数组 排序 
 *  👍 345 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/5
 */
public class I455I_FindContentChildren {
    public static void main(String[] args) {
        I455I_FindContentChildren children = new I455I_FindContentChildren();
        int[] g = new int[]{1,2,3}, s = new int[]{1,1};
        System.out.println(children.findContentChildrenII(g, s));
        g = new int[]{1,2}; s= new int[]{1,2,3};
        System.out.println(children.findContentChildrenII(g, s));

    }

    /**
     * 				解答成功:
     * 				执行耗时:76 ms,击败了5.28% 的Java用户
     * 				内存消耗:39.3 MB,击败了32.92% 的Java用户
     *
     * 时间复杂度: O(N+M)
     * 空间复杂度: O(1)
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length <= 0) return 0;
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        for (int i = 0, gl = g.length, sl = s.length; i < gl; i++) {
            if (g[i] > s[sl-1]) return count;
            for (int j = 0; j < sl; j++) {
                if (s[j] >= g[i]) {
                    count++;
                    s[j] = 0;
                    break;
                }
            }
        }
        return count;

    }


    /**
     * 一些优化
     *
     * 				解答成功:
     * 				执行耗时:76 ms,击败了90.00% 的Java用户
     * 				内存消耗:39.3 MB,击败了31.00% 的Java用户
     * @param g
     * @param s
     * @return
     */
    public int findContentChildrenII(int[] g, int[] s) {
        if (s == null || s.length <= 0) return 0;
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        for (int i = 0, j= 0, gl = g.length, sl = s.length; i < gl && j < sl; i++, j++) {
            while (j < sl &&g[i] > s[j]) {
                j++;
            }
            if (j<sl && s[j] >= g[i]) count++;
        }
        return count;

    }

}
