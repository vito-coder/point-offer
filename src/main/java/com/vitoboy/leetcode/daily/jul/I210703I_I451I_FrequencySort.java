package com.vitoboy.leetcode.daily.jul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 
 * 
 *  示例 1:
 * 输入: "tree"
 * 输出: "eert"
 * 
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *  
 * 
 *  示例 2:
 * 输入: "cccaaa"
 * 输出: "cccaaa"
 * 
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *  
 * 
 *  示例 3:
 * 输入: "Aabb"
 * 输出: "bbAa"
 * 
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *  
 *  Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
 *  👍 309 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/3
 */
public class I210703I_I451I_FrequencySort {
    public static void main(String[] args) {
        I210703I_I451I_FrequencySort sort = new I210703I_I451I_FrequencySort();
        String str = "tree";
        System.out.println(sort.frequencySort(str));
        System.out.println("expect is : eert or eetr");
        str = "cccaaa";
        System.out.println(sort.frequencySort(str));
        System.out.println("expect is : cccaaa or aaaccc");
        str = "Aabb";
        System.out.println(sort.frequencySort(str));
        System.out.println("expect is : bbaA or bbAa");
    }

    /**
     * 				解答成功:
     * 				执行耗时:22 ms,击败了34.67% 的Java用户
     * 				内存消耗:39.2 MB,击败了76.64% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if(s == null || s.length() < 2) return s;
        Map<Character, CharCount> map = new HashMap<>();
        char ch;
        for (int i = 0, len = s.length(); i < len; i++) {
            ch = s.charAt(i);
            if (map.containsKey(ch)) {
                CharCount count = map.get(ch);
                count.setCount(count.getCount() + 1);
                count.getStr().append(ch);
            } else {
                map.put(ch, new CharCount(ch, 1));
            }
        }
        List<CharCount> list = new ArrayList<>(map.values());
        list.sort(((o1, o2) -> {return o2.getCount()-o1.getCount();}));
        StringBuilder builder = new StringBuilder();
        for (CharCount count : list) {
            builder.append(count.str);
        }
        return builder.toString();
    }

    class CharCount{
        StringBuilder str;
        Integer count;
        public CharCount(char ch, int count) {
            this.str = new StringBuilder();
            this.str.append(ch);
            this.count = count;
        }
        public StringBuilder getStr() {
            return str;
        }

        public void setStr(StringBuilder str) {
            this.str = str;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }
}
