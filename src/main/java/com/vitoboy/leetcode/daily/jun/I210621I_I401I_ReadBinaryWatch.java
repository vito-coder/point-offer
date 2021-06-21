package com.vitoboy.leetcode.daily.jun;

import java.util.*;

/**
 * 
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *  例如，下面的二进制手表读取 "3:25" 。 
 *
 *  （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
 * Unported (CC BY-SA 3.0) ） 
 * 
 *  给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
 * 
 *  小时不会以零开头： 
 *
 *  例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
 *
 *  分钟必须由两位数组成，可能会以零开头： 
 *
 *  例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
 *  
 *
 *  示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 *  
 * 
 *  示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 *
 * 
 *  解释：
 *  0 <= turnedOn <= 10 
 *  
 *  Related Topics 位运算 回溯算法 
 *  👍 274 👎 0
 * 
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/6/21
 */
public class I210621I_I401I_ReadBinaryWatch {
    public static void main(String[] args) {

    }

    /**
     * 				解答成功:
     * 				执行耗时:12 ms,击败了34.05% 的Java用户
     * 				内存消耗:37.2 MB,击败了51.88% 的Java用户
     *
     * 	官方题解
     * 	时间复杂度: O(1) 无论输入是多少, 都是一样的循环数, 是个定值,且有限, 可以认为是固定的常数, 时间复杂度为 O(1)
     * 	空间复杂度: O(1)
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        if (turnedOn == 0) {
            res.add("0:00");
            return res;
        } else if (turnedOn < 0 || turnedOn > 8) {
            return res;
        }
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn){
                    res.add(h+":"+(m < 10 ? "0" : "") + m);
                }
            }
        }
        return res;
    }


    /**
     * 				解答成功:
     * 				执行耗时:11 ms,击败了43.74% 的Java用户
     * 				内存消耗:37.4 MB,击败了43.00% 的Java用户
     *
     *
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatchII(int turnedOn) {
        List<String> res = new ArrayList<>();
        if (turnedOn == 0) {
            res.add("0:00");
            return res;
        } else if (turnedOn < 0 || turnedOn > 8) {
            return res;
        }
        for (int i = 0; i < 1024; i++) {
            int h = i>>6, m = i & 63; // 用位运算取出高 4 位和低 6 位
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                res.add(h+":"+(m < 10 ? "0" : "") + m);
            }
        }
        return res;
    }


    /**
     * 				解答成功:
     * 				执行耗时:0 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.8 MB,击败了88.22% 的Java用户
     */
    class Solution {
        // 直接把二进制的问题转换为数组累加问题
        int[] hours = new int[]{1,2,4,8,0,0,0,0,0,0};
        int[] minutes = new int[]{0,0,0,0,1,2,4,8,16,32};
        List<String> res = new ArrayList<>();

        public List<String> readBinaryWatch(int turnedOn) {
            // 方法二：采用回溯法
            backTrack(turnedOn,0,0,0);
            return res;

        }

        // 回溯的参数：num(需要点亮的灯，初始为turnedOn),index(点亮的下标)
        // hour(小时数)minute(分钟数)
        public void backTrack(int num,int index,int hour,int minute){
            // 剪枝操作
            if(hour > 11  || minute > 59){
                return;
            }
            // 递归出口,当点亮到第0栈灯的时候，那么回溯所有数据
            if(num == 0){
                // 进行字符串拼接
                StringBuilder sb = new StringBuilder();
                sb.append(hour).append(':');
                if(minute < 10){
                    sb.append('0');
                }
                sb.append(minute);
                res.add(sb.toString());
                //记得return终止掉
                return;
            }
            // 这里是从下标开始递归遍历
            for(int i = index; i < 10; i++){
                backTrack(num - 1, i+1,hour+hours[i],minute+minutes[i]);
            }
        }
    }
}
