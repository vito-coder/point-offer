package com.vitoboy.leetcode.pointoffer;

/**
 * @Author: vito
 * @Date: 2020/6/17 18:10
 * @Version: 1.0
 *
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 */
public class III_ReplaceSpace {

    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpace(str));
    }

    public static String replaceSpace(String str) {
            return str.toString().replace(" ", "%20");
    }
}
