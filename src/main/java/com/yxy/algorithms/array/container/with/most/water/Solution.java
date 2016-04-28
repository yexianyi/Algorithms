package com.yxy.algorithms.array.container.with.most.water;
/**
 * 11. Container With Most Water   My Submissions QuestionEditorial Solution
	Total Accepted: 76289 Total Submissions: 220577 Difficulty: Medium
	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	
	Note: You may not slant the container.
 * @author xianyiye
 * @date 04/28/2016
 */
public class Solution {
	
	//from left to right
	public static int maxArea(int[] height) {
        int max = 0;
        
        for(int start=0; start<height.length; start++){
        	for(int end=start+1; end<height.length; end++){
        		int area = (end-start) * Math.min(height[start], height[end]) ;
        		if(area>max){
        			max = area ;
        		}
        	}
        }
		
		return max ;
	}
	

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,5,3,2,6}));
	}

}
