package com.vitoboy.leetcode.daily.aprilbefore;

/**
 *给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
 *
 * 
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
 * 
 *
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
 *
 * 
 *
 * 示例 1： 
 *
 * 
 *输入：text1 = "abcde", text2 = "ace" 
 *输出：3  
 *解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 
 *
 * 示例 2： 
 *
 * 
 *输入：text1 = "abc", text2 = "abc"
 *输出：3
 *解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 
 *
 * 示例 3： 
 *
 * 
 *输入：text1 = "abc", text2 = "def"
 *输出：0
 *解释：两个字符串没有公共子序列，返回 0 。
 * 
 *
 * 
 *
 * 提示： 
 *
 * 
 * 1 <= text1.length, text2.length <= 1000 
 * text1 和 text2 仅由小写英文字符组成。 
 * 
 * Related Topics 动态规划 
 * 👍 441 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/4/3 下午12:47
 * @Version: 1.0
 */
public class I1143ILongestCommonSubsequence {
    public static void main(String[] args) {

        ILongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String test1 = "abcde";
        String test2 = "ace";
        System.out.println("result is : " + longestCommonSubsequence.longestCommonSubsequence(test1, test2));
        System.out.println("expect is : 3");
        test1 = "abc";
        test2 = "abc";
        System.out.println("result is : " + longestCommonSubsequence.longestCommonSubsequence(test1, test2));
        System.out.println("expect is : 3");
        test1 = "abc";
        test2 = "def";
        System.out.println("result is : " + longestCommonSubsequence.longestCommonSubsequence(test1, test2));
        System.out.println("expect is : 0");
        test1 = "abc";
        test2 = "bcdf";
        System.out.println("result is : " + longestCommonSubsequence.longestCommonSubsequence(test1, test2));
        System.out.println("expect is : 2");
        test1 = "abc";
        test2 = "acdf";
        System.out.println("result is : " + longestCommonSubsequence.longestCommonSubsequence(test1, test2));
        System.out.println("expect is : 2");



    }

    interface ILongestCommonSubsequence {
        int longestCommonSubsequence(String text1, String text2);
    }

    /**
     * 动态规划 还是不会啊
     * 				解答成功:
     * 				执行耗时:10 ms,击败了84.20% 的Java用户
     * 				内存消耗:42.1 MB,击败了69.37% 的Java用户
     */
    static class LongestCommonSubsequence implements ILongestCommonSubsequence {

        @Override
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length(), n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                char c1 = text1.charAt(i - 1);
                for (int j = 1; j <= n; j++) {
                    char c2 = text2.charAt(j - 1);
                    if (c1 == c2) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }

}
