package com.vitoboy.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: vito
 * @Date: 2020/7/3 13:19
 * @Version: 1.0
 *
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 *
 * 示例 2：
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 */
public class LXIV_MaxQueue {
    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
//        queue.push_back(5);
//        queue.push_back(4);
//        queue.push_back(3);
//        queue.push_back(5);

//        System.out.println(queue.max_value());
//        System.out.println(queue.pop_front());
//        System.out.println(queue.max_value());
//        System.out.println(queue.pop_front());
//        System.out.println(queue.max_value());


        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        queue.push_back(46);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        queue.push_back(868);
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        queue.push_back(525);
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        queue.push_back(123);
        queue.push_back(646);
        System.out.println(queue.max_value());
        queue.push_back(229);
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        queue.push_back(871);
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        queue.push_back(285);
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        queue.push_back(45);
        queue.push_back(140);
        queue.push_back(837);
        queue.push_back(545);
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        queue.push_back(561);
        queue.push_back(237);
        System.out.println(queue.pop_front());
        queue.push_back(633);
        queue.push_back(98);
        queue.push_back(806);
        queue.push_back(717);
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        queue.push_back(186);
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        queue.push_back(268);
        System.out.println(queue.pop_front());
        queue.push_back(29);
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        queue.push_back(866);
        System.out.println(queue.pop_front());
        queue.push_back(239);
        queue.push_back(3);
        queue.push_back(850);
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        queue.push_back(310);
        System.out.println(queue.pop_front());
        queue.push_back(674);
        queue.push_back(770);
        System.out.println(queue.pop_front());
        queue.push_back(525);
        System.out.println(queue.pop_front());
        queue.push_back(425);
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        queue.push_back(720);
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        queue.push_back(373);
        queue.push_back(411);
        System.out.println(queue.max_value());
        queue.push_back(831);
        System.out.println(queue.pop_front());
        queue.push_back(765);
        queue.push_back(701);
        System.out.println(queue.pop_front());


    }
}

class MaxQueue {

    Queue<Integer> queue;
    LinkedList<Integer> max;
    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.size() == 0 ? -1 : max.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        if (max.size() == 0) max.add(value);
        else {
            while (max.size() >0 && max.getLast() < value) {
                max.removeLast();
            }
            max.add(value);
        }
    }

    public int pop_front() {
        if (queue.size() <= 0) return -1;
        Integer value = queue.poll();
        if (max.size()> 0 && value.equals(max.getFirst())) {
            max.removeFirst();
        }
        return value;
    }
}
