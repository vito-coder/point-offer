package com.vitoboy.leetcode.daily.jul;

import com.vitoboy.leetcode.pointoffer.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。 
 * 
 *  如下面的两个链表： 
 *
 *  在节点 c1 开始相交。
 * 
 *  示例 1：
 *  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
 * kipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
 * ,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *  示例 2：
 *  输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
 *  1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
 * ]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *
 *  示例 3：
 *  输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
 *  skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *
 *  注意：
 *  如果两个链表没有交点，返回 null. 
 *  在返回结果后，两个链表仍须保持原有的结构。 
 *  可假定整个链表结构中没有循环。 
 *  程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
 *  本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lis
 * ts/ 
 *  
 *  Related Topics 哈希表 链表 双指针 
 *  👍 270 👎 0
 *
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/21
 */
public class I210721I_Ipointoffer_52I_GetIntersectionNode {
    public static void main(String[] args) {
        I210721I_Ipointoffer_52I_GetIntersectionNode intersectionNode = new I210721I_Ipointoffer_52I_GetIntersectionNode();
        ListNode node = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode root = new ListNode(4, new ListNode(1, node));
        ListNode root2 = new ListNode(5, new ListNode(0, new ListNode(1, node)));
        ListNode res = intersectionNode.getIntersectionNode(root, root2);
        while (res != null) {
            System.out.print(res.val + ",");
            res = res.next;
        }
        System.out.println();

        
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:41.1 MB,击败了67.27% 的Java用户
     *
     * 时间复杂度: O(N)
     * 空间复杂度: O(1)
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode first = headA, second = headB;
        while (first != null || second != null) {
            if (first == second) return first;
            if (first == null) {
                first = headB;
                continue;
            }
            if (second == null) {
                second = headA;
                continue;
            }
            first = first.next;
            second = second.next;
        }
        return null;
    }
}
