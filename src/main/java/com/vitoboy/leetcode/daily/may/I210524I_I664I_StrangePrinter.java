package com.vitoboy.leetcode.daily.may;

import java.util.Arrays;

/**
 * 
 * 有台奇怪的打印机有以下两个特殊要求： 
 * 
 *  
 *  打印机每次只能打印由 同一个字符 组成的序列。 
 *  每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。 
 *  
 * 
 *  给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：s = "aaabbb"
 * 输出：2
 * 解释：首先打印 "aaa" 然后打印 "bbb"。
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：s = "aba"
 * 输出：2
 * 解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= s.length <= 100 
 *  s 由小写英文字母组成 
 *  
 *  Related Topics 深度优先搜索 动态规划 
 *  👍 132 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/24 上午9:50
 * @Version: 1.0
 */
public class I210524I_I664I_StrangePrinter {
    public static void main(String[] args) {

        String s = "aaabbb";
        I210524I_I664I_StrangePrinter strangePrinter = new I210524I_I664I_StrangePrinter();
        System.out.println(strangePrinter.strangePrinter(s));

    }

    /**
     * 可以这么考虑, 化繁为简
     * 1. 如果只有一个字符`a`: 打印一次
     * 2. 如果有两个字符`ab`: 打印两次
     * 3. 如果有两个字符`aa`: 打印一次
     * 4. 如果有三个字符`aba`: 打印三次, 在 2 的基础上, 再打印一次
     * 4.1 如果有三个字符`abb`: 打印两次, 在`ab`和`bb`基础上, 取最小值, 再加1, 即 1+1 = 2
     * 5. 如果有四个字符`abab`: 打印四次, 在 4 的基础上, 再打印一次
     *
     * 总结规律:
     * 打印区间为 [i, j]时, 如果f[i][j]表示区间打印的次数,
     * 那么有:
     *      如果 s[i] = s[j]时, f[i][j] = f[i][j-1]
     *      如果 s[i] != s[j]时, 有f[i][j] = f[i][j-1] + 1
     *
     *
     * 				解答成功:
     * 				执行耗时:17 ms,击败了60.06% 的Java用户
     * 				内存消耗:38.2 MB,击败了91.74% 的Java用户
     *
     *
     * @param s
     * @return
     */
    public int strangePrinter(String s) {
        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = l-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < l; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][l-1];
    }


    /**
     *
     * 				解答成功:
     * 				执行耗时:34 ms,击败了34.99% 的Java用户
     * 				内存消耗:38 MB,击败了98.62% 的Java用户
     *
     *
     *     作者：AC_OIer
     *     链接：https://leetcode-cn.com/problems/strange-printer/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-xqeo9/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int strangePrinterII(String s) {
        int n = s.length();
        int[][] f = new int[n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                f[l][r] = f[l + 1][r] + 1;
                for (int k = l + 1; k <= r; k++) {
                    if (s.charAt(l) == s.charAt(k)) {
                        f[l][r] = Math.min(f[l][r], f[l][k - 1] + f[k + 1][r]);
                    }
                }
            }
        }
        return f[0][n - 1];
    }
}
