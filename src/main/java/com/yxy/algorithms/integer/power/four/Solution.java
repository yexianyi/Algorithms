package com.yxy.algorithms.integer.power.four;

/**
 * 342. Power of Four 
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example 1:
 * 
 * Input: 16 Output: true Example 2:
 * 
 * Input: 5 Output: false Follow up: Could you solve it without loops/recursion?
 * 
 * @author yexianyi 2019/03/18
 */
public class Solution {

    public static boolean isPowerOfFour(int num) {
        int target = 0b01010101010101010101010101010100;
        return ((num & (num - 1)) == 0) && ((num & target) == num) && (num > 0) || (num == 1);

    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16)); // true
        System.out.println(isPowerOfFour(5)); // false
    }

}
