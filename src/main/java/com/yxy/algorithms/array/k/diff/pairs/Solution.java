package com.yxy.algorithms.array.k.diff.pairs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int findPairs(int[] nums, int k) {
        Set<Pair> set = new HashSet<>() ;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1 ; j<nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) == k) {
                    set.add(new Pair(nums[i], nums[j])) ;
                }
            }
        }
        
        return set.size() ;
    }
    
    static class Pair{
        int left ;
        int right ;
        
        public Pair(int l, int r) {
            left = l;
            right = r ;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj ;
            if((this.left == p.left && this.right == p.right ) 
                    ||(this.left == p.right && this.right == p.left ) ) {
                return true ;
            }
            return false;
        }
        
        
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[] {3, 1, 4, 1, 5}, 2));

    }

}
