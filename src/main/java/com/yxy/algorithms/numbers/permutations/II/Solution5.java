package com.yxy.algorithms.numbers.permutations.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II  QuestionEditorial Solution  My Submissions
	Total Accepted: 76800
	Total Submissions: 267865
	Difficulty: Medium
	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
	For example,
	[1,1,2] have the following unique permutations:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]

 * @author xianyiye
 * @date 07/08/2016
 * 
 * Copy from:
 * http://www.changyu496.com/?p=32
 */
public class Solution5 {
	
	// beats 78.25%
	// swap
	public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permutation(0,num.length,num,result);
        return result;
    }
	
	public static void permutation(int from,int to,int[] num, List<List<Integer>> result){
		if(from==to){
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<num.length;i++){
				list.add(num[i]);
			}
			result.add(list);
			return;
		}
		
		for(int i=from;i<to;i++){
			if(isCanSwap(from,i,num)){
				swap(i,from,num);			
				permutation(from+1,to,num,result);			
				swap(i,from,num);
			}
		}
	}
	
	public static boolean isCanSwap(int from,int to,int[] num){
		boolean result = true;
		for(int i=from;i<to;i++){
			if(num[to] == num[i]){
				result = false;
				break;
			}
		}
		return result;
	}
	
	public static void swap(int i,int j,int[] num){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	

	public static void main(String[] args) {
		List<List<Integer>> ret = permuteUnique(new int[]{1,1,1,2}) ;
		for(List<Integer> list : ret){
			for(int num : list){
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

}
