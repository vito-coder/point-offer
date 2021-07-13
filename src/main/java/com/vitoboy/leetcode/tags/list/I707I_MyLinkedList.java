package com.vitoboy.leetcode.tags.list;

/**
 * 
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
 * /引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
 * 
 *  在链表类中实现这些功能： 
 *
 *  get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
 *  addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
 *  addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
 *  addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
 * 到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
 *  deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
 *
 *  示例：
 *  MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 *  提示：
 *  所有val值都在 [1, 1000] 之内。 
 *  操作次数将在 [1, 1000] 之内。 
 *  请不要使用内置的 LinkedList 库。 
 *  
 *  Related Topics 设计 链表 
 *  👍 257 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/13
 */
public class I707I_MyLinkedList {

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        System.out.println(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList.get(1));
        test();
    }

    public static void test() {
        String[] command = new String[]{"MyLinkedList","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","addAtTail","deleteAtIndex","addAtHead","addAtHead","get","addAtTail","addAtHead","get","addAtTail","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","get","addAtIndex","addAtHead","get","addAtHead","deleteAtIndex","addAtHead","addAtTail","addAtTail","addAtIndex","addAtTail","addAtHead","get","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtHead","addAtTail","addAtHead","addAtHead","addAtTail","addAtTail","get","get","addAtHead","addAtTail","addAtTail","addAtTail","addAtIndex","get","addAtHead","addAtIndex","addAtHead","addAtTail","addAtTail","addAtIndex","deleteAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","addAtTail","addAtHead","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","deleteAtIndex","get","get","addAtHead","get","addAtTail","addAtTail","addAtIndex","addAtIndex","addAtHead","addAtTail","addAtTail","get","addAtIndex","addAtHead","deleteAtIndex","addAtTail","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtTail","addAtTail"};
        int[][] ints = new int[][]{{},{38},{66},{61},{76},{26},{37},{8},{5},{4},{45},{4},{85},{37},{5},{93},{10,23},{21},{52},{15},{47},{12},{6,24},{64},{4},{31},{6},{40},{17},{15},{19,2},{11},{86},{17},{55},{15},{14,95},{22},{66},{95},{8},{47},{23},{39},{30},{27},{0},{99},{45},{4},{9,11},{6},{81},{18,32},{20},{13},{42},{37,91},{36},{10,37},{96},{57},{20},{89},{18},{41,5},{23},{75},{7},{25,51},{48},{46},{29},{85},{82},{6},{38},{14},{1},{12},{42},{42},{83},{13},{14,20},{17,34},{36},{58},{2},{38},{33,59},{37},{15},{64},{56},{0},{40},{92},{63},{35},{62},{32}};
        MyLinkedList list = null;
        for (int i = 0; i < command.length; i++) {
            switch (command[i]) {
                case "MyLinkedList":{
                    list = new MyLinkedList();
                    System.out.printf("%s\t\t%s\n",command[i],"true");
                    break;
                }
                case "addAtHead":{
                    list.addAtHead(ints[i][0]);
                    System.out.printf("%s\t\tadd head : %d\ndata: %s\n",command[i],ints[i][0], list.toString());
                    break;
                }
                case "addAtTail":{
                    list.addAtTail(ints[i][0]);
                    System.out.printf("%s\t\tadd tail : %d\ndata: %s\n",command[i],ints[i][0], list.toString());
                    break;
                }
                case "addAtIndex":{
                    list.addAtIndex(ints[i][0], ints[i][1]);
                    System.out.printf("%s\t\tadd index : %d, value : %d\ndata: %s\n",command[i],ints[i][0], ints[i][1], list.toString());
                    break;
                }
                case "get":{
                    int val = list.get(ints[i][0]);
                    System.out.printf("%s\t\tget: %d result: %d\ndata: %s\n",command[i],ints[i][0], val, list.toString());
                    break;
                }
                case "deleteAtIndex":{
                    System.out.printf("%s\t\tdelete: %d\ndata: %s\n",command[i],ints[i][0], list.toString());
                    list.deleteAtIndex(ints[i][0]);
                    System.out.println("new data : " + list.toString());
                    break;
                }
                default:
                    System.out.println("end");
            }
        }
    }
}

/**
 * 				解答成功:
 * 				执行耗时:8 ms,击败了99.17% 的Java用户
 * 				内存消耗:39.2 MB,击败了26.48% 的Java用户
 *
 * 时间复杂度: O(N)
 * 空间复杂度: O(N)
 *
 */
class MyLinkedList {
    int size;
    Node head;
    Node tail;

    class Node{
        int val;
        Node next;
        Node pre;
        public Node(int _val){val = _val;}
        public Node(int _val, Node _pre, Node _next) {val= _val; pre = _pre; next = _next;}
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size=0;
        head = new Node(-1);
        tail = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size == 0 || index >= size || index < 0) return -1;
        if (index > size/2) {
            Node cur = tail;
            for (int i = 0; i < size-index; i++) {
                cur = cur.pre;
            }
            return cur.next.val;
        } else {
            Node cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.next.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.pre = head;
        node.next = head.next;
        if (head.next != null) head.next.pre = node;
        head.next = node;
        if (tail == head) {
            tail = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.pre = tail;
        node.next = tail.next;
        tail.next = node;
        tail = node;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index == 0) {
            addAtHead(val);
        } else if (index < 0 || index > size){
            return;
        } else {
            Node node = new Node(val);
            Node cur;
            if (index > size/2) {
                cur = tail;
                for (int i = 0; i < size-index; i++) {
                    cur = cur.pre;
                }
            } else {
                cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
            }
            node.pre = cur;
            node.next = cur.next;
            node.next.pre = node;
            cur.next = node;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size <= 0 || index < 0 || index >= size ) return;
        if (index == size-1) {
            Node pre = tail.pre;
            pre.next = null;
            tail.pre = null;
            tail = pre;
        } else if (index == 0) {
            Node next = head.next;
            head.next = next.next;
            if(next.next != null) next.next.pre = head;
            next = null;
        } else {
            Node cur;
            if (index > size/2) {
                cur = tail;
                for (int i = 0; i < size-index; i++) {
                    cur = cur.pre;
                }
            } else {
                cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
            }
            Node del = cur.next;
            cur.next = del.next;
            if (del.next != null) del.next.pre = cur;
            del = null;
        }
        size--;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if (size == 0) {
            builder.append("[]");
            return builder.toString();
        } else if (size > 0) {
            builder.append("[");
            Node cur= head.next;
            while(cur != null) {
                builder.append(cur.val).append(",");
                cur = cur.next;
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append("]");
            return builder.toString();
        }
        return "invalid data..";
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
