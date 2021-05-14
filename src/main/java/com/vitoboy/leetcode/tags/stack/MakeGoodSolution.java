package com.vitoboy.leetcode.tags.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * 给你一个由大小写英文字母组成的字符串 s 。 
 * 
 *  一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件: 
 * 
 *  
 *  若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。 
 *  若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。 
 *  
 * 
 *  请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。 
 * 
 *  请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。 
 * 
 *  注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 *  
 * 
 *  示例 3： 
 * 
 *  
 * 输入：s = "s"
 * 输出："s"
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= s.length <= 100 
 *  s 只包含小写和大写英文字母 
 *  
 *  Related Topics 栈 字符串 
 *  👍 18 👎 0
 * 
 * @Author: vito
 * @Date: 2021/2/5 下午1:20
 * @Version: 1.0
 */
public class MakeGoodSolution {
    public static void main(String[] args) {
        MakeGoodSolution solution = new MakeGoodSolution();
        String str = "leEeetcode";
        System.out.println("result is : " + solution.makeGoodII(str));
        System.out.println("expect is : leetcode");
        str = "abBAcC";
        System.out.println("result is : " + solution.makeGoodII(str));
        System.out.println("expect is : ");
        str = "s";
        System.out.println("result is : " + solution.makeGoodII(str));
        System.out.println("expect is : s");
    }


    /**
     *				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.8 MB,击败了96.95% 的Java用户
     *
     * @param s
     * @return
     */
    public String makeGoodII(String s) {
        char[] cs = new char[s.length()];
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (length > 0) {
                if (Math.abs(cs[length - 1] - c) == 32) {
                    length--;
                    continue;
                }
            }

            cs[length++] = c;
        }

        return String.valueOf(Arrays.copyOf(cs, length));
    }


    /**
     * 				解答成功:
     * 				执行耗时:2 ms,击败了87.50% 的Java用户
     * 				内存消耗:37 MB,击败了80.85% 的Java用户
     *
     * @param s
     * @return
     */
    public String makeGoodI(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if (index == 0) {
                chars[index++] = aChar;
            } else {
                if (change(aChar) == chars[index-1]) {
                    index--;
                } else {
                    chars[index++] = aChar;
                }
            }
        }
        return new String(chars, 0, index);
    }



    /**
     *
     * 				解答成功:
     * 				执行耗时:4 ms,击败了27.62% 的Java用户
     * 				内存消耗:38.5 MB,击败了32.55% 的Java用户
     *
     * @param s
     * @return
     */
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
            }
            else {
                if (change(aChar) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }

    private char change(char c) {
        if (c >= 'a') {
            return (char) ('A' + (c - 'a'));
        } else {
            return (char) ('a' + (c - 'A'));
        }
    }
}
