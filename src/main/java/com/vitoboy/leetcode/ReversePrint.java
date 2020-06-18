package com.vitoboy.leetcode;

import java.util.Arrays;

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
public class ReversePrint {

    public static void main(String[] args) {

    }

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
}


