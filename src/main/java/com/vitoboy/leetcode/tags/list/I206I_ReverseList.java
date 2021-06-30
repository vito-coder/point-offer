package com.vitoboy.leetcode.tags.list;

import com.vitoboy.leetcode.pointoffer.ListNode;

/**
 * 
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 
 *  示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *  
 * 
 *  示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *  
 * 
 *  示例 3：
 * 输入：head = []
 * 输出：[]
 *
 *  提示：
 *  链表中节点的数目范围是 [0, 5000] 
 *  -5000 <= Node.val <= 5000 
 *
 *  进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
 *
 *  Related Topics 递归 链表 
 *  👍 1807 👎 0
 *
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/25
 */
public class I206I_ReverseList {
    public static void main(String[] args) {
        I206I_ReverseList reverseList = new I206I_ReverseList();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode list = reverseList.reverseListII(node);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }

    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:38.6 MB,击败了5.04% 的Java用户
     * 
     * 时间复杂度: O(n) 需要遍历所有节点
     * 空间复杂度: O(n) 需要n深度的栈
     */
    ListNode listNode;

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode();
        listNode = new ListNode();
        turn(head, pre);
        return listNode.next;
    }

    private void turn(ListNode node, ListNode cur) {
        if (node.next == null) {
            listNode.next = node;
            cur.next = node;
        } else {
            turn(node.next, cur);
            ListNode next = cur.next;
            next.next = node;
            cur.next = node;
            node.next = null;
        }
    }


    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseListII(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode tail = head, cur = head.next;
        if (cur.next != null) {
            head = cur.next;
        }
        tail.next = null;
        while (head != null) {
            cur.next = tail;
            tail = cur;
            cur = head;
            head = head.next;
        }
        cur.next = tail;
        return cur;
    }
}
