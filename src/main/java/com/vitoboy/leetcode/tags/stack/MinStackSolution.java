package com.vitoboy.leetcode.tags.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
 * 
 *  
 *  push(x) —— 将元素 x 推入栈中。 
 *  pop() —— 删除栈顶的元素。 
 *  top() —— 获取栈顶元素。 
 *  getMin() —— 检索栈中的最小元素。 
 *  
 * 
 *  
 * 
 *  示例: 
 * 
 *  输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  pop、top 和 getMin 操作总是在 非空栈 上调用。 
 *  
 *  Related Topics 栈 设计 
 *  👍 770 👎 0
 * @Author: vito
 * @Date: 2021/1/21 上午10:48
 * @Version: 1.0
 */
public class MinStackSolution {

    private interface MinStackInterface {
        void push(int x);
        void pop();
        int top();
        int getMin();
    }

    public static void main(String[] args) {
        testTwo(new MinStack());
        testTwo(new MinStackUp());
    }

    public static void testOne(MinStackInterface minStack){
        System.out.println("[\"MinStack\",\"push\",\"push\",\"push\",\"getMin\",\"pop\",\"top\",\"getMin\"]");
        System.out.println("[[],[-2],[0],[-3],[],[],[],[]]");
        System.out.print("[null,");
        minStack.push(-2);
        System.out.print("null,");
        minStack.push(0);
        System.out.print("null,");
        minStack.push(-3);
        System.out.print("null,");
        System.out.print("" + minStack.getMin() + ",");
        minStack.pop();
        System.out.print("null,");
        System.out.print("" + minStack.top() + ",");
        System.out.print("" + minStack.getMin() + "]");
    }

    public static void testTwo(MinStackInterface minStack) {
        System.out.println("[\"MinStack\",\"push\",\"push\",\"push\",\"push\",\"getMin\",\"pop\",\"getMin\",\"pop\",\"getMin\",\"pop\",\"getMin\"]\n" +
                "[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]");
        System.out.print("测试结果:[null,");
        minStack.push(2);
        System.out.print("null,");
        minStack.push(0);
        System.out.print("null,");
        minStack.push(3);
        System.out.print("null,");
        minStack.push(0);
        System.out.print("null,");
        System.out.print("" + minStack.getMin() + ",");
        minStack.pop();
        System.out.print("null,");
        System.out.print("" + minStack.getMin() + ",");
        minStack.pop();
        System.out.print("null,");
        System.out.print("" + minStack.getMin() + ",");
        minStack.pop();
        System.out.print("null,");
        System.out.print("" + minStack.getMin() + "]\n");
        System.out.println("\n期望结果:[null,null,null,null,null,0,null,0,null,0,null,2]");

    }

    private static class MinStack implements MinStackInterface{

        private LinkedList<Integer> queue = null;
        private Integer min = null;

        /** initialize your data structure here. */
        public MinStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            if(min == null) {
                min = x;
            } else if (x < min) {
                min = x;
            }
        }

        public void pop() {
            if (queue == null || queue.isEmpty()) {
                return;
            }
            Integer integer = queue.removeLast();
            if (integer <= min && !queue.isEmpty()) {
                Integer tem = null;
                for (Integer item : queue) {
                    if (tem == null || tem > item) {
                        tem = item;
                    }
                }
                min = tem;
            } else if (queue.isEmpty()) {
                min = null;
            }
        }

        public int top() {
            return queue.getLast();
        }

        public int getMin() {
            return min;
        }
    }

    private static class MinStackUp implements MinStackInterface {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        @Override
        public void push(int x) {
            if (stack.isEmpty() || x < getMin()) {
                minStack.push(x);
            } else if (x >= getMin()) {
                minStack.push(getMin());
            }
            stack.push(x);
        }

        @Override
        public void pop() {
            stack.pop();
            minStack.pop();
        }

        @Override
        public int top() {
            return stack.peek();
        }

        @Override
        public int getMin() {
            return minStack.peek();
        }
    }
}
