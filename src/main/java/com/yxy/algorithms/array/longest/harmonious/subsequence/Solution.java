package com.yxy.algorithms.array.longest.harmonious.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. Longest Harmonious Subsequence
    We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
    
    Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
    
    Example 1:
    Input: [1,3,2,2,5,2,3,7]
    Output: 5
    Explanation: The longest harmonious subsequence is [3,2,2,2,3].
    Note: The length of the input array will not exceed 20,000.
 * @author yexianyi
 * 2019/03/19
 */
public class Solution {
    
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>() ;
        
        for(int i=0; i<nums.length; i++) {
            map.putIfAbsent(nums[i], 0) ;
            map.put(nums[i], map.get(nums[i]) + 1) ;
        }
        
        int max = 0 ;
        for(Integer key : map.keySet()) {
            int num = map.get(key) ;
            if(map.containsKey(key+1)) {
                max = Integer.max(max, num + map.get(key+1))  ;
            }
        }
        
        
        return max ;
    }


    public static void main(String[] args) {
        System.out.println(findLHS(new int[] {1,1,1,1,1,1}));
        System.out.println(findLHS(new int[] {1,3,2,2,5,2,3,7}));

    }

}
