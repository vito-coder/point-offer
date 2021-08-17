package com.vitoboy.leetcode.tags.dp.midle;

/**
 * @problem leetcode
 * @description 647.回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
 * 
 *  具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
 *
 *  示例 1：
 *  输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 *  示例 2：
 *  输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
 *
 *  提示：
 *  输入的字符串长度不会超过 1000 。 
 *  
 *  Related Topics 字符串 动态规划 
 *  👍 649 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/12
 */
public class I647I_CountSubstrings {
    public static void main(String[] args) {
        I647I_CountSubstrings count = new I647I_CountSubstrings();
        String s= "abc";
        System.out.println(count.countSubstringsCenter(s));
        System.out.println("expect is : 3");
        s= "aaa";
        System.out.println(count.countSubstringsCenter(s));
        System.out.println("expect is : 6");
        s= "";
        System.out.println(count.countSubstringsCenter(s));
        System.out.println("expect is : ");
    }

    /**
     * 动态规划解法
     * 				解答成功:
     * 				执行耗时:20 ms,击败了11.14% 的Java用户
     * 				内存消耗:38.4 MB,击败了39.60% 的Java用户
     *
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(N^2)
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) {
            return 1;
        }
        int count = len;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i -1;
                if (j >= len) break;
                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                } else {
                    if (L == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j]) count++;
            }
        }
        return count;
    }


    /**
     * 中心化扩展解法
     *
     * 				解答成功:
     * 				执行耗时:2 ms,击败了96.02% 的Java用户
     * 				内存消耗:36.4 MB,击败了81.27% 的Java用户
     *
     * @param s
     * @return
     */
    public int countSubstringsCenter(String s) {
        int len = s.length();
        if (len < 2) return 1;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int f1 = expendCenter(s, i, i);
            int f2 = expendCenter(s, i, i+1);
            count += (f1/2+1 + f2/2);
        }
        return count;
    }

    private int expendCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }
}
