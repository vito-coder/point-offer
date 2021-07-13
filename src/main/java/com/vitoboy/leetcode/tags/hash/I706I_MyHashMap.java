package com.vitoboy.leetcode.tags.hash;

/**
 * 
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。 
 * 
 *  实现 MyHashMap 类：
 *  MyHashMap() 用空映射初始化对象 
 *  void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，
 * 则更新其对应的值 value 。 
 *  int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。 
 *  void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。 
 *
 *  示例：
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * 
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 *
 *  提示：
 *  0 <= key, value <= 106 
 *  最多调用 104 次 put、get 和 remove 方法 
 *
 *  进阶：你能否不使用内置的 HashMap 库解决此问题？ 
 *  Related Topics 设计 数组 哈希表 链表 哈希函数 
 *  👍 206 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/13
 */
public class I706I_MyHashMap {
    public static void main(String[] args) {
        
    }
    
}


/**
 * 				解答成功:
 * 				执行耗时:14 ms,击败了99.84% 的Java用户
 * 				内存消耗:44.4 MB,击败了42.50% 的Java用户
 *
 * 时间复杂度: O(N)
 * 空间复杂度: O(N)
 *
 */
class MyHashMap {
    int mod = 10009;
    Node[] map = new Node[mod];
    class Node{
        int key, val;
        Node next;
        public Node(int _key, int _val){
            key=_key;
            val= _val;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getIndex(key);
        Node node = map[idx];
        if (node == null) {
            map[idx] = new Node(key, value);
        } else {
            Node pre = null;
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    return;
                }
                pre = node;
                node = node.next;
            }
            pre.next = new Node(key, value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getIndex(key);
        Node node = map[idx];
        if (node == null) return -1;
        while (node != null) {
            if (node.key == key) return node.val;
            node = node.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getIndex(key);
        Node node = map[idx];
        if (node == null) return;
        Node pre = null;
        while (node != null) {
            if (node.key == key) {
                if (node == map[idx]) {
                    if (node.next == null) {
                        map[idx] = null;
                    } else {
                        map[idx] = node.next;
                    }
                    return;
                } else {
                    pre.next = node.next;
                    return;
                }
            }
            pre = node;
            node = node.next;
        }

    }

    int getIndex(int key) {
        int hash = Integer.hashCode(key);
        hash ^= (hash >> 16);
        return hash % mod;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
