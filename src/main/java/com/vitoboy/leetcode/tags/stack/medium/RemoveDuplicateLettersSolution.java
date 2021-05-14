package com.vitoboy.leetcode.tags.stack.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
 * 
 *  注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
 * -characters 相同 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：s = "bcabc"
 * 输出："abc"
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：s = "cbacdcbc"
 * 输出："acdb" 
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= s.length <= 104 
 *  s 由小写英文字母组成 
 *  
 *  Related Topics 栈 贪心算法 字符串 
 *  👍 445 👎 0
 *
 * @Author: vito
 * @Date: 2021/1/22 下午1:28
 * @Version: 1.0
 */
public class RemoveDuplicateLettersSolution {
    // todo 待解决问题
    public static void main(String[] args) {
        RemoveDuplicateLettersSolution solution = new RemoveDuplicateLettersSolution();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));

    }


    /**
     * 去除重复字母实现(vito)
     *
     * 用int数组记录各个字母是否出现(-1表示未出现)
     * 用栈(双向链表)存储字符, 尽可能以a->z顺序
     * i.如果字符出现过, 且栈的顶点字符的值小于当前字符, 则启动替换字符策略(将栈内的同字符删除, 再将此字符入栈)
     * ii. 如果字符没出现过, 记录字符到int数组, 字符入栈
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int[] array = new int[26];
        //Arrays.fill(array, -1);
        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for (char c : s.toCharArray()) {
            if (array[c-'a'] > 0) {
                if (!stack.isEmpty() && stack.peek() < c) {
                    temp.push(c);
                    char top = stack.pop();
                    while (top != c) {
                        temp.push(top);
                        top = stack.pop();
                    }
                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                }
            } else {
                stack.push(c);
                array[c-'a'] = 1;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }


    /**
     * 去除重复字母实现(vito)
     *
     * @param s
     * @return
     */
    public String removeDuplicateLettersWrong(String s) {
        if (s == null || s.length() < 2){
            return s;
        }
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c-'a'] = 1;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }
            builder.append((char)(i+'a'));
        }
        return builder.toString();
    }


}
