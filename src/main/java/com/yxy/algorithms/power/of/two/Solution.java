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
package com.yxy.algorithms.power.of.two;

/**
 * 	Power of Two My Submissions Question
	Total Accepted: 44342 Total Submissions: 132535 Difficulty: Easy
	Given an integer, write a function to determine if it is a power of two.


 * @author xianyiye
 * 2015/12/23
 */

public class Solution {
	
	public boolean isPowerOfTwo(int n) {
		if(n<=0){
            return false ;
        }
        return (n&(n-1)) == 0 ;
    }


}
