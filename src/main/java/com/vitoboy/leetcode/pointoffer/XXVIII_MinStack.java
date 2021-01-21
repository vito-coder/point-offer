package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/30 14:45
 * @Version: 1.0
 *
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 */
public class XXVIII_MinStack {

    public static void main(String[] args) {
//        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.min());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.min());

//        MinStack minStack1 = new MinStack();
//        minStack1.push(-2);
//        minStack1.push(0);
//        minStack1.push(-1);
//        System.out.println(minStack1.min());
//        System.out.println(minStack1.top());
//        minStack1.pop();
//        System.out.println(minStack1.min());
//
//        MinStack minStack = new MinStack();
//        minStack.push(1);
//        minStack.push(2);
//        System.out.println(minStack.top());
//        System.out.println(minStack.min());
//        minStack.pop();
//        System.out.println(minStack.min());
//        System.out.println(minStack.top());

        // ["MinStack","push","push","push","top","pop","min","pop","min","pop","push","top","min","push","top","min","pop","min"]
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]

        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());

    }

}

class MinStack{
    MyNode listNode;
    MyNode minList;
    MyNode head;
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (listNode == null) {
            listNode = new MyNode(x);
            minList = listNode;
            head = listNode;
        } else {
            MyNode node = new MyNode(x);
            listNode.next = node;
            node.pre = listNode;
            listNode = node;
            if (x < minList.val){
                node.max = minList;
                minList.min = node;
                minList = node;
            } else {
                if (minList.max != null) {
                    node.max = minList.max;
                    minList.max.min = node;
                    node.min = minList;
                    minList.max = node;
                } else {
                    minList.max = node;
                    node.min = minList;
                }
            }
        }
    }

    public void pop() {
        if (listNode == null) return;
        if (head == listNode) {
            head = null;
            minList = null;
            listNode = null;
            return;
        }
        MyNode pre ;
        if ((pre = listNode.pre) == null) {

            return;
        }
        pre.next = null;
        listNode.pre = null;
        if (listNode.max != null) {
            listNode.max.min = listNode.min;
            if (listNode.min != null) {
                listNode.min.max = listNode.max;
                listNode.min = null;
            } else {
                minList = minList.max;
            }
            listNode.max = null;
        } else {
            listNode.min.max = null;
            listNode.min = null;
        }
        listNode = pre;
    }

    public int top() {
        if (listNode != null && listNode.pre != null && listNode.pre.pre != null) {
            MyNode node = minList.max;
            while (node != null) {
                MyNode preMax = node.max;
                if (preMax == null) break;
                if (preMax.val < node.val) {
                    if (preMax.max != null) {
                        preMax.max.min = node;
                        node.max = preMax.max;
                    } else {
                        node.max = null;
                    }
                    preMax.min = node.min;
                    preMax.max = node;
                    node.min.max = preMax;
                    node.min = preMax;
                }
                node = node.max;
            }
            return listNode.val;
        }
        return -1;
    }

    public int min() {
        if (minList != null) return minList.val;
        return -1;
    }
}

class MyNode {
    int val;
    MyNode pre;
    MyNode next;
    MyNode min;
    MyNode max;
    public MyNode(int val) {
        this.val = val;
    }
}
