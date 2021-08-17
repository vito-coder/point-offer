package com.vitoboy.leetcode.tags.string;

/**
 * @problem leetcode 
 * @description 680.验证回文字符串 II
 * 
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
 *
 *  示例 1:
 * 输入: s = "aba"
 * 输出: true
 *  
 * 
 *  示例 2:
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 *  
 * 
 *  示例 3:
 * 输入: s = "abc"
 * 输出: false 
 *
 *  提示:
 *  1 <= s.length <= 105 
 *  s 由小写英文字母组成 
 *  
 *  Related Topics 贪心 双指针 字符串 
 *  👍 380 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/12
 */
public class I680I_ValidPalindrome {
    public static void main(String[] args) {
        I680I_ValidPalindrome palindrome = new I680I_ValidPalindrome();
        String s = "aba";
        System.out.println(palindrome.validPalindrome(s));
        System.out.println("expect is : true");
        s = "abca";
        System.out.println(palindrome.validPalindrome(s));
        System.out.println("expect is : true");
        s = "abc";
        System.out.println(palindrome.validPalindrome(s));
        System.out.println("expect is : false");
        s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(palindrome.validPalindrome(s));
        System.out.println("expect is : true");
        s = "acxcybycxcxa";
        System.out.println(palindrome.validPalindrome(s));
        System.out.println("expect is : true");

    }


    /**
     * 				解答成功:
     * 				执行耗时:6 ms,击败了91.41% 的Java用户
     * 				内存消耗:38.8 MB,击败了80.31% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len < 2) return true;
        int left = 0, right = 0;
        boolean lb = true, rb = true;
        for (int i = 0, j=len-i-1; i < j; i++, j--) {
            if (left == right) {
                if (s.charAt(i) != s.charAt(j) && lb && rb) {
                    left = -1;
                    right = 1;
                    lb = s.charAt(i-left) == s.charAt(j);
                    rb = s.charAt(i) == s.charAt(j-right);
                    if (!lb && !rb) return false;
                }
            } else {
                if (lb) {
                    lb = s.charAt(i-left) == s.charAt(j);
                }
                if (rb) {
                    rb = s.charAt(i) == s.charAt(j-right);
                }
                if (!lb && !rb) return false;
            }
        }

        return lb || rb;
    }
}
