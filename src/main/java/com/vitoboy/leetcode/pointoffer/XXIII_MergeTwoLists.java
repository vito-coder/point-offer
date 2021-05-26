package com.vitoboy.leetcode.pointoffer;

/**
 * @Author: vito
 * @Date: 2020/6/29 22:59
 * @Version: 1.0
 *
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 */
public class XXIII_MergeTwoLists {
    public static void main(String[] args) {
        XXIII_MergeTwoLists mergeTwoLists = new XXIII_MergeTwoLists();

        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node1= new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node1.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode merge = mergeTwoLists.mergeTwoLists(node, node1);
        while (merge != null){
            System.out.println(merge.val);
            merge = merge.next;
        }

    }

    /**
     * 合并链表
     *
     * @param l1    链表1
     * @param l2    链表2
     * @return
     *  合并后的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 链表l1 为null, 返回l2
        if (l1 == null) return l2;
        // 链表l2 为null, 返回l1
        if (l2 == null) return l1;
        // 取最小的链表作表头
        ListNode merge = l1.val <= l2.val ? l1 : l2;
        // 定义cur 指向最小表头
        ListNode cur = merge;
        // 非最小表, 作合并的辅助链表
        ListNode big = l1.val > l2.val ? l1 : l2;
        // 如果 cur 的下一节点 不为null
        while (cur.next != null) {
            // 如果 辅助链表已经比较完, 直接返回
            if (big == null) return merge;
            // 变量 temp 暂存 cur的下一节点
            ListNode temp = cur.next;
            if (temp.val > big.val) {
                // 将值小的节点, 放到cur链表的下个节点, 辅助链表big指向下一节点, cur->next->next 指向暂存的临时节点temp;
                cur.next = big;
                big = big.next;
                cur.next.next = temp;
            }
            // cur链表指向下个节点
            cur = cur.next;
        }
        // 辅助链表big 不为空, 直接接到cur链表尾部
        if (big != null) cur.next = big;
        // 返回头节点
        return merge;
    }
}
