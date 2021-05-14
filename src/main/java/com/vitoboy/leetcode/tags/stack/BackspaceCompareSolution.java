package com.vitoboy.leetcode.tags.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
 * 
 *  注意：如果对空文本输入退格字符，文本继续为空。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *  
 * 
 *  示例 2： 
 * 
 *  输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *  
 * 
 *  示例 3： 
 * 
 *  输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *  
 * 
 *  示例 4： 
 * 
 *  输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。 
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= S.length <= 200 
 *  1 <= T.length <= 200 
 *  S 和 T 只含有小写字母以及字符 '#'。 
 *  
 * 
 *  
 * 
 *  进阶： 
 * 
 *  
 *  你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
 *  
 * 
 *  
 *  Related Topics 栈 双指针 
 *  👍 260 👎 0
 * @Author: vito
 * @Date: 2021/1/26 下午3:34
 * @Version: 1.0
 */
public class BackspaceCompareSolution {

    public static void main(String[] args) {
        BackspaceCompareSolution solution = new BackspaceCompareSolution();
        String S = "ab##", T = "c#d#";
        System.out.println(solution.backspaceCompareIII(S, T));
        S = "ab#c";
        T = "ad#c";
        System.out.println(solution.backspaceCompareIII(S, T));
        S = "a##c";
        T = "#a#c";
        System.out.println(solution.backspaceCompareIII(S, T));
        S = "a#c";
        T = "b";
        System.out.println(solution.backspaceCompareIII(S,T));
        S = "y#fo##f";
        T = "y#f#o##f";
        // 测试结果:false
        // 期望结果:true
        System.out.println(solution.backspaceCompareIII(S,T));
    }


    /**
     * 解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.3 MB,击败了97.28% 的Java用户
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompareIII(String S, String T) {
        if (S == null || T == null) {
            return false;
        }

        int sDel = 0;
        int tDel = 0;
        int indexs = S.length()-1;
        int indext = T.length()-1;
        while (indexs >= 0 || indext >= 0) {

            while (indexs >= 0) {
                if (S.charAt(indexs) == '#') {
                    indexs--;
                    sDel++;
                } else if (sDel > 0) {
                    sDel--;
                    indexs--;
                } else {
                    break;
                }
            }

            while (indext >= 0) {
                if (T.charAt(indext) == '#') {
                    indext--;
                    tDel++;
                } else if (tDel > 0) {
                    tDel--;
                    indext--;
                } else {
                    break;
                }
            }

            if (indexs >= 0 && indext >=0) {
                if (S.charAt(indexs) != T.charAt(indext)) {
                    return false;
                }
            } else {
                if (indexs >= 0 || indext >=0) {
                    return false;
                }
            }
            indexs--;
            indext--;

        }

        return true;
    }



    /**
     * 解答成功:
     * 				执行耗时:1 ms,击败了83.92% 的Java用户
     * 				内存消耗:36.7 MB,击败了26.09% 的Java用户
     */
    public boolean backspaceCompareII(String S, String T) {
        return proces(S).equals(proces(T));
    }

    public String proces(String str) {
        StringBuilder builder = new StringBuilder();
        char[] chars = str.toCharArray();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                if (index > 0) {
                    --index;
                    builder.deleteCharAt(index);
                }
                continue;
            }
            index++;
            builder.append(chars[i]);
        }
        return builder.toString();
    }


    /**
     * 方法二：双指针
     *
     * 思路及算法
     *
     * 一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
     *
     * 具体地，我们定义 skip  表示当前待删除的字符的数量。每次我们遍历到一个字符：
     *
     * 若该字符为退格符，则我们需要多删除一个普通字符，我们让 skip  加 1；
     *
     * 若该字符为普通字符：
     *
     * 若 skip  为 0，则说明当前字符不需要删去；
     *
     * 若 skip  不为 0，则说明当前字符需要删去，我们让 skip  减 1。
     *
     * 这样，我们定义两个指针，分别指向两字符串的末尾。
     * 每次我们让两指针逆序地遍历两字符串，直到两字符串能够各自确定一个字符，然后将这两个字符进行比较。
     * 重复这一过程直到找到的两个字符不相等，或遍历完字符串为止。
     *
     *
     *解答成功:
     * 				执行耗时:1 ms,击败了83.92% 的Java用户
     * 				内存消耗:36.8 MB,击败了16.95% 的Java用户
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompareI(String S, String T) {
        int slen = S.length();
        int tlen = T.length();
        int len = Math.max(S.length(), T.length());
        char[] oneChars = new char[len];
        char[] twoChars = new char[len];
        int indexs = 0, indext = 0;
        for (int i = 0; i < len; i++) {
            if (slen > i) {
                indexs = updateChar(oneChars, S.charAt(i), indexs);
            }
            if (tlen > i) {
                indext = updateChar(twoChars, T.charAt(i), indext);
            }
        }
        if (indexs != indext) {
            return false;
        }
        for (int i = 0; i < indexs; i++) {
            if (oneChars[i] != twoChars[i]) {
                return false;
            }
        }

        return true;
    }

    public int updateChar(char[] chars, char c, int index){
        if (c == '#') {
            if (index > 0) {
                chars[--index] = '0';
            } else if (index == 0) {
                chars[index] = '0';
            }
            return index;
        }
        chars[index] = c;
        return ++index;
    }


    /**
     * 比较含退格的字符串(vito)
     * 解答成功:
     * 				执行耗时:2 ms,击败了43.77% 的Java用户
     * 				内存消耗:36.9 MB,击败了11.69% 的Java用户
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<>();
        int len = Math.max(S.length(), T.length());
        for (int i = 0; i < len; i++) {
            if (S.length() > i){
                char one = S.charAt(i);
                checkChar(stackOne, one);
            }
            if (T.length() > i) {
                char two = T.charAt(i);
                checkChar(stackTwo, two);
            }
        }
        if (stackOne.size() != stackTwo.size()) {
            return false;
        }
        while (!stackOne.isEmpty()) {
            if (!stackOne.pop().equals(stackTwo.pop())) {
                return false;
            }
        }

        return true;
    }

    public void  checkChar(Stack<Character> stack, char c) {
        switch (c) {
            case '#':
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                break;
            default:
                stack.push(c);
        }
    }
}
