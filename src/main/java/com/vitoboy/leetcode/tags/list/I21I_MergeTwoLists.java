package com.vitoboy.leetcode.tags.list;

import com.vitoboy.leetcode.pointoffer.ListNode;

/**
 * 
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *  
 * 
 *  示例 3： 
 * 
 *  
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  两个链表的节点数目范围是 [0, 50] 
 *  -100 <= Node.val <= 100 
 *  l1 和 l2 均按 非递减顺序 排列 
 *  
 *  Related Topics 递归 链表 
 *  👍 1727 👎 0
 *
 *
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/5/27
 */
public class I21I_MergeTwoLists {
    public static void main(String[] args) {

    }


    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了26.17% 的Java用户
     * 				内存消耗:37.9 MB,击败了41.35% 的Java用户
     *
     * 时间复杂度: O(N+M)    与两个链表长度有关
     * 空间复杂度: O(1)      只用到固定的变量
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode first = l1.val > l2.val ? l2 : l1;
        ListNode second = l1.val > l2.val ? l1 : l2;
        ListNode pre = first;
        ListNode cur = first.next;
        while (cur != null) {
            if (cur.val > second.val) {
                pre.next = second;
                second = cur;
                pre = pre.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = pre.next;
            }
        }

        if (second != null) {
            pre.next = second;
        }
        return first;
    }

    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:37.9 MB,击败了45.38% 的Java用户
     *
     * 时间复杂度: O(n+m)        与两条链表的长度有关
     * 空间复杂度: O(n+m)        使用了递归栈的空间
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val > l2.val) {
            l2.next = mergeTwoListsRecursion(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoListsRecursion(l1.next, l2);
            return l1;
        }
    }
}
