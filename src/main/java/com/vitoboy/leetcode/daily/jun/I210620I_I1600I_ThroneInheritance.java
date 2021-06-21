package com.vitoboy.leetcode.daily.jun;

import com.vitoboy.leetcode.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vito
 * @version 1.0
 * @date 2021/6/20
 */
public class I210620I_I1600I_ThroneInheritance {
    public static void main(String[] args) {
        ThroneInheritance king = new ThroneInheritance("king");
//        king.birth("king", "clyde");
//        System.out.println(king.getInheritanceOrder());
//        king.death("clyde");
//        king.birth("king","shannon");
//        System.out.println(king.getInheritanceOrder());
//        king.birth("king","scott");
//        king.birth("scott","keith");
//        System.out.println(king.getInheritanceOrder());
        /**
         * ["ThroneInheritance",
         * "getInheritanceOrder",
         * "birth","birth","birth","birth",
         * "getInheritanceOrder",
         * "birth",
         * "getInheritanceOrder"]
         * [["king"],
         * [null],
         * ["king","clyde"],["clyde","shannon"],["shannon","scott"],["king","keith"],
         * [null],
         * ["clyde","joseph"],
         * [null]]
         */
        king.birth("king", "clyde");
        king.birth("clyde", "shannon");
        king.birth("shannon", "scott");
        king.birth("king", "keith");
        System.out.println(king.getInheritanceOrder());
        king.birth("clyde", "joseph");
        System.out.println(king.getInheritanceOrder());


    }

    static class ThroneInheritance {
        class Node {
            String name;
            Node next;
            Node last;
            boolean isDeleted = false;
            Node(String name) {
                this.name = name;
            }
        }

        Map<String, Node> map = new HashMap<>();
        Node head = new Node(""), tail = new Node("");

        public ThroneInheritance(String kingName) {
            Node root = new Node(kingName);
            root.next = tail;
            head.next = root;
            map.put(kingName, root);
        }

        public void birth(String parentName, String childName) {
            Node cnode = new Node(childName);
            map.put(childName, cnode);
            Node temp = map.get(parentName);
            while (temp.last != null) temp = temp.last;
            cnode.next = temp.next;
            temp.next = cnode;
        }

        public void death(String name) {
            Node node = map.get(name);
            node.isDeleted = true;
        }

        public List<String> getInheritanceOrder() {
            Node node = head.next;
            List<String> res = new ArrayList<>();
            while (node != null) {
                if (!node.isDeleted) {
                    res.add(node.name);
                }
                node = node.next;
            }
            return res;
        }
    }
}
