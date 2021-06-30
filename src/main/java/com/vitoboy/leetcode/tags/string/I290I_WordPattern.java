package com.vitoboy.leetcode.tags.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
 * 
 *  这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
 * 
 *  示例1:
 *  输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true 
 * 
 *  示例 2:
 *  输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false 
 * 
 *  示例 3:
 *  输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false 
 * 
 *  示例 4:
 *  输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false 
 * 
 *  说明: 
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
 *  Related Topics 哈希表 字符串 
 *  👍 350 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/30
 */
public class I290I_WordPattern {
    public static void main(String[] args) {
        I290I_WordPattern wordPattern = new I290I_WordPattern();
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, s));
        System.out.println("expce is : true");
        s = "dog cat cat fish";
        System.out.println(wordPattern.wordPattern(pattern, s));
        System.out.println("expce is : false");
        pattern = "aaaa";
        s = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, s));
        System.out.println("expce is : false");
        pattern = "abba";
        s = "dog dog dog dog";
        System.out.println(wordPattern.wordPattern(pattern, s));
        System.out.println("expce is : false");
    }


    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.13% 的Java用户
     * 				内存消耗:36.1 MB,击败了89.41% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> dataMap = new HashMap<>();
        Map<String, Character> charMap = new HashMap<>();
        int len = pattern.length();
        String[] strings = s.split(" ");
        if (len != strings.length) return false;
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (dataMap.containsKey(c)) {
                String tmp = dataMap.get(c);
                if (!tmp.equals(strings[i])) return false;
            } else {
                if (charMap.containsKey(strings[i])) return false;
                dataMap.put(c, strings[i]);
                charMap.put(strings[i], c);
            }
        }
        
        return true;
    }
}
