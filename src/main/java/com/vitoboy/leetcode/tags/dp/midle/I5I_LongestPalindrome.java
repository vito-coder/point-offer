package com.vitoboy.leetcode.tags.dp.midle;


/**
 * @problem leetcode
 * @description 5.最长回文子串
 * 
 * 给你一个字符串 s，找到 s 中最长的回文子串。 
 *
 *  示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *  
 * 
 *  示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 * 
 *  示例 3：
 * 输入：s = "a"
 * 输出："a"
 *  
 * 
 *  示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 *  提示：
 *  1 <= s.length <= 1000 
 *  s 仅由数字和英文字母（大写和/或小写）组成 
 *  
 *  Related Topics 字符串 动态规划 
 *  👍 3944 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/12
 */
public class I5I_LongestPalindrome {
    public static void main(String[] args) {
        I5I_LongestPalindrome palindrome = new I5I_LongestPalindrome();
        String s = "babad";
        System.out.println(palindrome.longestPalindromeCenter(s));
        System.out.println("expect is : bab");
        s = "cbbd";
        System.out.println(palindrome.longestPalindromeCenter(s));
        System.out.println("expect is : bb");
        s = "ac";
        System.out.println(palindrome.longestPalindromeCenter(s));
        System.out.println("expect is : a");
        s = "bb";
        System.out.println(palindrome.longestPalindromeCenter(s));
        System.out.println("expect is : bb");
    }

    /**
     * f[i][j] 表示 开始为i, 结束为j 为回文串, 长度 l = j-i+1
     * 那么如果长度大于3时, 有 f[i+1][j-1] 也是回文串
     *
     * 如果 i=j 时, f[i][j] 必定是回文串
     * 如果 j=i+1时, f[i][j] 是回文串有如下要求: s.charAt(i) == s.charAt(j)
     *
     * 				解答成功:
     * 				执行耗时:179 ms,击败了45.76% 的Java用户
     * 				内存消耗:42.8 MB,击败了20.96% 的Java用户
     *
     *
     * 动态规划解法
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        char[] chars = s.toCharArray();

        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        // 单个字符必定是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 按回文串长度迭代计算
        for (int L = 2; L <= len; L++) {
            // 确定左下标, 再确定右下标
            for (int i = 0; i < len; i++) {
                int j = L+i-1;
                if (j >= len) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j-i > 2) {
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j] && L > maxLen) {
                    maxLen = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }


    /**
     * 中心化解法
     *
     * 				解答成功:
     * 				执行耗时:24 ms,击败了88.35% 的Java用户
     * 				内存消耗:38.1 MB,击败了98.25% 的Java用户
     *
     * @param s
     * @return
     */
    public String longestPalindromeCenter(String s){
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1, begin = 0;

        for (int i = 0; i < len; i++) {
            int l1 = expendFromCenter(s, i, i);
            int l2 = expendFromCenter(s, i, i+1);
            int max = Math.max(l1, l2);
            if (max > maxLen) {
                maxLen = max;
                begin = i-(max-1)/2;
            }
        }

        return s.substring(begin, begin+maxLen);
    }

    private int expendFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right-left-1;
    }


}
