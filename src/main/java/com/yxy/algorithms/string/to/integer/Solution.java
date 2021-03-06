/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.string.to.integer;
/**
 * 	8. String to Integer (atoi) My Submissions Question
	Total Accepted: 83515 Total Submissions: 632219 Difficulty: Easy
	Implement atoi to convert a string to an integer.
	
	Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
	
	Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
	
	Update (2015-02-10):
	The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
	
	spoilers alert... click to show requirements for atoi.
	
	Requirements for atoi:
	The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
	
	The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
	
	If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
	
	If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * @author xianyiye
 * 2016/1/19
 */
public class Solution {

	public static int myAtoi(String str) {
		
		long sum = 0;
		int sign = 1 ;
		boolean start = false ;
		for(int i=0; str!=null && i<str.length(); i++){
			int ch = str.charAt(i) ;
					
			if(ch==' '){
				if(start){
					break ;
				}else{
					continue ;
				}
			}
			
			else if(ch=='+' || ch=='-'){
				if(start){
					break ;
				}else{
					start = true ;
					sign = ch=='+'? 1 : -1 ;
				}
			}
			
			else if(ch>='0' && ch<='9'){
				start = true ;
				int num = (ch - '0') * sign ;
        		sum = 10*sum + num ;
    			if(sum<Integer.MIN_VALUE){
    				return Integer.MIN_VALUE ;
    			}
    			if(sum>Integer.MAX_VALUE){
    				return Integer.MAX_VALUE ;
    			}
			}
			
			else{
				break ;
			}
		}//end for
			
	        
		return (int)sum;
    }

	public static void main(String[] args) {
		System.out.println(myAtoi(null));
		System.out.println(myAtoi("   +1"));
		System.out.println(myAtoi("+1"));
		System.out.println(myAtoi("+010"));
		System.out.println(myAtoi("+-2"));
		System.out.println(myAtoi("-111111111111111"));
		System.out.println(myAtoi("1111111111111111"));
		System.out.println(myAtoi("-1234"));
		System.out.println(myAtoi("-fwef"));
	}

}
