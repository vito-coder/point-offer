package com.vitoboy.leetcode.common;

import java.util.Objects;

/**
 * @Author: vito
 * @Date: 2020/6/30 23:55
 * @Version: 1.0
 */
public class Node {
    public int val;
    public Node next;
    public Node random;
    public Node left;
    public Node right;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val &&
                Objects.equals(next, node.next) &&
                Objects.equals(random, node.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random);
    }
}
