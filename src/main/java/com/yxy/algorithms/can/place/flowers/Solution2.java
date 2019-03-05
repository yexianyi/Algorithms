package com.yxy.algorithms.can.place.flowers;
/**
 * 605. Can Place Flowers
    Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
    
    Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
    
    Example 1:
    Input: flowerbed = [1,0,0,0,1], n = 1
    Output: True
    Example 2:
    Input: flowerbed = [1,0,0,0,1], n = 2
    Output: False
    Note:
    The input array won't violate no-adjacent-flowers rule.
    The input array size is in the range of [1, 20000].
    n is a non-negative integer which won't exceed the input array size.
 * @author yexianyi
 * 2019/03/05
 * 
 * Copy from:
 * https://leetcode.com/problems/can-place-flowers/solution/
 */
public class Solution2 {
    
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 
                && (i == 0 || flowerbed[i - 1] == 0)
                && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i++] = 1;
                count++;
            }
            
            if (count >= n)
                return true;
            i++;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] { 1 }, 0)); // true
        System.out.println(canPlaceFlowers(new int[] { 0, 0, 1, 0, 1 }, 1)); // true
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1, 0, 0 }, 2)); // true
        System.out.println(canPlaceFlowers(new int[] { 1, 1, 0, 0, 1 }, 1)); // false
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1)); // true
        System.out.println(canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2)); // false
    }

}
