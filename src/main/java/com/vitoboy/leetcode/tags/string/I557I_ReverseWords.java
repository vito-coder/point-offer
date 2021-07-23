package com.vitoboy.leetcode.tags.string;

/**
 * @problem leetcode
 * @description 557 反转字符串中的单词III
 * 
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
 *
 *  示例：
 *  输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 *  提示：
 *  在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
 *  
 *  Related Topics 双指针 字符串 
 *  👍 310 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/23
 */
public class I557I_ReverseWords {
    public static void main(String[] args) {
        I557I_ReverseWords words = new I557I_ReverseWords();
        String s = "Let's take LeetCode contest";
        System.out.println(words.reverseWords(s));
        System.out.println("expect is : s'teL ekat edoCteeL tsetnoc");
    }

    /**
     * 				解答成功:
     * 				执行耗时:11 ms,击败了23.40% 的Java用户
     * 				内存消耗:38.7 MB,击败了91.90% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder newWords = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length-1; i >= 0; i--) {
            if (chars[i] == ' ') {
                newWords.insert(0, temp.toString());
                newWords.insert(0, ' ');
                temp = new StringBuilder();
            } else {
                temp.append(chars[i]);
            }
        }
        return newWords.insert(0, temp.toString()).toString();
    }
    
}
