package com.vitoboy.leetcode.tags.dp.midle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @problem leetcode
 * @description 139.单词拆分
 * 
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
 * 
 *  说明：
 *  拆分时可以重复使用字典中的单词。 
 *  你可以假设字典中没有重复的单词。 
 *  
 * 
 *  示例 1：
 *  输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *  
 * 
 *  示例 2：
 *  输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 *  示例 3：
 *  输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *  
 *  Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 
 *  👍 1080 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/30
 */
public class I139I_WordBreak {
    public static void main(String[] args) {
        I139I_WordBreak wordBreak = new I139I_WordBreak();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak.wordBreak(s, wordDict));
        System.out.println("expect is : true");
        s = "applepenapple";
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreak.wordBreak(s, wordDict));
        System.out.println("expect is : true");
        s = "catsandog";
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak.wordBreak(s, wordDict));
        System.out.println("expect is : false");
        // "bb"
        //["a","b","bbb","bbbb"]
        s = "bb";
        wordDict = Arrays.asList("a","b","bbb","bbbb");
        System.out.println(wordBreak.wordBreak(s, wordDict));
        System.out.println("expect is : true");

    }

    /**
     * wordDict ==> map/set
     *
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> map = wordDict.stream().collect(Collectors.groupingBy(s1 -> {return s1.charAt(0);}));
        List<String> start = map.getOrDefault(s.charAt(0), null);
        if (start == null) return false;
        for (int i = 0, len = start.size(); i < len; i++) {
            boolean check = checkStringCanStart(start.get(i), 0, s, map);
            if (check) return true;
        }
        return false;
    }

    private boolean checkStringCanStart(String start, int index, String s, Map<Character, List<String>> map){
        if (s.length() < index+start.length()) {
            return false;
        }
        String sub = s.substring(index, index+start.length());
        if (sub.equals(start)) {
            index = start.length() + index;
            if (index == s.length()) {
                return true;
            } else if (index > s.length()) {
                return false;
            }
            List<String> list = map.getOrDefault(s.charAt(index), null);
            if (list == null) return false;
            for (int i = 0, len = list.size(); i < len; i++) {
                boolean check = checkStringCanStart(list.get(i), index, s, map);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }
}
