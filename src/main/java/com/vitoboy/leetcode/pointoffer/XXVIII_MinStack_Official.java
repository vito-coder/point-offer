package com.vitoboy.leetcode;

import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/6/30 18:05
 * @Version: 1.0
 */
public class XXVIII_MinStack_Official {
    public static void main(String[] args) {


        MinStackOfficial minStack = new MinStackOfficial();
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


/**
 * 本题难点： 将 min() 函数复杂度降为 O(1) ，可通过建立辅助栈实现；
 * 数据栈 A ： 栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
 * 辅助栈 B ： 栈 B 中存储栈 A 中所有 非严格降序 的元素，则栈 A 中的最小元素始终对应栈 B 的栈顶元素，即 min() 函数只需返回栈 B 的栈顶元素即可。
 * 因此，只需设法维护好 栈 B 的元素，使其保持非严格降序，即可实现 min() 函数的 O(1) 复杂度。
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */
class MinStackOfficial{
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStackOfficial() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (minStack.size() == 0 || minStack.peek() >= x ) {
            minStack.add(x);
        }
    }

    public void pop(){
        Integer val = stack.pop();
        if (val.equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}


