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
package com.yxy.algorithms.version.compare;

/**
 * 	165. Compare Version Numbers My Submissions Question
	Total Accepted: 42636 Total Submissions: 257225 Difficulty: Easy
	Compare two version numbers version1 and version2.
	If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
	
	You may assume that the version strings are non-empty and contain only digits and the . character.
	The . character does not represent a decimal point and is used to separate number sequences.
	For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
	
	Here is an example of version numbers ordering:
	
	0.1 < 1.1 < 1.2 < 13.37
 * @author xianyiye
 * 2016/1/19
 */
public class Solution2 {

	public static int compareVersion(String version1, String version2) {
		 if (version1 == null || version2 == null) return 0;
	        int v1 = 0, v2 = 0;
	        int i = 0, j = 0;
	        while(i < version1.length() || j < version2.length()) {
	            while (i < version1.length() && version1.charAt(i) != '.') {
	                v1 = v1*10+(version1.charAt(i)-'0');
	                i++;
	            }
	            while (j < version2.length() && version2.charAt(j) != '.') {
	                v2 = v2*10+(version2.charAt(j)-'0');
	                j++;
	            }
	            if (v1 > v2) return 1;
	            else if (v1 < v2) return -1;
	            i++;
	            j++;
	            v1 = 0;
	            v2 = 0;
	        }
	        return 0;
    }

	public static void main(String[] args) {
		System.out.println(compareVersion("1","1.0"));
		System.out.println(compareVersion("01","1"));
		System.out.println(compareVersion("1.3","1.3"));
		System.out.println(compareVersion("1.3","1.2.3"));
		System.out.println(compareVersion("1.1","1.2.3"));
		System.out.println(compareVersion("1.1","1.1.1"));

	}

}
