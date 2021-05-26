package com.vitoboy.leetcode.pointoffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/6/18 22:03
 * @Version: 1.0
 *
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 *
 */
public class VI_ReversePrint {

    public static void main(String[] args) {

    }

    /**
     * 使用递归方式实现
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        if (head.next == null) {
            return new int[]{head.val};
        } else {
            int[] pint = reversePrint(head.next);
            int[] rpint = Arrays.copyOfRange(pint, 0, pint.length + 1);
            rpint[pint.length] = head.val;
            return rpint;
        }
    }


    /**
     * 使用循环方式实现
     *
     * @param head
     * @return
     */
    public static int[] reversePrintStack(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        int count = 0;
        Stack<Integer> turnList = new Stack<>();
        while (head != null) {
            turnList.push(head.val);
            count++;
            head = head.next;
        }
        int[] list = new int[count];
        for (int i = 0; i < count; i++) {
            list[i] = turnList.pop();
        }

        return list;
    }

    public static int[] reversePrintDouble100(ListNode head) {
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while(currNode != null){
            len ++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while(currNode != null){
            result[len - 1] = currNode.val;
            len --;
            currNode = currNode.next;
        }
        return result;
    }
}


