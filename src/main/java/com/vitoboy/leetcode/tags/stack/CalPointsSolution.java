package com.vitoboy.leetcode.tags.stack;

import sun.tools.jstat.Jstat;

import java.util.Stack;

/**
 * 
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。 
 * 
 *  比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则： 
 * 
 *  
 *  整数 x - 表示本回合新获得分数 x 
 *  "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。 
 *  "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。 
 *  "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。 
 *  
 * 
 *  请你返回记录中所有得分的总和。 
 * 
 *  
 * 
 *  示例 1： 
 * 
 *  
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 *  
 * 
 *  示例 2： 
 * 
 *  
 * 输入：ops = ["5","-2","4","C","D","9","+","+"]
 * 输出：27
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "-2" - 记录加 -2 ，记录现在是 [5, -2]
 * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 *  
 * 
 *  示例 3： 
 * 
 *  
 * 输入：ops = ["1"]
 * 输出：1
 *  
 * 
 *  
 * 
 *  提示： 
 * 
 *  
 *  1 <= ops.length <= 1000 
 *  ops[i] 为 "C"、"D"、"+"，或者一个表示整数的字符串。整数范围是 [-3 * 104, 3 * 104] 
 *  对于 "+" 操作，题目数据保证记录此操作时前面总是存在两个有效的分数 
 *  对于 "C" 和 "D" 操作，题目数据保证记录此操作时前面总是存在一个有效的分数 
 *  
 *  Related Topics 栈 
 *  👍 164 👎 0
 * 
 * @Author: vito
 * @Date: 2021/1/24 上午2:02
 * @Version: 1.0
 */
public class CalPointsSolution {

    public static void main(String[] args) {

        CalPointsSolution solution = new CalPointsSolution();
        String[] ops = new String[]{"5","2","C","D","+"};
        System.out.println(solution.calPointsI(ops));
        ops = new String[]{"5","-2","4","C","D","9","+","+"};
        System.out.println(solution.calPointsI(ops));
        ops = new String[]{"1"};
        System.out.println(solution.calPointsI(ops));

        System.out.println();

        ops = new String[]{"5","2","C","D","+"};
        System.out.println(solution.calPoints(ops));
        ops = new String[]{"5","-2","4","C","D","9","+","+"};
        System.out.println(solution.calPoints(ops));
        ops = new String[]{"1"};
        System.out.println(solution.calPoints(ops));

    }


    /**
     * 不使用栈, 直接使用数组实现
     * 使用了额外的数组num[index]，存储int值。
     *
     * 解答成功:
     * 				执行耗时:1 ms,击败了100.00% 的Java用户
     * 				内存消耗:36.2 MB,击败了98.10% 的Java用户
     *
     * @param ops
     * @return
     */
    public int calPointsI(String[] ops) {
        if (ops == null || ops.length == 0) {
            return Integer.MIN_VALUE;
        }
        if (ops.length == 1) {
            return Integer.parseInt(ops[0]);
        }
        int[] nums = new int[ops.length];
        int index = 0;
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    nums[index] = nums[index-1] + nums[index-2];
                    sum += nums[index];
                    break;
                case "D":
                    nums[index] = nums[index-1]*2;
                    sum += nums[index];
                    break;
                case "C":
                    index--;
                    sum -= nums[index];
                    index--;
                    break;
                default:
                    nums[index] = Integer.parseInt(ops[i]);
                    sum += nums[index];
            }
            index++;
        }
        return sum;

    }


    /**
     * 棒球比赛(vito)
     * 解答成功:
     * 				执行耗时:3 ms,击败了84.03% 的Java用户
     * 				内存消耗:37.6 MB,击败了83.22% 的Java用户
     *
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int sum = Integer.MIN_VALUE;
        if (ops == null || ops.length == 0) {
            return sum;
        }
        sum = Integer.parseInt(ops[0]);
        Stack<Integer> stack = new Stack<>();
        stack.push(sum);
        int temp1 = 0, temp2 = 0;
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "+":
                    temp1 = stack.pop();
                    temp2 = stack.pop();
                    sum = sum + temp1 + temp2;
                    stack.push(temp2);
                    stack.push(temp1);
                    stack.push(temp1+temp2);
                    break;
                case "D":
                    temp1 = stack.pop();
                    sum = sum + temp1 * 2;
                    stack.push(temp1);
                    stack.push(temp1*2);
                    break;
                case "C":
                    temp1 = stack.pop();
                    sum = sum - temp1;
                    break;
                default:
                    stack.push(Integer.parseInt(ops[i]));
                    sum = sum + Integer.parseInt(ops[i]);
            }
        }

        return sum;
    }
}
