package com.vitoboy.leetcode.tags.stack;

import java.util.Arrays;

/**
 * 
 * 三合一。描述如何只用一个数组来实现三个栈。 
 * 
 *  你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
 * tackNum表示栈下标，value表示压入的值。 
 * 
 *  构造函数会传入一个stackSize参数，代表每个栈的大小。 
 * 
 *  示例1:
 *   输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 *  
 * 
 *  示例2:
 *   输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 *  
 *  Related Topics 栈 设计 数组 
 *  👍 35 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/12
 */
public class IInteview_03_01I_TripleInOne {
    public static void main(String[] args) {
        
    }
}

class TripleInOne {
    int[] stack;
    int size;
    int[] top;

    public TripleInOne(int stackSize) {
        size = stackSize;
        stack = new int[size*3];
        top = new int[3];
        Arrays.fill(stack, -1);
    }

    public void push(int stackNum, int value) {
        int begin = stackNum*size, end = (stackNum+1)*size;
        for (int i = begin; i < end; i++) {
            if (stack[i] < 0) {
                stack[i] = value;
                top[stackNum] = value;
                break;
            }
        }
    }

    public int pop(int stackNum) {
        int begin = stackNum*size, end = (stackNum+1)*size;
        for (int i = end-1; i >= begin; i--) {
            if (stack[i] != -1) {
                stack[i] =-1;
                if (i > begin) {
                    int out = top[stackNum];
                    top[stackNum] = stack[i-1];
                    return out;
                } else {
                    int out = top[stackNum];
                    top[stackNum] = -1;
                    return out;
                }
            }
        }
        return -1;
    }

    public int peek(int stackNum) {
        return top[stackNum];
    }

    public boolean isEmpty(int stackNum) {
        return stack[stackNum*size] == 0;
    }
}

/**
 * Your TripleInOne object will be instantiated and called as such:
 * TripleInOne obj = new TripleInOne(stackSize);
 * obj.push(stackNum,value);
 * int param_2 = obj.pop(stackNum);
 * int param_3 = obj.peek(stackNum);
 * boolean param_4 = obj.isEmpty(stackNum);
 */
