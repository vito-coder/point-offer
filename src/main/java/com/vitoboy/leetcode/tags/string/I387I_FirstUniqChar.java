package com.vitoboy.leetcode.tags.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
 *
 *  示例：
 *  s = "leetcode"
 * 返回 0
 * 
 * s = "loveleetcode"
 * 返回 2
 *
 *  提示：你可以假定该字符串只包含小写字母。 
 *  Related Topics 队列 哈希表 字符串 计数 
 *  👍 412 👎 0
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/2
 */
public class I387I_FirstUniqChar {
    public static void main(String[] args) {
        I387I_FirstUniqChar uniqChar = new I387I_FirstUniqChar();
        String s = "leetcode";
        System.out.println(uniqChar.firstUniqChar(s));
        System.out.println("expect is : 0");
        s = "loveleetcode";
        System.out.println(uniqChar.firstUniqChar(s));
        System.out.println("expect is : 2");

    }

    /**
     * 				解答成功:
     * 				执行耗时:35 ms,击败了35.06% 的Java用户
     * 				内存消耗:39.1 MB,击败了24.81% 的Java用户
     *
     * 	时间复杂度: O(N)
     * 	空间复杂度: O(E)  E 表示字符集
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Boolean> charMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (charMap.containsKey(ch)) {
                charMap.put(ch, false);
            } else {
                charMap.put(ch, true);
            }
        }
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (charMap.get(ch)) return i;
        }
        return -1;
    }


    /**
     * 数组优化
     * 				解答成功:
     * 				执行耗时:6 ms,击败了91.96% 的Java用户
     * 				内存消耗:38.4 MB,击败了98.69% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @return
     */
    public int firstUniqCharII(String s) {
        int[] alp = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            alp[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < len; i++) {
            if(alp[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }
}
