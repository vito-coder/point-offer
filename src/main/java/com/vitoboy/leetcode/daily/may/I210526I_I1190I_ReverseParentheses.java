package com.vitoboy.leetcode.daily.may;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
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
     * @param s
     * @return
     */
    public String reverseParentheses(String s) {

        return null;
    }
}
