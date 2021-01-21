package com.vitoboy.leetcode.tags.stack;

import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）： 
 * 
 *  实现 MyQueue 类： 
 * 
 *  
 *  void push(int x) 将元素 x 推到队列的末尾 
 *  int pop() 从队列的开头移除并返回元素 
 *  int peek() 返回队列开头的元素 
 *  boolean empty() 如果队列为空，返回 true ；否则，返回 false 
 *  
 * 
 *  
 * 
 *  说明： 
 * 
 *  
 *  你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *  
 *  你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
 *  
 * 
 *  
 * 
 *  进阶： 
 * 
 *  
 *  你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。 
 *  
 * 
 *  
 * 
 *  示例： 
 * 
 *  
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * 
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *  
 * 
 *  
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= x <= 9 
 *  最多调用 100 次 push、pop、peek 和 empty 
 *  假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作） 
 *  
 *  Related Topics 栈 设计 
 *  👍 267 👎 0
 * 
 * @Author: vito
 * @Date: 2021/1/21 下午4:29
 * @Version: 1.0
 */
public class MyQueueSolution {

    interface MyQueueInterface {
        /** Push element x to the back of queue. */
        public void push(int x) ;

        /** Removes the element from in front of queue and returns that element. */
        public int pop() ;

        /** Get the front element. */
        public int peek() ;

        /** Returns whether the queue is empty. */
        public boolean empty() ;
    }


    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        testOne(queue);
    }

    public static void testOne(MyQueueInterface myqueue) {
        System.out.println("测试用例:[\"MyQueue\", \"push\", \"push\", \"peek\", \"pop\", \"empty\"]\n" +
                "[[], [1], [2], [], [], []]");

        System.out.print("测试结果:[null,");
        myqueue.push(1);
        System.out.print("null,");
        myqueue.push(2);
        System.out.print("null,");
        System.out.print(myqueue.peek() + ",");
        System.out.print(myqueue.pop() + ",");
        System.out.print(myqueue.empty() + "]\n");
        System.out.println("期望结果:[null,null,null,1,1,false]");
    }


    /**
     * 解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36 MB,击败了94.01% 的Java用户
     *
     * 队列实现(vito)
     */
    static class MyQueue implements MyQueueInterface{

        private Stack<Integer> stack = null;
        private Stack<Integer> tempStack = null;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack = new Stack<>();
            tempStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                if (tempStack.isEmpty()) {
                    tempStack.push(x);
                } else {
                    while (!tempStack.isEmpty()) {
                        stack.push(tempStack.pop());
                    }
                    tempStack.push(x);
                    while (stack.size() > 1) {
                        tempStack.push(stack.pop());
                    }
                }
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (!stack.isEmpty()) {
                int head = stack.pop();
                if (!tempStack.isEmpty()) {
                    stack.push(tempStack.pop());
                }
                return head;
            }
            return stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty() && tempStack.isEmpty();
        }
    }

}
