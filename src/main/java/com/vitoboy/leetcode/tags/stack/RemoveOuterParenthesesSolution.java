package com.vitoboy.leetcode.tags.stack;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"
 * ，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
 * 
 *  如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。 
 * 
 *  给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
 * 
 *  对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
 * 
 *  示例 2： 
 * 
 *  输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 *  
 * 
 *  示例 3： 
 * 
 *  输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  S.length <= 10000 
 *  S[i] 为 "(" 或 ")" 
 *  S 是一个有效括号字符串 
 *  
 *  Related Topics 栈 
 *  👍 151 👎 0
 * 
 * @Author: vito
 * @Date: 2021/1/29 下午1:26
 * @Version: 1.0
 */
public class RemoveOuterParenthesesSolution {
    public static void main(String[] args) {
        RemoveOuterParenthesesSolution solution = new RemoveOuterParenthesesSolution();
        String s = "(()())(())";
        System.out.println("result : " + solution.removeOuterParenthesesI(s));
        System.out.println("expect : " + "()()()");
        s = "(()())(())(()(()))";
        System.out.println("result : " + solution.removeOuterParenthesesI(s));
        System.out.println("expect : " + "()()()()(())");
        s = "()()";
        System.out.println("result : " + solution.removeOuterParenthesesI(s));
        System.out.println("expect : " + "");
    }


    /**
     * <p>删除最外层的括号I(vito)
     * 解答成功:
     * 				执行耗时:4 ms,击败了60.03% 的Java用户
     * 				内存消耗:38.5 MB,击败了52.67% 的Java用户
     *
     * @param S
     * @return
     */
    public String removeOuterParenthesesI(String S) {
        if (S == null || S.length() <= 2) {
            return "";
        }
        char[] chars = new char[S.length()];
        int index = 0;
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (count > 0) {
                    chars[index] = '(';
                    index++;
                }
                count++;
            } else if (S.charAt(i) == ')') {
                count--;
                if (count > 0) {
                    chars[index] = ')';
                    index++;
                }
            }
        }
        return new String(chars, 0, index);
    }



    /**
     * <p>删除最外层的括号(vito)
     * <p>解答成功:
     * <p>				执行耗时:5 ms,击败了53.57% 的Java用户
     * <p>				内存消耗:38.5 MB,击败了60.12% 的Java用户
     *
     *
     * 时间复杂度O(N) 只和入参的字符串长度有关
     * 空间复杂度O(1) 只需要两个变量即可
     *
     * @param S  入参
     * @return
     *  返回结果
     */
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() <= 2) {
            return "";
        }
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                if (count > 0) {
                    builder.append('(');
                }
                count++;
            } else if (S.charAt(i) == ')') {
                count--;
                if (count > 0) {
                    builder.append(')');
                }
            }
        }
        return builder.toString();

    }
}
