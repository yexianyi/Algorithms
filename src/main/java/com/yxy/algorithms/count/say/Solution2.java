package com.yxy.algorithms.count.say;

/**
 * 	38. Count and Say My Submissions Question
	Total Accepted: 66543 Total Submissions: 244222 Difficulty: Easy
	The count-and-say sequence is the sequence of integers beginning as follows:
	1, 11, 21, 1211, 111221, ...
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth sequence.
	
	Note: The sequence of integers will be represented as a string.
 * @author xianyiye
 * 2016/1/8
 */

public class Solution2 {
	
	public static String countAndSay(int n) {
        String nums = "1" ;
        
        while(n-->1){
        	StringBuffer sb = new StringBuffer();
        	char[] array = nums.toCharArray() ;
        	
        	char target = nums.charAt(0) ;
        	int count = 0;

        	for(int i=0; i<array.length;){
        		if(array[i]==target){
        			count++ ;
        			if(i==array.length-1){
        				sb.append(count).append(target) ;
        			}
        			i++ ;
        		}
        		else{
        			sb.append(count).append(target) ;
        			target = array[i] ;
        			count = 0 ;
        		}
        	
        	
        	}//end for
        	
        	nums = sb.toString() ;
        	
        }
        
		return nums ;
    }
	
	
	public static void main(String[] args) {
		System.out.println(countAndSay(1)) ;
		System.out.println(countAndSay(2)) ;
		System.out.println(countAndSay(3)) ;
		System.out.println(countAndSay(4)) ;
		System.out.println(countAndSay(5)) ;

	}

}
