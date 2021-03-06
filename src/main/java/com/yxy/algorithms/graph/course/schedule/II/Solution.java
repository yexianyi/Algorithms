package com.yxy.algorithms.graph.course.schedule.II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 210. Course Schedule II
Medium
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 * @author Ye Xianyi
 * 2020/07/01
 * 
 */
public class Solution {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		if(prerequisites.length == 0) {
			int[] order = new int[numCourses] ;
			for(int i=0; i<order.length ; i++) {
				order[i] = i ;
			}
			
			return order ;
		}
		
		boolean[][] matrix = new boolean[numCourses][numCourses] ;
		// init matrix
		for(int i=0; i<prerequisites.length; i++) {
			int course = prerequisites[i][0] ;
			int prereq = prerequisites[i][1] ;
			matrix[course][prereq] = true ;
		}
		
		for(int i=0; i<matrix.length; i++) {
			matrix[i][i] = true ;
		}
		
		// locate start course
		int start = -1 ;
		for(int i=0; i<matrix.length; i++) {
			boolean hasPreCourse = false ;
			for(int j=0; j<matrix.length; j++) {
				if(matrix[i][j] && i!=j) {
					hasPreCourse = true ;
					break ;
				}
			}
			
			if(!hasPreCourse) {
				start = i ;
			}
		}
		
		if(start == -1) { // has circuit, so impossible
			return new int[0] ;
		}
		
		Set<Integer> set = new HashSet<>() ;
		Set<Integer> temp = new HashSet<>() ;
		set.add(start) ;
		List<Integer> orderList = new ArrayList<>(numCourses) ;
		
		while(!set.isEmpty()) {
			int studyCourse = set.iterator().next() ;
			set.remove(studyCourse) ;
			orderList.add(studyCourse) ;
			temp.add(studyCourse) ;
			
			for(int i=0; i<matrix[studyCourse].length; i++) {
				if(matrix[i][studyCourse] && i!=studyCourse) {
					set.add(i) ;
				}
			}
		}
		
		for(int i=0; i<numCourses; i++) {
			if(!temp.contains(i)) {
				orderList.add(i) ;
			}
		}
		return orderList.stream().mapToInt(Integer::valueOf).toArray();
	}

	public static void main(String[] args) {
//		int[] result = findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}) ;
//		int[] result = findOrder(2, new int[][]{{1,0}}) ;
//		int[] result = findOrder(2, new int[][]{}) ;
		int[] result = findOrder(3, new int[][]{{1,0}}) ;
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + " ") ;
		}
	}

}
