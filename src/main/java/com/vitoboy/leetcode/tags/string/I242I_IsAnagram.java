package com.vitoboy.leetcode.tags.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
 * 
 *  示例 1: 
 * 
 *  输入: s = "anagram", t = "nagaram"
 * 输出: true
 *  
 * 
 *  示例 2: 
 * 
 *  输入: s = "rat", t = "car"
 * 输出: false 
 * 
 *  说明: 
 * 你可以假设字符串只包含小写字母。 
 * 
 *  进阶: 
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
 *  Related Topics 哈希表 字符串 排序 
 *  👍 397 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/29
 */
public class I242I_IsAnagram {

    public static void main(String[] args) {
        I242I_IsAnagram anagram = new I242I_IsAnagram();
        String s = "anagram", t = "nagaram";
        System.out.println(anagram.isAnagram(s, t));
        s = "rat"; t = "car";
        System.out.println(anagram.isAnagram(s, t));

    }


    /**
     * 				解答成功:
     * 				执行耗时:32 ms,击败了5.06% 的Java用户
     * 				内存消耗:39.3 MB,击败了10.97% 的Java用户
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if (smap.containsKey(sc)) {
                smap.put(sc, smap.get(sc) + 1);
            } else {
                smap.put(sc, 1);
            }
            if (tmap.containsKey(tc)) {
                tmap.put(tc, tmap.get(tc) + 1);
            } else {
                tmap.put(tc, 1);
            }
        }
        if (tmap.size() != smap.size()) return false;
        for (Map.Entry<Character, Integer> entry : smap.entrySet()) {
            if (!tmap.containsKey(entry.getKey())) return false;
            if(tmap.get(entry.getKey()).intValue() != entry.getValue()) {
                return false;
            }
        }
        return true;
    }


    /**
     * 小优化, 使用数组, 共用变量
     *
     * 				解答成功:
     * 				执行耗时:4 ms,击败了62.14% 的Java用户
     * 				内存消耗:38.7 MB,击败了55.94% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramII(String s, String t) {
        int[] alp = new int[26];
        char c = 'a';
        if (s == null || t == null || s.length() != t.length()) return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            ++alp[s.charAt(i) - c];
            --alp[t.charAt(i) - c];
        }
        for (int i = 0; i < 26; i++) {
            if (alp[i] != 0) return false;
        }
        return true;
    }

}
