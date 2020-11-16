package com.yxy.algorithms.numbers.permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 46. Permutations   My Submissions QuestionEditorial Solution
	Total Accepted: 97046 Total Submissions: 272240 Difficulty: Medium
	Given a collection of distinct numbers, return all possible permutations.
	
	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author xianyiye
 * @date 11/13/2020
 * 
 * Reference:
 * https://leetcode.com/problems/permutations/solution/
 */
public class Solution4 {
	
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i) ;
        }
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums.length, list, res, 0);
        
        return res;
    }

    
    private static void backTrack(int max_len, List<Integer> currList,  List<List<Integer>> res, int first) {
        if(first == max_len) {
            res.add(new ArrayList<>(currList)) ;
//            for(int num : currList){
//                System.out.print(num+" ");
//            }
//            System.out.println() ;
        }
        
        for(int i=first; i<max_len; i++) {
            Collections.swap(currList, first, i);
            backTrack(max_len, currList, res, first + 1) ;
            Collections.swap(currList, first, i);
        }
    }
	

    public static void main(String[] args) {
        List<List<Integer>> results = permute(new int[] { 1, 2, 3, 4 });

        for (List<Integer> numList : results) {
            for (int num : numList) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
