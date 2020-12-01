package com.yxy.algorithms.string.min.remove.to.make.valid.parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

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
        
        while(i < left.size()) {
            rmList.add(left.get(j++));
        }
        
        while(j < right.size()) {
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
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

}
