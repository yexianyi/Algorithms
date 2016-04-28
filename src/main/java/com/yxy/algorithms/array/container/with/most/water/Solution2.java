package com.yxy.algorithms.array.container.with.most.water;
/**
 * 11. Container With Most Water   My Submissions QuestionEditorial Solution
	Total Accepted: 76289 Total Submissions: 220577 Difficulty: Medium
	Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	
	Note: You may not slant the container.
 * @author xianyiye
 * @date 04/28/2016
 * Reference:
 * https://leetcode.com/discuss/78437/java-3ms-solution-with-step-by-step-explanations-beats-85%25
 * https://leetcode.com/discuss/59635/easy-concise-java-o-n-solution-with-proof-and-explanation
 */
public class Solution2 {
	
	//from left to right
	public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1 ;
        
        while(left<right){
        	int max_left = left ;
        	int max_right = right ;
        	int min_height = Math.min(height[left], height[right]) ;
        	max = Math.max(max, min_height*(right-left)) ;
        	
        	if(height[left]<=height[right]){
        		while(left<right && height[left]<=height[max_left]){
        			left++ ;
        		}
        	}else{
        		while(right>left && height[right]<=height[max_right]){
        			right-- ;
        		}
        	}
        }
        
		return max ;
	}
	

	public static void main(String[] args) {
		System.out.println(maxArea(new int[]{1,5,3,2,6}));
	}

}
