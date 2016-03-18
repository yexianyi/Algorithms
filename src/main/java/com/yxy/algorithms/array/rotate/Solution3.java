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
package com.yxy.algorithms.array.rotate;

/**
 * 	189. Rotate Array My Submissions Question
	Total Accepted: 57478 Total Submissions: 286689 Difficulty: Easy
	Rotate an array of n elements to the right by k steps.
	
	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
	
	Note:
	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
	
	[show hint]
	
	Hint:
	Could you do it in-place with O(1) extra space?
	Related problem: Reverse Words in a String II


 * @author xianyiye
 * 2016/1/19
 */
public class Solution3 {

	public static void rotate(int[] nums, int k) {
		  int n = nums.length;
	        int[] newList = new int[n];
	        if (n > 1) {
	            k = k % n;
	            System.arraycopy(nums, n - k, newList, 0, k);
	            System.arraycopy(nums, 0, newList, k, n - k);
	            System.arraycopy(newList, 0, nums, 0, n);
	        }
	}


	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);

		for (int num : nums) {
			System.out.print(num + " ");
		}

	}

}
