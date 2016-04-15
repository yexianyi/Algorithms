package com.yxy.algorithms.gray.code;

import java.util.ArrayList;
import java.util.List;
/**
 * 89. Gray Code My Submissions QuestionEditorial Solution
	Total Accepted: 58635 Total Submissions: 162009 Difficulty: Medium
	The gray code is a binary numeral system where two successive values differ in only one bit.
	
	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
	
	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	
	00 - 0
	01 - 1
	11 - 3
	10 - 2
	Note:
	For a given n, a gray code sequence is not uniquely defined.
	
	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	
	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 * @author xianyiye
 * @Date 04/15/2016
 */
public class Solution3 {
	
	//mirror mapping
	public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>() ;
        if(n<1){
        	list.add(0) ;
        
        }else{
        	list.add(0) ;
        	list.add(1) ;
        	populate(list, 1, n) ;
        }
        
        return list ;
    }

	private static void populate(List<Integer> list, int curr, int n) {
		if (curr==n) {
			return;
		}

		int size = list.size();
		for (int i = size - 1; i >= 0; i--) {
			list.add(list.get(i));
		}

		for (int i = 0; i < list.size(); i++) {
			int newVal = list.get(i);
			if (i >= list.size() / 2) {// add 1
				newVal = newVal ^ (1 << (n - curr));
				list.set(i, newVal);
			}
		}

		populate(list, curr+1, n);
	}

	public static void main(String[] args) {
		List<Integer> list = grayCode(0) ;
		for(int num:list){
			System.out.println(num);
		}

	}

}
