package com.yxy.algorithms.array.trapping.rain.water;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
	The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
	
	Example:
	Input: [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6

 * 
 * @author Ye Xianyi
 * 2018/6/6
 * 
 * Reference:
 * https://www.bilibili.com/video/av18241289/
 */

public class Solution {
	
	
    public static int trap(int[] height) {
        int sum = 0;
    	int lmax = 0 ;
    	int rmax = 0 ;
    	int l = 0; 
    	int r = height.length-1 ;
    	
    	while(l<r) {
    		lmax = Math.max(lmax, height[l]) ;
    		rmax = Math.max(rmax, height[r]) ;
    		
    		if(lmax<rmax) {
    			sum += lmax - height[l++] ;
    		}else {
    			sum += rmax - height[r--] ;
    		}
    	}
    	
    	return sum ;
    }
	

	public static void main(String[] args) {
		System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}

}
