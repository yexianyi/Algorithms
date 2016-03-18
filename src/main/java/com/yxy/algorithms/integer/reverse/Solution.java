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
package com.yxy.algorithms.integer.reverse;
/**
 * 7. Reverse Integer My Submissions Question
	Total Accepted: 116475 Total Submissions: 495593 Difficulty: Easy
	Reverse digits of an integer.
	
	Example1: x = 123, return 321
	Example2: x = -123, return -321
	
	click to show spoilers.
	
	Have you thought about this?
	Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
	
	If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
	
	Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
	
	For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * @author xianyiye
 * 2016/1/13
 */

public class Solution {
	
	public static int reverse(int x) {
        long num = 0;
        
        while(x>0 && x%10==0){
        	x /=10 ;
        }
        
        while(x!=0){
        	num = num * 10 + x%10  ;
        	if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE){
        		num = 0;
        		break ;
        	}
        	
        	x /=10 ;
        }
        
		return (int)num ; //DO NOT USE Long.valueOf(num).intValue(), because of low performance
    }

	public static void main(String[] args) {
		System.out.println(reverse(100));
		System.out.println(reverse(123));
		System.out.println(reverse(1534236469));
		System.out.println(reverse(-2147483648));
		
	}

}
