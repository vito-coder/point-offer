package com.vitoboy.leetcode;

/**
 * @Author: vito
 * @Date: 2020/6/30 23:55
 * @Version: 1.0
 */
public class Node {
    int val;
    Node next;
    Node random;
    Node left;
    Node right;

    public Node(){}

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val,Node left,Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
