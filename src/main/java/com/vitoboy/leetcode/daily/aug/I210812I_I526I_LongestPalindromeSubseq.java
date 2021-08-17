package com.vitoboy.leetcode.daily.aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @problem leetcode
 * @description 516.最长回文子序列
 * 
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
 * 
 *  子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
 *
 *  示例 1：
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 *  示例 2：
 * 输入：s = "cbbd"
 * 输出：2
 * 解释：一个可能的最长回文子序列为 "bb" 。
 *
 *  示例 3:
 * 输入: s = "bbbbb"
 * 输出: 5
 * 解释: 一个可能的最长回文子序列为 "bbbbb" 。
 *
 *  示例 4:
 * 输入: s = "abcbabcba"
 * 输出: 9
 * 解释: 一个可能的最长回文子序列为 "abcbabcba" 。
 *
 *  提示：
 *  1 <= s.length <= 1000 
 *  s 仅由小写英文字母组成 
 *  
 *  Related Topics 字符串 动态规划 
 *  👍 532 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/8/12
 */
public class I210812I_I526I_LongestPalindromeSubseq {
    public static void main(String[] args) {
        
    }

    /**
     *
     * todo
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        int maxLen = 1, begin = 0;
        for (int i = 0; i < len; i++) {
            List<Integer> list = map.get(s.charAt(i));
            if (maxLen > list.get(list.size()-1) - i) continue;
//            for (int j = 0; j < len; j++) {
//
//            }

        }

        return 0;
    }
}
