package com.yxy.algorithms.bulb.switcher;

/**
 * @author xianyi ye
 * @Date 3/26/2016
 * 
 * 319. Bulb Switcher My Submissions Question
Total Accepted: 14463 Total Submissions: 36146 Difficulty: Medium
There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Given n = 3. 

At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off]. 

So you should return 1, because there is only one bulb is on.

 */

public class Solution {

	public static int bulbSwitch(int n) {
		if(n==0){
			return 0 ;
		}
		
		int max = 3 ;
		int temp = max ;
		int num = 1 ;
		while(n>max){
			max += temp + 2 ;
			temp += 2 ;
			num++ ;
		}
		
		return num ;

	}

	public static void main(String[] args) {
		for(int i=1; i<=25; i++){
			System.out.println(i+":"+bulbSwitch(i));
		}

	}

}
