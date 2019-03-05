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
 */

public class Solution {
    
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i<flowerbed.length; i++) {
           if(canPlaceFlowers(flowerbed, i, n)) {
               return true ;
           }
        }
        
        return false ;
    }
    
    public static boolean canPlaceFlowers(int[] flowerbed, int start, int n) {
        if(start >= flowerbed.length && n != 0) {
            return false ;
        }
        
        if(n == 0) {
            return true ;
        }
        
        boolean plant = false ;
        if(flowerbed[start] == 1 
        || (start-1 >=0 && flowerbed[start-1] == 1) 
        || (start+1 < flowerbed.length && flowerbed[start+1] == 1)) {
            plant = canPlaceFlowers(flowerbed, start + 1, n) ;
        } else {
            flowerbed[start] = 1 ;
            plant = canPlaceFlowers(flowerbed, start + 2, --n) ;
            flowerbed[start] = 0 ;
        }
        
        return plant ;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[] {1}, 0)); // true
        System.out.println(canPlaceFlowers(new int[] {0,0,1,0,1}, 1)); // true
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1,0,0}, 2)); // true
        System.out.println(canPlaceFlowers(new int[] {1,1,0,0,1}, 1)); // false
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 1)); // true
        System.out.println(canPlaceFlowers(new int[] {1,0,0,0,1}, 2)); // false
    }

}
