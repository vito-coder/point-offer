package com.vitoboy.leetcode.tags.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 使用队列实现栈的下列操作： 
 * 
 *  
 *  push(x) -- 元素 x 入栈 
 *  pop() -- 移除栈顶元素 
 *  top() -- 获取栈顶元素 
 *  empty() -- 返回栈是否为空 
 *  
 * 
 *  注意: 
 * 
 *  
 *  你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
 * 法的。 
 *  你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
 *  你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
 *  
 *  Related Topics 栈 设计 
 *  👍 263 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/1/21 下午1:56
 * @Version: 1.0
 */
public class MyStackSolution {
    private interface MyStackInterface {

        /** Push element x onto stack. */
        public void push(int x);

        /** Removes the element on top of the stack and returns that element. */
        public int pop() ;

        /** Get the top element. */
        public int top();
        
        /** Returns whether the stack is empty. */
        public boolean empty();
    }

    public static void main(String[] args) {
        MyStack solution = new MyStack();
//        testOne(solution);
        testTwo(solution);
    }

    public static void testOne(MyStackInterface myStack) {
        System.out.println("测试用例:\n[\"MyStack\",\"push\",\"push\",\"top\",\"pop\",\"empty\"]\n" +
                "[[],[1],[2],[],[],[]]\n");
        System.out.print("测试结果:[null,");
        myStack.push(1);
        System.out.print("null,");
        myStack.push(2);
        System.out.print("null,");
        System.out.print(myStack.top() + ",");
        System.out.print(myStack.pop() + ",");
        System.out.print(myStack.empty() + "]\n");
        System.out.println("期望结果:[null,null,null,2,2,false]");
    }

    public static void testTwo(MyStackInterface mystack) {
        System.out.println("测试用例:[\"MyStack\",\"push\",\"pop\",\"empty\"]\n" +
                "[[],[1],[],[]]");

        System.out.print("测试结果:[null,");
        mystack.push(1);
        System.out.print("null,");
        System.out.print(mystack.pop() + ",");
        System.out.print(mystack.empty() + "]\n");
        System.out.println("期望结果:[null,null,1,true]");
    }


    /**
     * 解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.1 MB,击败了72.60% 的Java用户
     *
     * 用队列实现栈(vito)
     */
    static class MyStack implements MyStackInterface{
        private Queue<Integer> queue = null;
        private Queue<Integer> tempQueue = null;
        private Integer top = null;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
            tempQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while (queue.size() > 1) {
                if (tempQueue == null) {
                    tempQueue = new LinkedList<>();
                }
                if (queue.size() == 2) {
                    top = queue.peek();
                }
                tempQueue.add(queue.poll());
            }
            if (queue.isEmpty()) return -1;
            else {
                int out = queue.peek();
                queue = tempQueue;
                tempQueue = new LinkedList<>();
                return out;
            }
        }

        /** Get the top element. */
        public int top() {
            if (top == null) return -1;
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
    
}
