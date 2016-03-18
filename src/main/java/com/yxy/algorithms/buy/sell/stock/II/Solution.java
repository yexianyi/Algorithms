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
package com.yxy.algorithms.buy.sell.stock.II;
/**
 * 	122. Best Time to Buy and Sell Stock II My Submissions Question
	Total Accepted: 74581 Total Submissions: 181951 Difficulty: Medium
	Say you have an array for which the ith element is the price of a given stock on day i.
	
	Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
	transactions at the same time (ie, you must sell the stock before you buy again).
 * @author xianyiye
 * 2016/1/25
 */

public class Solution {
	
	public static int maxProfit(int[] prices) {
        int profit = 0; 
        for(int i=0; i+1<prices.length; i++){
        	if(prices[i]<prices[i+1]){
        		profit += prices[i+1] - prices[i] ;
        	}
        }
		
		return profit ;
    }

	public static void main(String[] args) {
		
	}

}
