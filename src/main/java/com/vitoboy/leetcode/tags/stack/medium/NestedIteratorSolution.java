package com.vitoboy.leetcode.tags.stack.medium;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。 
 * 
 *  列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。 
 * 
 *  
 * 
 *  示例 1: 
 * 
 *  输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。 
 * 
 *  示例 2: 
 * 
 *  输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 *  
 *  Related Topics 栈 设计 
 *  👍 188 👎 0
 * 
 * @Author: vito
 * @Date: 2021/2/1 下午5:20
 * @Version: 1.0
 */
public class NestedIteratorSolution {
    
     public interface NestedInteger {
         // @return true if this NestedInteger holds a single integer, rather than a nested list.
         public boolean isInteger();
         // @return the single integer that this NestedInteger holds, if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds, if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
     }

     static class NestedObj implements NestedInteger {
         Integer integer;
         List<NestedInteger> list;
         public NestedObj(int integer){this.integer = integer;}
         public NestedObj(List<NestedInteger> list) {this.list = list;}

         public void setInteger(Integer integer) {
             this.integer = integer;
         }

         public void setList(List<NestedInteger> list) {
             this.list = list;
         }

         @Override
         public boolean isInteger() {
             return list == null;
         }

         @Override
         public Integer getInteger() {
             return integer;
         }

         @Override
         public List<NestedInteger> getList() {
             return list;
         }
     }

    /**
     * 输入: [[1,1],2,[1,1]]
     * 输出: [1,1,2,1,1]
     * @return
     */
    public static List<NestedInteger> nestedIntegerList(){
        System.out.println("[[1,1],2,[1,1]]");
         List<NestedInteger> list = new ArrayList<>();
         List<NestedInteger> item = new ArrayList<>();
         List<NestedInteger> item2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            NestedObj integer = new NestedObj(1);
            item.add(integer);
            integer = new NestedObj(1);
            item2.add(integer);
        }
        NestedObj obj = new NestedObj(item);
        list.add(obj);
        obj = new NestedObj(2);
        list.add(obj);
        obj = new NestedObj(item2);
        list.add(obj);
        return list;
     }

     public static List<NestedInteger> testTwo(){
         System.out.println("[1,[4,[6]]]");
         NestedObj obj1 = new NestedObj(1);
         NestedObj obj4 = new NestedObj(4);
         NestedObj obj6 = new NestedObj(6);
         List<NestedInteger> list6 = new ArrayList<>(1);
         list6.add(obj6);
         NestedObj listObj = new NestedObj(list6);
         List<NestedInteger> list46 = new ArrayList<>(2);
         list46.add(obj4);
         list46.add(listObj);
         NestedObj obj =new NestedObj(list46);

         List<NestedInteger> list = new ArrayList<>();
         list.add(obj1);
         list.add(obj);
         return list;
     }
    public static void main(String[] args) {
        NestedIteratorI iterator = new NestedIteratorI(nestedIntegerList());
        System.out.print("[");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }
        System.out.print("]\n");

        iterator = new NestedIteratorI(testTwo());
        System.out.print("[");
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }
        System.out.print("]");


    }


    /**
     * 				解答成功:
     * 				执行耗时:3 ms,击败了91.08% 的Java用户
     * 				内存消耗:40.9 MB,击败了43.46% 的Java用户
     */
    static class NestedIteratorI implements Iterator<Integer> {
        List<Integer> list = new ArrayList<>();
        ListIterator<Integer> it;

        public NestedIteratorI (List<NestedInteger> nestedList) {
            dnf(nestedList);
            it = list.listIterator();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        @Override
        public Integer next() {
            return it.next();
        }

        private void dnf(List<NestedInteger> nestedIntegerList) {
            for (NestedInteger nestedInteger : nestedIntegerList) {
                if (nestedInteger.isInteger()) {
                    list.add(nestedInteger.getInteger());
                } else {
                    dnf(nestedInteger.getList());
                }
            }
        }
    }



    /**
     * 				解答成功:
     * 				执行耗时:5 ms,击败了17.66% 的Java用户
     * 				内存消耗:41.1 MB,击败了7.20% 的Java用户
     */
    static class NestedIterator implements Iterator<Integer> {

         private Stack<Integer> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            saveValue(nestedList);
        }

        private void saveValue(List<NestedInteger> nestedList) {
            if (nestedList == null || nestedList.isEmpty() ) {
                return;
            }
            for (int i = nestedList.size() -1 ; i >= 0; i--) {
                NestedInteger nestedInteger = nestedList.get(i);
                if (nestedInteger.isInteger()) {
                    stack.push(nestedInteger.getInteger());
                }
                else {
                    saveValue(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return stack.pop();
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
