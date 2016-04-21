package com.yxy.algorithms.parentheses.add;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 241. Different Ways to Add Parentheses   My Submissions QuestionEditorial Solution
	Total Accepted: 20562 Total Submissions: 59323 Difficulty: Medium
	Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
	
	
	Example 1
	Input: "2-1-1".
	
	((2-1)-1) = 0
	(2-(1-1)) = 2
	Output: [0, 2]
	
	
	Example 2
	Input: "2*3-4*5"
	
	(2*(3-(4*5))) = -34
	((2*3)-(4*5)) = -14
	((2*(3-4))*5) = -10
	(2*((3-4)*5)) = -10
	(((2*3)-4)*5) = 10
	Output: [-34, -14, -10, -10, 10]
 * @author xianyiye
 * @date 04/21/2016
 * Copy from:
 * https://leetcode.com/discuss/97307/java-simple-solution-beats-95%25
 */
public class Solution2 {
	
	Map<String, List<Integer>> map = new HashMap<>();
	
	//DP
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)){
        	return map.get(input);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<input.length();++i){
            char c=input.charAt(i);
            if(c=='+'|| c=='-' || c=='*'){
                List<Integer> leftSet = diffWaysToCompute(input.substring(0,i));
                List<Integer> rightSet = diffWaysToCompute(input.substring(i+1));
                for(int left:leftSet){
                    for(int right: rightSet){
                        if(c=='+')
                            res.add(left+right);
                        if(c=='-')
                            res.add(left-right);
                        if(c=='*')
                            res.add(left*right);
                    }
                }
            }
        }
        
        if(res.isEmpty()){
        	res.add(Integer.parseInt(input));
        }
        map.put(input, res);
        
        return res;
    }

	public static void main(String[] args) {
		List<Integer> results = new Solution2().diffWaysToCompute("2*3-4*5") ;//2*3-4*5
		for(Integer result : results){
			System.out.println(result);
		}
	}

}
