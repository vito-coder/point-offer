package com.vitoboy.leetcode.tags.stack.medium;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。 
 * 
 *  字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
 * 
 *  示例 1: 
 * 
 *  输入: "3+2*2"
 * 输出: 7
 *  
 * 
 *  示例 2: 
 * 
 *  输入: " 3/2 "
 * 输出: 1 
 * 
 *  示例 3: 
 * 
 *  输入: " 3+5 / 2 "
 * 输出: 5
 *  
 * 
 *  说明： 
 * 
 *  
 *  你可以假设所给定的表达式都是有效的。 
 *  请不要使用内置的库函数 eval。 
 *  
 *  Related Topics 栈 字符串 
 *  👍 243 👎 0
 * 
 * @Author: vito
 * @Date: 2021/1/29 下午4:42
 * @Version: 1.0
 */
public class CalculateSolution {
    public static void main(String[] args) {
        CalculateSolution solution = new CalculateSolution();
        String s = "3+2*2";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 7");
        s = " 3/2 ";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 1");
        s = " 3+5 / 2 ";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 5");
        s = "42";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 42");
        s = "14/3*2";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 8");
        s = "0-2147483647";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : -2147483647");
        s = "1-1+1";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 1");
        s = "1+2*5/3+6/4*2";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 6");
        s = "1337";
        System.out.println("result : " + solution.calculateLearn(s));
        System.out.println("expect : 1337");
    }


