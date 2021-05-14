package com.vitoboy.leetcode.daily;


import java.util.List;

/**
 * 
 *给你单链表的头节点 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
 *表节点，返回 反转后的链表 。
 * 
 *
 * 示例 1： 
 *
 * 
 *输入：head = [1,2,3,4,5], left = 2, right = 4
 *输出：[1,4,3,2,5]
 * 
 *
 * 示例 2： 
 *
 * 
 *输入：head = [5], left = 1, right = 1
 *输出：[5]
 * 
 *
 * 
 *
 * 提示： 
 *
 * 
 * 链表中节点数目为 n 
 * 1 <= n <= 500 
 * -500 <= Node.val <= 500 
 * 1 <= left <= right <= n 
 * 
 *
 * 
 *
 * 进阶： 你可以使用一趟扫描完成反转吗？ 
 * Related Topics 链表 
 * 👍 783 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/3/18 下午4:21
 * @Version: 1.0
 */
public class I92IReverseBetween {
    interface ReverseBetweenInterface {
        ListNode reverseBetween(ListNode head, int left, int right);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode createListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode curNode = null;
        for (int i : array) {
            ListNode node = new ListNode(i);
            if (curNode == null) {
                curNode = node;
                head = node;
            } else {
                curNode.next = node;
                curNode = node;
            }
        }
        return head;
    }

    public static void printListNode(ListNode node) {
        if (node == null) {
            System.out.println("node : []");
            return;
        }
        StringBuilder builder = new StringBuilder("node: [" + node.val + ",");
        while (node.next != null) {
            node = node.next;
            builder.append(node.val + ",");
        }
        builder.substring(0, builder.length()-1);
        builder.append("]");
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        ReverseBetweenInterface reverseBetween = new ReverseBetween();
        int[] array = new int[]{3, 4, 5, 6, 7};
        ListNode listNode = createListNode(array);
        ListNode node = reverseBetween.reverseBetween(listNode, 3, 4);
        printListNode(node);

    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36 MB,击败了68.91% 的Java用户
     *
     */
    static class ReverseBetween implements ReverseBetweenInterface{

        @Override
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            ListNode pre = dummy;

            for (int i = 0; i < left - 1; i++) {
                pre = pre.next;
            }

            ListNode rightNode = pre.next;
            for (int i = 0; i < right - left + 1; i++) {
                rightNode = rightNode.next;
            }

            ListNode leftNode = pre.next;
            ListNode succ = rightNode.next;

            pre.next = null;
            rightNode.next = null;

            reverseListNode(leftNode);

            pre.next = rightNode;
            leftNode.next = succ;
            return head;
        }

        public void reverseListNode(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;


            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
        }
    }


}
