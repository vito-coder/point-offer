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
        I210718I_Iinterview_10_02I_GroupAnagrams anagrams = new I210718I_Iinterview_10_02I_GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(anagrams.groupAnagrams(strs));
        System.out.println("expect is :  [[\"ate\",\"eat\",\"tea\"],[\"nat\",\"tan\"],[\"bat\"] ] ");
    }


    /**
     * 				解答成功:
     * 				执行耗时:7 ms,击败了73.68% 的Java用户
     * 				内存消耗:41.1 MB,击败了89.01% 的Java用户
     *
     * 简单实现
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);
            List<String> list = map.getOrDefault(tmp, new ArrayList<>());
            list.add(str);
            if (list.size() == 1) {
                map.put(tmp, list);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    class Node{
        char c;
        List<String> list;
        Node[] child;
        Node(char _c) {c = _c;}
    }

    /**
     * 				解答成功:
     * 				执行耗时:8 ms,击败了48.94% 的Java用户
     * 				内存消耗:45.6 MB,击败了5.03% 的Java用户
     *
     * 时间复杂度: O(N*M*logM)
     * 空间复杂度: O(N)
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsII(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Node root = new Node(' '), cur = root;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            cur = root;
            for (int i = 0, len = chars.length; i < len; i++) {
                if (cur.child == null) {
                    cur.child = new Node[26];
                }
                Node node = cur.child[chars[i]-'a'];
                if (node == null) {
                    node = new Node(chars[i]);
                    cur.child[chars[i]-'a'] = node;
                }
                cur = node;
            }
            if (cur != null) {
                if (cur.list == null) {
                    cur.list = new ArrayList<>();
                    ans.add(cur.list);
                }
                cur.list.add(str);
            }
        }
        return ans;
    }
}