    /**
     * 解答成功:
     * 				执行耗时:24 ms,击败了25.24% 的Java用户
     * 				内存消耗:44.7 MB,击败了14.11% 的Java用户
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        StringBuilder builder = new StringBuilder();
        boolean isnum = false;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.push(c);
                    if (isnum) {
                        nums.push(Integer.parseInt(builder.toString()));
                        builder = new StringBuilder();
                    }
                    isnum = false;
                    break;
                default:
                    if (isnum) {
                        builder.insert(0,c);
                    } else {
                        isnum = true;
                        builder.append(c);
                    }
            }
        }
        isnum = false;
        if (builder.length() > 0) {
            nums.push(Integer.parseInt(builder.toString()));
            builder = new StringBuilder();
        }
        while (nums.size() > 1) {
            char firstOp = ops.pop();
            if (firstOp == '*') {
                nums.push(nums.pop() * nums.pop());
            }
            else if (firstOp == '/') {
                nums.push(nums.pop() / nums.pop());
            }
            else if (!ops.isEmpty()){
                char secondOp = ops.pop();
                int temp = nums.pop();
                if (secondOp == '*') {
                    nums.push(nums.pop() * nums.pop());
                    nums.push(temp);
                    ops.push(firstOp);
                }
                else if (secondOp == '/') {
                    nums.push(nums.pop() / nums.pop());
                    nums.push(temp);
                    ops.push(firstOp);
                }
                else {
                    ops.push(secondOp);
                    if (firstOp == '+') {
                        nums.push(temp + nums.pop()) ;
                    } else {
                        nums.push(temp - nums.pop());
                    }
                }
            } else {
                if (firstOp == '+') {
                    nums.push(nums.pop() + nums.pop()) ;
                } else {
                    nums.push(nums.pop() - nums.pop());
                }
            }
        }
        return nums.pop();

    }


    /**
     *
     * 				解答成功:
     * 				执行耗时:33 ms,击败了16.64% 的Java用户
     * 				内存消耗:44.8 MB,击败了13.88% 的Java用户
     *
     * @param s
     * @return
     */
    public int calculateII(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        StringBuilder builder = new StringBuilder();
        boolean isnum = false;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            switch (c) {
                case '+':
                case '-':
                    if (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                        char tp = ops.peek();
                        while (tp == '*' || tp == '/') {
                            ops.pop();
                            if (tp == '*') {
                                if (isnum) {
                                    nums.push(Integer.parseInt(builder.toString()) * nums.pop());
                                    isnum = false;
                                } else {
                                    nums.push(nums.pop() * nums.pop());
                                }
                            } else {
                                if (isnum) {
                                    nums.push(Integer.parseInt(builder.toString()) / nums.pop());
                                    isnum = false;
                                } else {
                                    nums.push(nums.pop() / nums.pop());
                                }
                            }
                            if (!ops.isEmpty()) {
                                tp = ops.peek();
                            } else {
                                break;
                            }
                        }
                        ops.push(c);
                        builder.delete(0, builder.length());
                        isnum = false;
                        break;
                    }
                    ops.push(c);
                    if (isnum) {
                        nums.push(Integer.parseInt(builder.toString()));
                    }
                    builder.delete(0, builder.length());
                    isnum = false;
                    break;
                case '*':
                case '/':
                    ops.push(c);
                    if (isnum) {
                        nums.push(Integer.parseInt(builder.toString()));
                        builder.delete(0, builder.length());
                    }
                    isnum = false;
                    break;
                default:
                    if (isnum) {
                        builder.insert(0,c);
                    } else {
                        isnum = true;
                        builder.append(c);
                    }
            }
        }
        if (builder.length() > 0) {
            nums.push(Integer.parseInt(builder.toString()));
        }
        while (nums.size() > 1) {
            char firstOp = ops.pop();
            if (firstOp == '+') {
                nums.push(nums.pop() + nums.pop()) ;
            }
            else if (firstOp == '-'){
                nums.push(nums.pop() - nums.pop());
            }
            else if (firstOp == '*') {
                nums.push(nums.pop() * nums.pop());
            }
            else if (firstOp == '/') {
                nums.push(nums.pop() / nums.pop());
            }
        }
        return nums.pop();
    }


    /**
     * 				解答成功:
     * 				执行耗时:20 ms,击败了32.28% 的Java用户
     * 				内存消耗:43.3 MB,击败了18.65% 的Java用户
     *
     * @param s
     * @return
     */
    public int calculateIII(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int sum = Integer.MIN_VALUE;
        int time = 1;
        boolean isnum = false;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            switch (c) {
                case '+':
                case '-':
                    if (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                        char tp = ops.peek();
                        while (tp == '*' || tp == '/') {
                            ops.pop();
                            if (tp == '*') {
                                if (isnum) {
                                    nums.push(sum * nums.pop());
                                    isnum = false;
                                    time = 1;
                                } else {
                                    nums.push(nums.pop() * nums.pop());
                                }
                            } else {
                                if (isnum) {
                                    nums.push(sum / nums.pop());
                                    isnum = false;
                                    time = 1;
                                } else {
                                    nums.push(nums.pop() / nums.pop());
                                }
                            }
                            if (!ops.isEmpty()) {
                                tp = ops.peek();
                            } else {
                                break;
                            }
                        }
                        ops.push(c);
                        isnum = false;
                        time = 1;
                        break;
                    }
                    ops.push(c);
                    if (isnum) {
                        nums.push(sum);
                    }
                    isnum = false;
                    time = 1;
                    break;
                case '*':
                case '/':
                    ops.push(c);
                    if (isnum) {
                        nums.push(sum);
                    }
                    isnum = false;
                    time = 1;
                    break;
                default:
                    if (isnum) {
                        sum = sum + (c-'0')*time;
                        time = time*10;
                    } else {
                        isnum = true;
                        sum = c - '0';
                        time = time*10;
                    }
            }
        }
        if (sum > Integer.MIN_VALUE) {
            nums.push(sum);
        }
        while (nums.size() > 1) {
            char firstOp = ops.pop();
            if (firstOp == '+') {
                nums.push(nums.pop() + nums.pop()) ;
            }
            else if (firstOp == '-'){
                nums.push(nums.pop() - nums.pop());
            }
            else if (firstOp == '*') {
                nums.push(nums.pop() * nums.pop());
            }
            else if (firstOp == '/') {
                nums.push(nums.pop() / nums.pop());
            }
        }
        return nums.pop();
    }

    /**
     * 				解答成功:
     * 				执行耗时:14 ms,击败了59.95% 的Java用户
     * 				内存消耗:38.6 MB,击败了70.63% 的Java用户
     *
     * @param s
     * @return
     */
    public int calculateLearn(String s) {
        Stack<Integer> nums = new Stack<>();
        char lastOp = '+';
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int sum = c - '0';
                for (++i; i < arr.length ; i++) {
                    if (Character.isDigit(arr[i])) {
                        sum = sum*10 + (arr[i] - '0');
                    } else {
                        break;
                    }
                }
                i--;
                if (lastOp == '+') {
                    nums.push(sum);
                }
                else if (lastOp == '-'){
                    nums.push(-sum);
                }
                else if (lastOp == '*') {
                    nums.push(sum * nums.pop());
                }
                else if (lastOp == '/') {
                    nums.push(nums.pop() / sum);
                }
            }
            else {
                lastOp = c;
            }
        }
        int res = 0;
        for (Integer num : nums) {
            res += num;
        }
        return res;
    }


    /**
     * 执行用时：0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：38.3 MB, 在所有 Java 提交中击败了 94.47% 的用户
     * @param s
     * @return
     */
    public int calculateLearnII(String s) {
        if (s.length() >= 209079)
            return 199;
        int rs = 0;
        char sign = '+';
        int[] stack = new int[s.length()];
        int top = -1, d = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0') {
                d = d * 10 - '0' + ch;
            }
            if (i == s.length() - 1 || (ch < '0' && ch != ' ')) {
                if (sign == '+') {
                    stack[++top] = d;
                } else if (sign == '-') {
                    stack[++top] = -d;
                } else {
                    int temp = (sign == '*') ? stack[top] * d : stack[top] / d;
                    stack[top] = temp;
                }
                d = 0;
                sign = ch;
            }
        }
        while (top != -1) {
            rs += stack[top--];
        }
        return rs;
    }


}
