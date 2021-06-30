package com.vitoboy.leetcode.tags.list;

import com.vitoboy.leetcode.pointoffer.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。 
 * 
 *  示例 1:
 *  输入: 1->2
 * 输出: false 
 * 
 *  示例 2:
 *  输入: 1->2->2->1
 * 输出: true
 *  
 * 
 *  进阶： 
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
 *  Related Topics 栈 递归 链表 双指针 
 *  👍 1028 👎 0
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/28
 */
public class I234I_IsPalindrome {
    public static void main(String[] args) {

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        I234I_IsPalindrome palindrome = new I234I_IsPalindrome();
        System.out.println(palindrome.isPalindromeIII(node));

    }

    /**
     * 解答成功:
     * 执行耗时:30 ms,击败了6.66% 的Java用户
     * 内存消耗:65.2 MB,击败了5.02% 的Java用户
     * <p>
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode root = new ListNode();
        reverseListNode(head, root);
        while (head != null) {
            if (head.val != root.val) return false;
            head = head.next;
            root = root.next;
        }
        return true;
    }

    public ListNode reverseListNode(ListNode head, ListNode root) {
        if (head.next == null) {
            root.val = head.val;
            return root;
        }
        ListNode node = reverseListNode(head.next, root);
        ListNode cur = new ListNode(head.val);
        node.next = cur;
        return cur;
    }

    /**
     * 				解答成功:
     * 				执行耗时:19 ms,击败了11.70% 的Java用户
     * 				内存消耗:55.4 MB,击败了10.98% 的Java用户
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     */
    boolean res = true;
    public boolean isPalindromeII(ListNode head) {
        if (head == null) return false;
        ListNode root = head;
        res = true;
        ListNode node = checkListNode(head, root);
        return res;
    }

    public ListNode checkListNode(ListNode head, ListNode root) {
        if (head.next == null) {
            if (head.val != root.val) res = false;
            return root.next;
        }
        ListNode node = checkListNode(head.next, root);
        if (head.val != node.val) res = false;
        return node.next;
    }


    /**
     * 				解答成功:
     * 				执行耗时:14 ms,击败了18.18% 的Java用户
     * 				内存消耗:50.6 MB,击败了43.07% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     * @param head
     * @return
     */
    public boolean isPalindromeIII(ListNode head){
        if (head == null) return false;
        Stack<Integer> stack = new Stack<>();
        ListNode root = head;
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        while (root != null) {
            if (root.val != stack.pop()) return false;
            root = root.next;
        }
        return true;
    }
}
