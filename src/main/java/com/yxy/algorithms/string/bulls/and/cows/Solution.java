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
package com.yxy.algorithms.string.bulls.and.cows;

/**
 * 	299. Bulls and Cows My Submissions Question
	Total Accepted: 14102 Total Submissions: 51637 Difficulty: Easy
	You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.
	
	For example:
	
	Secret number:  "1807"
	Friend's guess: "7810"
	Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
	Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
	
	Please note that both secret number and friend's guess may contain duplicate digits, for example:
	
	Secret number:  "1123"
	Friend's guess: "0111"
	In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
	You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 * @author xianyiye
 * 2016/1/8
 */

public class Solution {
	
	public static String getHint(String secret, String guess) {
		int[] map = new int[10] ;
		int bull = 0 ; 
		int cow = 0 ;
		
		//init map
		for(int i=0; i<secret.length(); i++){
			map[secret.charAt(i)-48]++ ;
		}
		
		//calculate bull
		for(int i=0; i<guess.length(); i++){
			char sChar = secret.charAt(i) ;
			char gChar = guess.charAt(i) ;
			
			if(sChar==gChar){
				bull++ ;
				map[gChar-48]-- ;
			}
		}
		
		//calculate cow
		for(int i=0; i<guess.length(); i++){
			char sChar = secret.charAt(i) ;
			char gChar = guess.charAt(i) ;
			if(sChar!=gChar){
				if(map[gChar-48]!=0){
					cow++ ;
					map[gChar-48]-- ;
				}
			}
		}
        
		return bull+"A"+cow+"B";
        
    }
	
	

	public static void main(String[] args) {
		System.out.println(getHint("1807","7810")) ; //1A3B
		System.out.println(getHint("1123","0111")) ; //1A1B
		System.out.println(getHint("1122","2211")) ; //0A4B
		System.out.println(getHint("1234","0111")) ; //0A1B
		System.out.println(getHint("1122","1222")) ; //3A0B
		System.out.println(getHint("4123","0111")) ; //1A0B
		
	}

}
