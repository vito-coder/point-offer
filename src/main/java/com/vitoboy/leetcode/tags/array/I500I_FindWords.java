package com.vitoboy.leetcode.tags.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
 * 
 *  美式键盘 中：
 *  第一行由字符 "qwertyuiop" 组成。 
 *  第二行由字符 "asdfghjkl" 组成。 
 *  第三行由字符 "zxcvbnm" 组成。 
 *
 *  示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 *  
 * 
 *  示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 *  
 * 
 *  示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 *  提示：
 *  1 <= words.length <= 20 
 *  1 <= words[i].length <= 100 
 *  words[i] 由英文字母（小写和大写字母）组成 
 *  
 *  Related Topics 数组 哈希表 字符串 
 *  👍 135 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/7
 */
public class I500I_FindWords {
    public static void main(String[] args) {
        I500I_FindWords findWords = new I500I_FindWords();
        String[] words = new String[]{"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords.findWords(words)));
        System.out.println("expect is : [\"Alaska\",\"Dad\"]");

    }


    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了62.11% 的Java用户
     * 				内存消耗:36.5 MB,击败了45.00% 的Java用户
     *
     * 	时间复杂度: O(NM)
     * 	空间复杂度: O(N)
     *
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        Set<Character> first = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> second = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> third = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));
        Set<Character> tmp = null; boolean same = false;
        int[] index = new int[words.length]; int count = 0;
        for (int j=0, wl = words.length; j < wl; j++) {
            String word = words[j];
            if (first.contains(toLowerCase(word.charAt(0)))) {
                tmp = first;
            } else if (second.contains(toLowerCase(word.charAt(0)))) {
                tmp = second;
            } else {
                tmp = third;
            }
            same = true;
            for (int i = 1, len = word.length(); i < len; i++) {
                if (!tmp.contains(toLowerCase(word.charAt(i)))){
                    same = false;
                    break;
                }
            }
            if (same) {
                index[j] = 1;
                count++;
            }
        }
        String[] strings = new String[count]; count = 0;
        for (int len = 0; len < index.length; len++) {
            if (index[len] > 0) {
                strings[count] = words[len];
                count++;
            }
        }
        return strings;
    }

    private char toLowerCase(char ch) {
        if (ch >= 'A' && ch <='Z') {
            return (char)('a' + ch - 'A');
        } else return ch;
    }
}
