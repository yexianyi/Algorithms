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
package com.yxy.algorithms.excel.sheet.column.number;

/**
 * 
	171. Excel Sheet Column Number
	 My Submissions 
	Question 
	
	Total Accepted: 55875 Total Submissions: 143073 Difficulty: Easy 
	Related to question Excel Sheet Column Title
	Given a column title as appear in an Excel sheet, return its corresponding column number.
	
	For example:
	    A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 

 * @author Xianyiye
 *	2015/12/19
 */

public class Solution {

	public int titleToNumber(String s) {
		if(s==null || s.length()==0){
			return 0 ;
		}
		
		char[] chars = s.toCharArray() ;
		
		int colNum = 0 ;
		for(int i=0; i<chars.length; i++){
			colNum = colNum*26 + (chars[i]-'A'+1) ;
		}
		
		return colNum ;

	}


}
