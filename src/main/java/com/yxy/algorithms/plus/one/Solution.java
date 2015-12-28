package com.yxy.algorithms.plus.one;

/**
 * 
	66. Plus One
	 My Submissions 
	Question 
	
	Total Accepted: 78271 Total Submissions: 245244 Difficulty: Easy 

	Given a non-negative number represented as an array of digits, plus one to the number.

	The digits are stored such that the most significant digit is at the head of the list.

 * @author xianyiye
 * 2015/12/28
 */

public class Solution {
	
	public static int[] plusOne(int[] digits) {
		for(int i=digits.length-1; i>=0; i--){
			digits[i]++ ;
			if(digits[i]==10 && i!=0){
				digits[i] = 0;
				continue ;
			}
			
			break ;
		}
		
		int[] result = null ;
		if(digits[0]>9){
			digits[0] -= 10 ;
			result = new int[digits.length+1] ;
			result[0] = 1 ;
			for(int i=0; i<digits.length; i++){
				result[i+1] = digits[i] ;
			}
		}else{
			result = digits ;
		}
		
		return result ;
    }

	public static void main(String[] args) {
		
		for(int num : plusOne(new int[]{9,9,9,9})){
			System.out.print(num) ;
		}

	}

}
