package com.vitoboy.leetcode.daily.jun;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author vito
 * @version 1.0
 * @date 2021/6/23
 */
public class I210623I_Ipointoffer15I_HammingWeight {
    public static void main(String[] args) {
        I210623I_Ipointoffer15I_HammingWeight hammingWeight = new I210623I_Ipointoffer15I_HammingWeight();


    }

    public int hammingWeight(int n) {
        int count = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }
        return count;
    }
}
