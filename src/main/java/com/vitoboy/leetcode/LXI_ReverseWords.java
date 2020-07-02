package com.vitoboy.leetcode;

import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/7/3 01:23
 * @Version: 1.0
 *
 * 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 *
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class LXI_ReverseWords {
    public static void main(String[] args) {
        LXI_ReverseWords reverseWords = new LXI_ReverseWords();
        //System.out.println(reverseWords.reverseWords("a good   example"));
        System.out.println(reverseWords.reverseWordsOfficial("  hello world!  "));
        System.out.println(reverseWords.reverseWordsOfficial("    "));
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0 || (s.length() == 1 && !s.equals(" "))) return s;
        char space = ' ';
        char[] str = s.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (str[i] == space) {
                if (word.length() > 0) {
                    stack.add(word.toString());
                    word = new StringBuilder();
                }
            } else {
                word.append(str[i]);
            }
        }
        if (word.length() > 0) {
            stack.add(word.toString());
        }
        StringBuilder words = new StringBuilder();
        while (stack.size() > 1) {
            words.append(stack.pop()).append(" ");
        }
        if (stack.size() > 0) {
            words.append(stack.pop());
        }
        return words.toString();
    }


    public String reverseWordsUpdate(String s) {
        if (s == null || s.length() == 0 || (s.length() == 1 && !s.equals(" "))) return s;
        String trim = s.trim();
        if (trim.length() == 0) return "";
        StringBuilder builder = new StringBuilder();
        while (trim.length() > 0) {
            int index = trim.lastIndexOf(" ");
            if (index >= 0) {
                builder.append(trim.substring(index + 1)).append(" ");
                trim = trim.substring(0, index).trim();
            } else {
                builder.append(trim);
                break;
            }
        }
        return builder.toString();
    }

    public String reverseWordsOfficial(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder words = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            words.append(s.substring(i + 1, j + 1)).append(' ');
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return words.toString().trim();
    }


    public String reverseWordsOfficialUpdate(String s) {
        String[] array = s.split(" ");
        StringBuilder words = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("")) continue;
            words.append(array[i]).append(" ");
        }
        return words.toString().trim();
    }
}
