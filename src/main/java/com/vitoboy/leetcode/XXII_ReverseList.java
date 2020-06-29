package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/29 17:44
 * @Version: 1.0
 *
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 */
public class XXII_ReverseList {
    public static void main(String[] args) {
        XXII_ReverseList reverseList = new XXII_ReverseList();

        System.out.println(reverseList.reverseList(null));

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

        ListNode listNode = reverseList.reverseListRecursive(node);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 头节点为null 或 头节点的下一个节点为null, 直接返回头节点
        if (head == null || head.next == null) return head;
        // 定义新链表, 并指向null
        ListNode newList = null;
        // 遍历老链表
        while (head != null) {
            // next 存放 当前(老)节点的下一节点
            ListNode next = head.next;
            // temp 存放 当前节点
            ListNode temp = head;
            // 当前节点的下一节点 指向 新节点 -- 脱离老链表, 并加入新链表
            temp.next = newList;
            // 新链表的头指针 指向 刚脱离老链表的节点
            newList = temp;
            // 当前节点 存放 下一节点
            head = next;
        }
        // 返回新链表
        return newList;
    }


    /**
     * 使用递归实现
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null ) return head;
        ListNode res = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
