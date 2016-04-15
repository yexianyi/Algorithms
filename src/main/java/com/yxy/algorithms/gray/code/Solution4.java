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
 * Copy from:
 * https://leetcode.com/discuss/93091/simplest-fastest-easiest-solution
 */
public class Solution4 {
	
	//Formula mapping
	public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>() ;
        
        int count = (int) Math.pow(2, n) ;
        for(int i=0; i<count; i++){
        	//G：gray code B：binary
        	//G(N) = (B(n)/2) XOR B(n) == (B(n)>>1 ^ B(n))
        	list.add((i>>1)^i) ;
        }
        
        return list ;
    }


	public static void main(String[] args) {
		List<Integer> list = grayCode(2) ;
		for(int num:list){
			System.out.println(num);
		}

	}

}
