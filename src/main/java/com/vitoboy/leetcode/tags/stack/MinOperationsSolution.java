package com.vitoboy.leetcode.tags.stack;

import java.util.Stack;

/**
 * 每当用户执行变更文件夹操作时，LeetCode 文件系统都会保存一条日志记录。 
 * 
 *  下面给出对变更操作的说明： 
 * 
 *  
 *  "../" ：移动到当前文件夹的父文件夹。如果已经在主文件夹下，则 继续停留在当前文件夹 。 
 *  "./" ：继续停留在当前文件夹。 
 *  "x/" ：移动到名为 x 的子文件夹中。题目数据 保证总是存在文件夹 x 。 
 *  
 * 
 *  给你一个字符串列表 logs ，其中 logs[i] 是用户在 ith 步执行的操作。 
 * 
 *  文件系统启动时位于主文件夹，然后执行 logs 中的操作。 
 * 
 *  执行完所有变更文件夹操作后，请你找出 返回主文件夹所需的最小步数 。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 
 *  输入：logs = ["d1/","d2/","../","d21/","./"]
 * 输出：2
 * 解释：执行 "../" 操作变更文件夹 2 次，即可回到主文件夹
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 
 *  输入：logs = ["d1/","d2/","./","d3/","../","d31/"]
 * 输出：3
 *  
 * 
 *  示例 3： 
 * 
 *  输入：logs = ["d1/","../","../","../"]
 * 输出：0
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= logs.length <= 103 
 *  2 <= logs[i].length <= 10 
 *  logs[i] 包含小写英文字母，数字，'.' 和 '/' 
 *  logs[i] 符合语句中描述的格式 
 *  文件夹名称由小写英文字母和数字组成 
 *  
 *  Related Topics 栈 
 *  👍 10 👎 0
 * 
 * @Author: vito
 * @Date: 2021/2/5 下午2:42
 * @Version: 1.0
 */
public class MinOperationsSolution {
    public static void main(String[] args) {
        MinOperationsSolution solution = new MinOperationsSolution();
        String[] logs = new String[]{"d1/","d2/","../","d21/","./"};
        System.out.println("result is : " + solution.minOperationsI(logs));
        System.out.println("expect is : 2");
        logs = new String[]{"d1/","d2/","./","d3/","../","d31/"};
        System.out.println("result is : " + solution.minOperationsI(logs));
        System.out.println("expect is : 3");
        logs = new String[]{"d1/","../","../","../"};
        System.out.println("result is : " + solution.minOperationsI(logs));
        System.out.println("expect is : 0");
        logs = new String[]{"./","../","./"};
        System.out.println("result is : " + solution.minOperationsI(logs));
        System.out.println("expect is : 0");
    }


    /**
     * 使用栈的解法
     *
     * 				解答成功:
     * 				执行耗时:2 ms,击败了39.21% 的Java用户
     * 				内存消耗:37.9 MB,击败了80.34% 的Java用户
     *
     * @param logs
     * @return
     */
    public int minOperationsI(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            if (log.equals("../") ) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!log.equals("./")){
                stack.push(log);
            }
        }
        return stack.size();
    }

    /**
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.76% 的Java用户
     * 				内存消耗:38.2 MB,击败了29.14% 的Java用户
     *
     * 				解答成功:
     * 				执行耗时:1 ms,击败了99.76% 的Java用户
     * 				内存消耗:38.2 MB,击败了32.26% 的Java用户
     *
     * @param logs
     * @return
     */
    public int minOperations(String[] logs) {
        int deep = 0;
        String cur = "./";
        String parent = "../";
        for (int i = 0; i < logs.length; i++) {
            if (parent.equals(logs[i])) {
                if (deep > 0) {
                    deep--;
                }
            } else if (!cur.equals(logs[i])){
                deep++;
            }
        }
        return deep;
    }
}
