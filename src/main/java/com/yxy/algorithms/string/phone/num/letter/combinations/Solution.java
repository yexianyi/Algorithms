package com.yxy.algorithms.string.phone.num.letter.combinations;

import java.util.ArrayList;
import java.util.List;
/**
 * 17. Letter Combinations of a Phone Number My Submissions QuestionEditorial Solution
	Total Accepted: 84959 Total Submissions: 288900 Difficulty: Medium
	Given a digit string, return all possible letter combinations that the number could represent.
	
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.
 * @author xianyiye
 * @date 06/24/2016
 */
public class Solution {
	
	
	public static List<String> letterCombinations(String digits) {
		List<String[]> inputs = new ArrayList<String[]>()  ;
//		for(char digital : digits.toCharArray()){
		for(int i=0; i<digits.length(); i++){
			char digital = digits.charAt(i) ;
			switch(digital){
				case '2' : inputs.add(new String[]{"a","b","c"}) ; break ;
				case '3' : inputs.add(new String[]{"d","e","f"}) ; break ;
				case '4' : inputs.add(new String[]{"g","h","i"}) ; break ;
				case '5' : inputs.add(new String[]{"j","k","l"}) ; break ;
				case '6' : inputs.add(new String[]{"m","n","o"}) ; break ;
				case '7' : inputs.add(new String[]{"p","q","r", "s"}) ; break ;
				case '8' : inputs.add(new String[]{"t","u","v"}) ; break ;
				case '9' : inputs.add(new String[]{"w","x","y","z"}) ; break ;
				
				default: 
			}
		}
		
		
        List<String> ret = new ArrayList<String>() ;
        if(inputs.size()>0){
        	findCombination(inputs, 0, 0, new StringBuilder(), ret) ;
        }
        
        return ret ;
    }

	private static void findCombination(List<String[]> inputs, int currListIdx, int currIdx, StringBuilder currStrBuilder, List<String> ret) {
		if(currListIdx==inputs.size()){
			ret.add(currStrBuilder.toString()) ;
			return ;
		}
		
		String[] array = inputs.get(currListIdx) ;
		for(int i=0; i<array.length; i++){
			findCombination(inputs, currListIdx+1, i, currStrBuilder.append(array[i]), ret) ;
			currStrBuilder.deleteCharAt(currStrBuilder.length()-1) ;
		}
			
		
	}

	public static void main(String[] args) {
		for(String combination : letterCombinations("2")){ //"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
			System.out.print(combination+" ") ;
		}

	}

}
