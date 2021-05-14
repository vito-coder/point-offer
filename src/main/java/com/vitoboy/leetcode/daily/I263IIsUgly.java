package com.vitoboy.leetcode.daily;

/**
 * @Author: vito
 * @Date: 2021/4/10 下午10:36
 * @Version: 1.0
 */
public class I263IIsUgly {
    public static void main(String[] args) {
        IsUgly isUgly = new IsUgly();
        System.out.println("result is : " + isUgly.isUgly(6));
        System.out.println("expect is : true");
        System.out.println("result is : " + isUgly.isUgly(8));
        System.out.println("expect is : true");
        System.out.println("result is : " + isUgly.isUgly(14));
        System.out.println("expect is : false");
        System.out.println("result is : " + isUgly.isUgly(1));
        System.out.println("expect is : true");

    }

    static class IsUgly {

        public boolean isUgly(int n) {
            if(n<=6) return true;
            while(n > 6) {
                if (n%2 == 0 ) {
                    n = n/2;
                    continue;
                } else if ( n%3 == 0) {
                    n = n/3;
                    continue;
                } else if (n%5 == 0) {
                    n = n / 5;
                    continue;
                } else{
                    return false;
                }
            }
            return true;
        }
    }
}
