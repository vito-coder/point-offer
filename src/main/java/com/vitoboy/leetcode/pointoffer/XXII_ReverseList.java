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

        ListNode listNode = reverseList.reverseListMagic(node);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 好理解的双指针
     * 定义两个指针： pre 和 cur ；pre 在前 cur 在后。
     * 每次让 pre 的 next 指向 cur ，实现一次局部反转
     * 局部反转完成之后， pre 和 cur 同时往前移动一个位置
     * 循环上述过程，直至 pre 到达链表尾部
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
     * 简洁的递归
     * 使用递归函数，一直递归到链表的最后一个结点，该结点就是反转后的头结点，记作 ret .
     * 此后，每次函数在返回的过程中，让当前结点的下一个结点的 next 指针指向当前节点。
     * 同时让当前结点的 next 指针指向 NULL ，从而实现从链表尾部开始的局部反转
     * 当递归函数全部出栈后，链表反转完成。
     *
     * 作者：huwt
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-yi-dong-de-shuang-zhi-zhen-jia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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


    /**
     * 妖魔化的双指针
     * 原链表的头结点就是反转之后链表的尾结点，使用 head 标记 .
     * 定义指针 cur，初始化为 head .
     * 每次都让 head 下一个结点的 next 指向 cur ，实现一次局部反转
     * 局部反转完成之后，cur 和 head 的 next 指针同时 往前移动一个位置
     * 循环上述过程，直至 cur 到达链表的最后一个结点 .
     *
     * 作者：huwt
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/fan-zhuan-lian-biao-yi-dong-de-shuang-zhi-zhen-jia/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 1. 两个指针 head 和 cur 都指向链表头
     * 2. 如果链表为空, 或 链表的下个节点为空, 直接返回链表头
     * 3. head -> next -> next 为相对head的第 3 个节点, 用临时变量temp保存 (temp可以指向node4...)
     * 4. 将相对于 head 节点来说的第二个节点(head->next) 的下结点指向(node.next), 改为指向 cur节点(此时的cur == head)
     *      此操作结束后会出现, head -> next -> next = head(cur)
     *      即 head 节点 和 head -> next 节点互为各节点的下级节点
     *      即互相指向 head(cur) <==> head->next
     * 5. 将 cur = head->next, 即 head <==> cur
     * 6. 将 head 的下节点指向(head.next) 改为前面保存的临时节点 temp(第3节点), 即 head->next = temp(第3节点)
     *      此时, cur(第2节点) -> head(第1节点) -> temp(第3节点)
     * 7.重复第3步, 直到 head->next == null
     *
     * @param head
     * @return
     */
    public ListNode reverseListMagic(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = temp;
        }
        return cur;
    }


}
