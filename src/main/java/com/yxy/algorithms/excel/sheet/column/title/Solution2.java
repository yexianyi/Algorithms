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
package com.yxy.algorithms.excel.sheet.column.title;

/**
 * 	168. Excel Sheet Column Title My Submissions Question
	Total Accepted: 49052 Total Submissions: 240758 Difficulty: Easy
	Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	
	For example:
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
 * @author xianyiye
 * 2016/1/19
**/

public class Solution2 {
	
	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
        while(n--!=0){
            sb.append((char)(n%26+'A'));
            n/=26;
        }
        return sb.length()==0?"A":sb.reverse().toString();
        
    }

	public static void main(String[] args) {
		System.out.println(convertToTitle(26)) ;
		System.out.println(convertToTitle(27)) ;
		System.out.println(convertToTitle(28)) ;
		System.out.println(convertToTitle(54)) ;
	}

}
