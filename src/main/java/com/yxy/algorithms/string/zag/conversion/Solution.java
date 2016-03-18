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
package com.yxy.algorithms.string.zag.conversion;

/**
 * 	6. ZigZag Conversion My Submissions Question
	Total Accepted: 71276 Total Submissions: 312054 Difficulty: Easy
	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	
	P   A   H   N
	A P L S I I G
	Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"
	Write the code that will take a string and make this conversion given a number of rows:
	
	string convert(string text, int nRows);
	convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author xianyiye
 * 2016/1/13
 */

public class Solution {
	
    public String convert(String s, int numRows) {
    	 if(s == null || s.length()==0 || numRows <=0)  
             return "";  
         if(numRows == 1)  
             return s;
             
         StringBuilder res = new StringBuilder();  
         int size = 2*numRows-2;  
         for(int i=0;i<numRows;i++){  
             for(int j=i;j<s.length();j+=size){  
                 res.append(s.charAt(j));  
                 if(i != 0 && i != numRows - 1){//except the first row and the last row
                     int temp = j+size-2*i;
                     if(temp<s.length())
                         res.append(s.charAt(temp));
                 }
             }                  
         }  
         return res.toString();  
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
