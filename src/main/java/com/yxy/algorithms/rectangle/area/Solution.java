package com.yxy.algorithms.rectangle.area;

/**
 * 	223. Rectangle Area My Submissions Question
	Total Accepted: 26700 Total Submissions: 93949 Difficulty: Easy
	Find the total area covered by two rectilinear rectangles in a 2D plane.
	
	Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
	
	Rectangle Area
	Assume that the total area is never beyond the maximum possible value of int.
 * @author xianyiye
 * 2016/1/5
 */

public class Solution {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (A >= G || E >= C || B >= H || F >= D)
			return (C - A) * (D - B) + (G - E) * (H - F);
		int x1 = Math.max(A, E);
		int y1 = Math.max(B, F);
		int x2 = Math.min(C, G);
		int y2 = Math.min(D, H);
		return (C - A) * (D - B) + (G - E) * (H - F) - (x2 - x1) * (y2 - y1);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
