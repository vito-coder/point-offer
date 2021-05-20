package com.vitoboy.interview;

import java.util.Stack;

/**
 * 
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * Related Topics 栈 👍 47 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/5/20 上午11:38
 * @Version: 1.0
 */
public class I0302I_MinStack {

    /**
     * 执行用时：22 ms , 在所有 Java 提交中击败了 91.61% 的用户
     * 内存消耗：39.9 MB , 在所有 Java 提交中击败了 87.44% 的用户
     */
    class MinStack {
        Stack<Integer> stack ;
        Stack<Integer> min;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.size() > 0) {
                min.push(min.peek() > x ? x : min.peek());
            } else{
                min.push(x);
            }
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
