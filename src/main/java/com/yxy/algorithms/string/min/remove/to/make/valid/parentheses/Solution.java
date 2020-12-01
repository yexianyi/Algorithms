package com.yxy.algorithms.string.min.remove.to.make.valid.parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 1249. Minimum Remove to Make Valid Parentheses
	Medium
	
	Given a string s of '(' , ')' and lowercase English characters. 
	
	Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
	
	Formally, a parentheses string is valid if and only if:
	
	It is the empty string, contains only lowercase characters, or
	It can be written as AB (A concatenated with B), where A and B are valid strings, or
	It can be written as (A), where A is a valid string.
	 
	
	Example 1:
	
	Input: s = "lee(t(c)o)de)"
	Output: "lee(t(c)o)de"
	Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
	Example 2:
	
	Input: s = "a)b(c)d"
	Output: "ab(c)d"
	Example 3:
	
	Input: s = "))(("
	Output: ""
	Explanation: An empty string is also valid.
	Example 4:
	
	Input: s = "(a(b(c)d)"
	Output: "a(b(c)d)"
	 
	
	Constraints:
	
	1 <= s.length <= 10^5
	s[i] is one of  '(' , ')' and lowercase English letters.
 * @author Ye Xianyi
 * 2020/12/01
 *
 */
public class Solution {

	//  faster than 13.69%
    public static String minRemoveToMakeValid(String s) {
        Map<Integer, Integer> left = new HashMap<>() ;
        Map<Integer, Integer> right = new HashMap<>() ;
        List<Integer> leftList = new ArrayList<>() ;
        List<Integer> rightList = new ArrayList<>() ;
        
        int _lIdx = 0, _rIdx = 0 ;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left.put(_lIdx++, i) ;
                leftList.add(i) ;
            } else if(s.charAt(i) == ')') {
                right.put(_rIdx++, i) ;
                rightList.add(i) ;
            }
        }
        
        Set<Integer> rmList = new HashSet<>() ;
        int i = 0, j = 0 ;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) > rightList.get(j)) {
                rmList.add(right.get(j++));
                continue ;
            } else {
                i++ ;
                j++ ;
            }
        }
        
        while(i < leftList.size()) {
            rmList.add(left.get(i++));
        }
        
        while(j < rightList.size()) {
            rmList.add(right.get(j++));
        }
        
        StringBuffer sb = new StringBuffer() ;
        for(int k=0; k<s.length(); k++) {
            if(rmList.contains(k)) {
                continue ;
            } else {
                sb.append(s.charAt(k)) ;
            }
        }
        
        return sb.toString() ;
    }

    
    
    
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

}
