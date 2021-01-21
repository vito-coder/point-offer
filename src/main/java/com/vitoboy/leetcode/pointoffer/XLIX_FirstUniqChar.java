package com.vitoboy.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: vito
 * @Date: 2020/7/1 22:30
 * @Version: 1.0
 *
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 */
public class XLIX_FirstUniqChar {
    public static void main(String[] args) {
        // todo
        String s = "abaccdeff";
        XLIX_FirstUniqChar uniqChar = new XLIX_FirstUniqChar();
        System.out.println(uniqChar.firstUniqChar(s));
    }

    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        char[] chars = s.toCharArray();
        if (s.length() == 1) return chars[0];
        // index = 0->a, 1->b
        // value = s.index
        // value = -1
        int[] status = new int[26];
        for (int i = 0; i < 26; i++) {
            status[i] = -2;
        }
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (status[index] == -2) {
                status[index] = i;
            } else if (status[index] > -1){
                status[index] = -1;
            }
        }
        int min = -1;
        char find = ' ';
        for (int i = 0; i < 26; i++) {
            if (min < 0) {
                if (status[i] >= 0) {
                    min = status[i];
                    find = (char) (i + 'a');
                }
            } else {
                if (status[i] >= 0 && status[i] < min) {
                    min = status[i];
                    find = (char) (i + 'a');
                }
            }
        }
        return find;
    }


    /**
     * 使用String 的 indexOf 方法和 lastIndexOf 方法
     * 如果 indexOf == lastIndexOf, 即说明此字符只出现一次
     * @param s
     * @return
     */
    public char firstUniqCharFaster(String s) {
        // 最优解，利用indexof和lastindexof来判断
        // 直接遍历'a'~'z'
        int min = s.length();
        for (char i = 'a'; i <= 'z'; i++){
            int indexof = s.indexOf(i);
            if (indexof!=-1&&s.lastIndexOf(i)==indexof){
                // 说明找到了一个不重复的字符  但是题目要求的是返回第一个不重复的字符 所以用 min 来记录最小的
                min = Math.min(indexof, min);
            }
        }
        // 如果 min 重来没有修改过 说明没有不重复的字符
        return min == s.length()? ' ' : s.charAt(min);
    }
}
