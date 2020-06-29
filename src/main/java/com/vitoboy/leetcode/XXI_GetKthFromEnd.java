package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/29 16:30
 * @Version: 1.0
 *
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class XXI_GetKthFromEnd {
    public static void main(String[] args) {
        XXI_GetKthFromEnd fromEnd = new XXI_GetKthFromEnd();
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4= new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println();
        ListNode find = fromEnd.getKthFromEnd(node, 3);
        while (find != null) {
            System.out.println(find.val);
            find = find.next;
        }

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 如果head 为空, 直接返回 null
        if (head == null ) return null;
        // beNode用来保存倒数的node
        ListNode beNode = head;
        // head 先保存为比 beNode 多 k 个node的ListNode
        while (head != null && k >0) {
            head = head.next;
            k--;
        }
        // 如果 head 为空, 有两种情况
        if (head == null ) {
            // k > 0, 说明ListNode的深度不足 k 个node, 直接返回 null
            if (k > 0) return null;
            // 否则, k <= 0, 但 k 不可能小于0, 所以 k == 0, ListNode的深度刚好是 k, 返回头node, 即 beNode
            return beNode;
        }
        // head 不为空, 继续往深度找, 直到为null
        // head节点 比 beNode节点 多 k-1 个节点
        // 所以, 当head节点为空时, beNode节点即为倒数第 k 个节点
        while (head != null) {
            head = head.next;
            beNode = beNode.next;
        }
        // 返回找到的倒数第 k 个节点 beNode
        return beNode;
    }
}
