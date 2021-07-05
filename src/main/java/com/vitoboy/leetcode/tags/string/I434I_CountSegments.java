package com.vitoboy.leetcode.tags.string;

/**
 * 
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
 * 
 *  请注意，你可以假定字符串里不包括任何不可打印的字符。 
 * 
 *  示例:
 *  输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *  
 *  Related Topics 字符串 
 *  👍 90 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/5
 */
public class I434I_CountSegments {
    public static void main(String[] args) {
        I434I_CountSegments segments = new I434I_CountSegments();
        String s = "Hello, my name is John";
        System.out.println(segments.countSegmentsII(s));
        s = "Hello, my name is      John      ";
        System.out.println(segments.countSegmentsII(s));

    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.4 MB,击败了27.47% 的Java用户
     *
     * 使用类库实现
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        String[] words = s.trim().split(" ");
        int count = 0;
        for (String word : words) {
            if (word.trim().length() > 0) count++;
        }
        return count;
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.2 MB,击败了51.26% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param s
     * @return
     */
    public int countSegmentsII(String s) {
        int count = 0, i=0;
        boolean space = false;
        s = s + " ";
        while (i < s.length()) {
            if (s.charAt(i) != ' ') break;
            i++;
        }
        for (int len = s.length(); i < len; i++) {
            char ch = s.charAt(i);
            if (ch == ' '){
                if (space) continue;
                else {
                    space = true;
                    count++;
                }
            } else {
                space = false;
            }
        }
        if (!space && count > 0) return count+1;
        return count;
    }
}
