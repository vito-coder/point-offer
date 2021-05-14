package com.vitoboy.leetcode.tags.stack;

import java.util.Stack;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。 
 * 
 *  在 S 上反复执行重复项删除操作，直到无法继续删除。 
 * 
 *  在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。 
 * 
 *  
 * 
 *  示例： 
 * 
 *  输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又
 * 只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= S.length <= 20000 
 *  S 仅由小写英文字母组成。 
 *  
 *  Related Topics 栈 
 *  👍 116 👎 0
 * 
 * @Author: vito
 * @Date: 2021/1/29 下午3:53
 * @Version: 1.0
 */
public class RemoveDuplicatesSolution {
    public static void main(String[] args) {
        RemoveDuplicatesSolution solution = new RemoveDuplicatesSolution();
        String s = "abbaca";
        System.out.println("result : " + solution.removeDuplicatesIII(s));
        System.out.println("expect : ca");
    }


    /**
     * <p>解答成功:
     * <p>执行耗时:4 ms,击败了99.47% 的Java用户
     * <p>内存消耗:39.3 MB,击败了25.62% 的Java用户
     * @param S
     * @return
     */
    public String removeDuplicatesIII(String S) {
        int index = 0;
        char[] chars = S.toCharArray();
        for (char c : chars) {
            if (index > 0 && chars[index-1] == c) {
                index--;
            } else {
                chars[index++] = c;
            }
        }
        return new String(chars, 0, index);
    }


    /**
     * <p>解答成功:
     * <p>执行耗时:9 ms,击败了93.16% 的Java用户
     * <p>内存消耗:38.8 MB,击败了93.11% 的Java用户
     * @param S
     * @return
     */
    public String removeDuplicatesII(String S) {
        if (S == null || S.length() <= 1) {
            return S;
        }
        int len = S.length();
        char[] chars = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (index >= 1 && chars[index-1] == S.charAt(i)) {
                index--;
            } else {
                chars[index++] = S.charAt(i);
            }
        }
        return new String(chars, 0, index);

    }

    /**
     *
     * 				解答成功:
     * 				执行耗时:73 ms,击败了14.99% 的Java用户
     * 				内存消耗:39 MB,击败了61.08% 的Java用户
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        if (S.length() == 1) {
            return S;
        }
        Stack<Character> stack = new Stack<>();
        int len = S.length();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(S.charAt(i));
            } else if (S.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
