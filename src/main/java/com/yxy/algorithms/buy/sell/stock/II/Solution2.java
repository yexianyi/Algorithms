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
public class Solution2 {
	
	public static int maxProfit(int[] prices) {
        int profit = 0; 
        for(int i=0, j=0; j<prices.length; j++){
        	if(j==prices.length-1){
        		profit += prices[j] - prices[i] ;
        	}
        	else if(prices[j+1]<prices[j]){
        		profit += prices[j] - prices[i] ;
        		i = j+1 ;
        	}
        	
        }
		
		return profit ;
    }

	public static void main(String[] args) {
		int[] prices = {10,15,5,20} ;
		System.out.println(maxProfit(prices));
	}

}
