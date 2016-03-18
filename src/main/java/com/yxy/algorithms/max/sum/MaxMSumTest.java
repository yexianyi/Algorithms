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
package com.yxy.algorithms.max.sum;

public class MaxMSumTest {
	/**
	 * @author xianyi ye
	 * @Date 8/6/2015
	 * 
	 * Question:
	 * There is an integer array, such as -1, 4, -2, 3, -2, 3.
	 * Please write an function to calculate max sum of M parts,
	 * Each of parts are not continuous.
	 * In this example, the max sum is 8 which is composite with 4,-2,3,3
	 * or 4,3,-2,3 
	 * 
	 * Solution:
	 * If m==1, this issue is absolutely same with maximum subarray problem.
	 * So, let's consider this simplest case first.
	 * Suppose f(i) = the max sum value of the sub-array which is end with a[i].
	 * Therefore, f(i) = max{f(i-1)+a[i]}
	 * 
	 * Similar, if the max sum of an array contains M parts. Then, 2 situations
	 * can be found. 
	 * (Assume a[j] is the last item of the Mst part.
	 * dp[i][j] is the max sum value of "i" parts which is end with a[j])
	 * 
	 * 1. a[j] is included in the "i"st part.
	 * For example, -1, (4), -2, (3, -2, 3)
	 * then, dp[i][j] = dp[i][j-1] + a[j]
	 * 
	 * 2. a[j] is not included in the "i"st part.
	 * For example, -1, (4, -2, 3), -2, (3)
	 * In this case, a[j] has to be the "i"st part alone.
	 * Then, the max sum of "i" parts of array must be combined with 
	 * "i-1" parts and a[j]. In other words, a[j] is the "i"st part.
	 * Therefore, dp[i][j] = max{dp[i-1][k]+a[j]}
	 * i-1<=k<j, because we only know a[j] is the last part of the array,
	 * but we do not know which item is the last element of "i-1" parts.
	 * So, we need use an loop to find it. Additionally, since that is
	 * impossible that divide an array that contains "j" elements into
	 * more than "j" parts, k must lower than or equals to i-1 here,
	 * whilst, k can not also beyond to the length of the array.
	 * 
	 * In summary, the formula should be 
	 * dp[i][j] = max{dp[i][j-1]+a[j], max{dp[i-1][k]+a[j]}   (i-1<=k<n-m+i)
	 * n: the length of the whole array
	 * m: the parts need to be split out.
	 * n-m+i: the starter of the index of K.
	 * 
	 * T(n) = O(m*n^2)
	 * 
	 * Reference:
	 * http://www.haodaima.net/art/2006906
	 * 
	 */
	
	public static int MaxMSum(int nums[], int m){
		int[][] dp = new int[m+1][nums.length] ;
		
		for(int i=1; i<=m ; i++){
			for(int j = i ; j<nums.length-m+i; j++){
				if(j!=i){
					dp[i][j] = dp[i][j-1] + nums[j] ;
					for(int k= i-1; k<j ; k++){
						if(dp[i-1][k]+nums[j] > dp[i][j]){
							dp[i][j] = dp[i-1][k]+nums[j] ;
						}
					}
				}else{
					dp[i][j] = dp[i-1][j-1]+nums[j] ;
				}
			}
		}
		
		int sum = 0 ;
		for(int j = m; j<nums.length; j++){
			if(sum < dp[m][j]){
				sum = dp[m][j] ;
			}
		}
		
		return sum ;
	}

	public static void main(String[] args) {
		int[] nums = {-1, 4, -2, 3, -2, 3} ;
		System.out.println(MaxMSum(nums, 2));

	}

}
