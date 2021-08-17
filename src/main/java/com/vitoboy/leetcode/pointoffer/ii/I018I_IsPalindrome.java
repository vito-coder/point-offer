package com.vitoboy.leetcode.pointoffer.ii;

/**
 * @problem leetcode
 * @description 剑指offer II 018. 有效的回文
 * 
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
 * 
 *  本题中，将空字符串定义为有效的 回文串 。 
 *
 *  示例 1:
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串 
 * 
 *  示例 2:
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串 
 *
 *  提示：
 *  1 <= s.length <= 2 * 10^5
 *  字符串 s 由 ASCII 字符组成
 *
 *  注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
 *  Related Topics 双指针 字符串 
 *  👍 0 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/12
 */
public class I018I_IsPalindrome {
    public static void main(String[] args) {
        I018I_IsPalindrome palindrome = new I018I_IsPalindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(palindrome.isPalindrome(s));
        System.out.println("expect is : true");
        s = "race a car";
        System.out.println(palindrome.isPalindrome(s));
        System.out.println("expect is : false");
    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了99.31% 的Java用户
     * 				内存消耗:38.5 MB,击败了66.67% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * 双指针
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0, j = len-1; i < j; i++, j--) {
            char first = getLowerChar(s.charAt(i));
            while (first == ' ' && ++i<j) {
                first = getLowerChar(s.charAt(i));
            }
            if (i == j) {
                return true;
            }
            char second = getLowerChar(s.charAt(j));
            while (second == ' ' && --j>i){
                second = getLowerChar(s.charAt(j));
            }
            if (i == j) {
                return true;
            }
            if (second != first) return false;
        }

        return true;
    }

    private char getLowerChar(char c) {
        if (c >= 'a' && c <= 'z') return c;
        if (c >= 'A' && c <= 'Z') return (char) ((c-'A')+'a');
        if (c >='0' && c <= '9') return c;
        else return ' ';
    }
}
