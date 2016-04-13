package com.yxy.algorithms.buy.sell.stock.with.cooldown;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown My Submissions QuestionEditorial Solution
	Total Accepted: 13140 Total Submissions: 35878 Difficulty: Medium
	Say you have an array for which the ith element is the price of a given stock on day i.
	
	Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
	
	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
	Example:
	
	prices = [1, 2, 3, 0, 2]
	maxProfit = 3
	transactions = [buy, sell, cooldown, buy, sell]

 * @author xianyiye
 * @date 04/13/2016
 */
public class Solution {
	
	public int maxProfit(int[] prices) {
		if(prices==null || prices.length==0){
			return 0 ;
		}
		
		int[] sell_profits = new int[prices.length] ;// the total profit can earn at ith day if sell the stacks.
		int[] cool_profits = new int[prices.length] ;// the total profit can earn at ith day if cooldown.
		
		sell_profits[0] = 0 ;
		cool_profits[0] = 0 ;
		
		for(int i=1; i<prices.length; i++){
			// ith day max total sell profit = max (ith day sell profit + (i-1)th day total sell profit, (i-1)th day cooldown total profit);
			sell_profits[i] = Math.max(sell_profits[i-1]+prices[i]-prices[i-1], cool_profits[i-1]) ;
			// ith day max total cooldown profit = max ((i-1)th day sell total profit, (i-1)th day cooldown total profit);
			cool_profits[i] = Math.max(sell_profits[i-1], cool_profits[i-1]) ;
		}
		
		return Math.max(sell_profits[prices.length-1], cool_profits[prices.length-1]);
        
    }

	

	public static void main(String[] args) {
		System.out.println(new Solution().maxProfit(new int[]{1,2,3,0,2})) ;
	}

}
