package com.vitoboy.leetcode.tags.stack.medium;

import java.util.Stack;

/**
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。 
 * 
 *  在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成
 * 部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径 
 * 
 *  请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表
 * 示绝对路径的最短字符串。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *  
 * 
 *  示例 2： 
 * 
 *  输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 *  
 * 
 *  示例 3： 
 * 
 *  输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *  
 * 
 *  示例 4： 
 * 
 *  输入："/a/./b/../../c/"
 * 输出："/c"
 *  
 * 
 *  示例 5： 
 * 
 *  输入："/a/../../b/../c//.//"
 * 输出："/c"
 *  
 * 
 *  示例 6： 
 * 
 *  输入："/a//b////c/d//././/.."
 * 输出："/a/b/c" 
 *  Related Topics 栈 字符串 
 *  👍 238 👎 0
 * 
 * 
 * @Author: vito
 * @Date: 2021/1/21 下午5:29
 * @Version: 1.0
 */
public class SimplifyPathSolution {

    public static void main(String[] args) {
        SimplifyPathSolution solution = new SimplifyPathSolution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/..."));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
    }

    /**
     * 解答成功:
     * 				执行耗时:6 ms,击败了54.58% 的Java用户
     * 				内存消耗:38.6 MB,击败了43.53% 的Java用户
     *
     * @param path      待处理的路径
     * @return
     *  返回简化后的路径
     */
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String split = "/";
        if (path.indexOf('/') == -1){
            return path;
        }
        String[] array = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : array) {
            if (s.isEmpty()) {
                continue;
            }
            if (stack.isEmpty() && !s.contains(".")) {
                stack.push(split);
                stack.push(s);
                continue;
            }
            switch (s) {
                case "..":
                    if (stack.size() > 2) {
                        stack.pop();
                        stack.pop();
                    } else if (stack.size() == 2) {
                        stack.pop();
                    }
                    break;
                case ".": break;
                default:
                    if (!stack.isEmpty()) {
                        if (!"/".equals(stack.peek())) {
                            stack.push(split);
                        }
                    } else {
                        stack.push(split);
                    }
                    stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return split;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
