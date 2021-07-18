package com.vitoboy.leetcode.daily.jul;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。 
 * 
 *  注意：本题相对原题稍作修改 
 * 
 *  示例:
 *  输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ] 
 * 
 *  说明：
 *  所有输入均为小写字母。 
 *  不考虑答案输出的顺序。 
 *  
 *  Related Topics 哈希表 字符串 排序 
 *  👍 76 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/18
 */
public class I210718I_Iinterview_10_02I_GroupAnagrams {
    public static void main(String[] args) {
        
    }

    /**
     * todo
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<List<Character>> charList  = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            if (charList.isEmpty()) {
                List<Character> list = new ArrayList<>();
                for (char aChar : chars) {
                    list.add(aChar);
                }
            }
        }


        return null;
    }
}
