package com.vitoboy.leetcode.daily.jul;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。 
 * 
 *  原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。 
 * 
 *  如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *  
 * 
 *  两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。 
 * 
 *  一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。 
 * 
 *  给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数
 * 量（如果数量大于 1），以此类推。 
 * 
 *  示例 1:
 * 输入:  formula = "H2O"
 * 输出: "H2O"
 * 解释: 
 * 原子的数量是 {'H': 2, 'O': 1}。
 *  
 * 
 *  示例 2:
 * 输入:  formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释: 
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 *  
 * 
 *  示例 3:
 * 输入:  formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释: 
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 *  
 * 
 *  注意:
 *  所有原子的第一个字母为大写，剩余字母都是小写。 
 *  formula的长度在[1, 1000]之间。 
 *  formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。 
 *  
 *  Related Topics 栈 哈希表 字符串 
 *  👍 140 👎 0
 * 
 * 
 * @author vito
 * @version 1.0
 * @date 2021/7/5
 */
public class I210705I_I726I_CountOfAtoms {
    public static void main(String[] args) {
        I210705I_I726I_CountOfAtoms atoms = new I210705I_I726I_CountOfAtoms();
        String formula = "K4(ON(SO3)2)2";
        System.out.println(atoms.countOfAtoms(formula));
        System.out.println("expect is : K4N2O14S4");
        formula = "H2O";
        System.out.println(atoms.countOfAtoms(formula));
        System.out.println("expect is : H2O");
        formula = "Mg(OH)2";
        System.out.println(atoms.countOfAtoms(formula));
        System.out.println("expect is : H2MgO2");
    }

    /**
     * 				解答成功:
     * 				执行耗时:10 ms,击败了29.29% 的Java用户
     * 				内存消耗:37.3 MB,击败了27.86% 的Java用户
     *
     * 就硬算
     * 时间复杂度: O(N)
     * 空间复杂度: O(N)
     *
     * @param formula
     * @return
     */
    public String countOfAtoms(String formula) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        boolean prenum = false;
        for (int i = 0, len = formula.length(); i < len; i++) {
            char ch = formula.charAt(i);
            if (isNum(ch)) {
                if (prenum) {
                    builder.append(ch);
                } else {
                    prenum = true;
                    if (builder.length() > 0) {
                        stack.add(builder.toString());
                        builder = new StringBuilder();
                    }
                    builder.append(ch);
                }
                continue;
            }
            if (isBracket(ch)){
                if (builder.length() > 0) {
                    stack.add(builder.toString());
                    builder = new StringBuilder();
                    if (prenum) prenum = false;
                }
                stack.add(ch + "");
                continue;
            }
            if (isUpperCase(ch)) {
                if (builder.length() > 0) {
                    if (prenum) prenum = false;
                    stack.add(builder.toString());
                    builder = new StringBuilder();
                }
                builder.append(ch);
                continue;
            }
            if (isLowerCase(ch)) {
                builder.append(ch);
            }
        }
        if (builder.length() > 0){
            stack.add(builder.toString());
        }
        // K4(ON(SO3)2)2  ==> 'K', '4', '(', 'O', 'N', '(', 'S', 'O', '3', ')', '2', ')', '2'
        int time = 1;
        TreeMap<String, Integer> countMap = countStackOfAtoms(stack, time);
        builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            builder.append(entry.getKey());
            if (entry.getValue() > 1) {
                builder.append(entry.getValue());
            }
        }
        return builder.toString();
    }

    private TreeMap<String, Integer> countStackOfAtoms(Stack<String> stack, int time) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        int local = time;
        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (isInt(str)) {
                local = Integer.parseInt(str)*local;
                continue;
            }
            if (strBracket(str)) {
                // 结束标志
                if (")".equals(str)) {
                    TreeMap<String, Integer> count = countStackOfAtoms(stack, local);
                    for (Map.Entry<String, Integer> entry : count.entrySet()) {
                        if(treeMap.containsKey(entry.getKey())) {
                            treeMap.put(entry.getKey(), entry.getValue() + treeMap.get(entry.getKey()));
                        } else {
                            treeMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    local = time;
                } else {
                    return treeMap;
                }
                continue;
            }
            if (treeMap.containsKey(str)) {
                treeMap.put(str, treeMap.get(str) + local);
            } else {
                treeMap.put(str, local);
            }
            local = time;
        }
        return treeMap;
    }

    private boolean isInt(String str) {
        boolean isint = true;
        for (int i = 0, len = str.length(); i < len; i++) {
            if (!isNum(str.charAt(i))) return false;
        }
        return true;
    }

    private boolean isNum(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }

    private boolean isLowerCase(char ch) {
        if (ch >= 'a' && ch <= 'z'){
            return true;
        }
        return false;
    }

    private boolean isUpperCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }

    private boolean isBracket(char ch) {
        if (ch == '(' || ch == ')') return true;
        else return false;
    }

    private boolean strBracket(String ch) {
        if ("(".equals(ch) || ")".equals(ch)) return true;
        else return  false;
    }
}
