package com.vitoboy.leetcode.tags.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
 * 
 *  在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
 * 
 *  注意: 
 * 假设字符串的长度不会超过 1010。 
 * 
 *  示例 1:
 * 输入: "abccccdd"
 * 输出: 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *  
 *  Related Topics 贪心 哈希表 字符串 
 *  👍 302 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I409I_LongestPalindrome {
    public static void main(String[] args) {
        I409I_LongestPalindrome palindrome = new I409I_LongestPalindrome();
        String s = "abccccdd";
        System.out.println(palindrome.longestPalindrome(s));
        System.out.println("expect is : 7");
        s = "abccccddb";
        System.out.println(palindrome.longestPalindrome(s));
        System.out.println("expect is : 9");

    }


    /**
     * 				解答成功:
     * 				执行耗时:13 ms,击败了5.63% 的Java用户
     * 				内存消耗:36.6 MB,击败了78.63% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(E) E表示字符串的字符集
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (countMap.containsKey(s.charAt(i))){
                countMap.put(s.charAt(i), countMap.get(s.charAt(i))+1);
            } else {
                countMap.put(s.charAt(i), 1);
            }
        }
        int max = 0, sum = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                sum += entry.getValue();
            } else {
                sum += entry.getValue() - 1;
                max = entry.getValue();
            }
        }
        if (max == 0) return sum;
        return sum+1;
    }
}
