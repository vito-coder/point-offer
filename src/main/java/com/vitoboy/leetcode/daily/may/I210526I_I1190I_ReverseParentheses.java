package com.vitoboy.leetcode.daily.may;


import java.util.Stack;

/**
 * 
 * 给出一个字符串 s（仅含有小写英文字母和括号）。 
 * 
 *  请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
 * 
 *  注意，您的结果中 不应 包含任何括号。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入：s = "(abcd)"
 * 输出："dcba"
 *  
 * 
 *  示例 2： 
 * 
 *  输入：s = "(u(love)i)"
 * 输出："iloveu"
 *  
 * 
 *  示例 3： 
 * 
 *  输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *  
 * 
 *  示例 4： 
 * 
 *  输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  0 <= s.length <= 2000 
 *  s 中只有小写英文字母和括号 
 *  我们确保所有括号都是成对出现的 
 *  
 *  Related Topics 栈 
 *  👍 87 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/26
 */
public class I210526I_I1190I_ReverseParentheses {
    public static void main(String[] args) {
        I210526I_I1190I_ReverseParentheses reverseParentheses = new I210526I_I1190I_ReverseParentheses();
        String s = "(abcd)";
        System.out.println("result is : " + reverseParentheses.reverseParentheses(s));
        System.out.println("expect is : dcba");
        s = "(u(love)i)";
        System.out.println("result is : " + reverseParentheses.reverseParentheses(s));
        System.out.println("expect is : iloveu");
        s = "(ed(et(oc))el)";
        System.out.println("result is : " + reverseParentheses.reverseParentheses(s));
        System.out.println("expect is : leetcode");
        s = "a(bcdefghijkl(mno)p)q";
        System.out.println("result is : " + reverseParentheses.reverseParentheses(s));
        System.out.println("expect is : apmnolkjihgfedcbq");
    }


    /**
     *
     *  输入：s = "a(bcdefghijkl(mno)p)q"
     *  输出："apmnolkjihgfedcbq"
     *
     *  1. 括号里的东西需要反转
     *  2. 单数层深度括号需要反转, 双数层深度不需要反转
     *  3. 反向计算
     *
     *     作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/fan-zhuan-mei-dui-gua-hao-jian-de-zi-chu-gwpv/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *  			解答成功:
     * 				执行耗时:1 ms,击败了98.96% 的Java用户
     * 				内存消耗:36.6 MB,击败了81.35% 的Java用户
     *
     * @param s
     * @return
     */
    public String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (c == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
