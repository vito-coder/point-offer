package com.vitoboy.leetcode.tags.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
 * 
 *  有效字符串需满足： 
 * 
 *  
 *  左括号必须用相同类型的右括号闭合。 
 *  左括号必须以正确的顺序闭合。 
 *  
 * 
 *  注意空字符串可被认为是有效字符串。 
 * 
 *  示例 1: 
 * 
 *  输入: "()"
 * 输出: true
 *  
 * 
 *  示例 2: 
 * 
 *  输入: "()[]{}"
 * 输出: true
 *  
 * 
 *  示例 3: 
 * 
 *  输入: "(]"
 * 输出: false
 *  
 * 
 *  示例 4: 
 * 
 *  输入: "([)]"
 * 输出: false
 *  
 * 
 *  示例 5: 
 * 
 *  输入: "{[]}"
 * 输出: true 
 *  Related Topics 栈 字符串 
 *  👍 2102 👎 0
 * 
 * @Author: vito
 * @Date: 2021/1/21 上午11:52
 * @Version: 1.0
 */
public class ValidBracketSolution {

    public static void main(String[] args) {
        ValidBracketSolution solution = new ValidBracketSolution();
        testOne(solution);

    }

    /**
     * 示例的测试用例
     * @param solution      对象
     */
    public static void testOne(ValidBracketSolution solution) {
        String bracket = "()";
        System.out.println("示例1: ");
        System.out.println("输入字符串为: " + bracket);
        System.out.println("测试的结果为: " + solution.isValid(bracket));
        System.out.println("期望的结果为: true");

        System.out.println("示例2: ");
        bracket = "()[]{}";
        System.out.println("输入字符串为: " + bracket);
        System.out.println("测试的结果为: " + solution.isValid(bracket));
        System.out.println("期望的结果为: true");

        System.out.println("示例3: ");
        bracket = "(]";
        System.out.println("输入字符串为: " + bracket);
        System.out.println("测试的结果为: " + solution.isValid(bracket));
        System.out.println("期望的结果为: false");

        System.out.println("示例4: ");
        bracket = "([)]";
        System.out.println("输入字符串为: " + bracket);
        System.out.println("测试的结果为: " + solution.isValid(bracket));
        System.out.println("期望的结果为: false");

        System.out.println("示例5: ");
        bracket = "{[]}";
        System.out.println("输入字符串为: " + bracket);
        System.out.println("测试的结果为: " + solution.isValid(bracket));
        System.out.println("期望的结果为: true");
    }

    /**
     * 实现括号配对
     *
     * @param s     括号的字符串
     * @return
     *  是否成功配对
     */
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (getAnotherChar(stack.peek()) == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public char getAnotherChar(char c) {
        switch (c){
            case '(':return ')';
            case '{':return '}';
            case '[':return ']';
            default:return 0;
        }
    }
}
