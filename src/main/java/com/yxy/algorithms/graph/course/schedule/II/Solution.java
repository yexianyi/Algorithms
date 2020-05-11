package com.yxy.algorithms.graph.course.schedule.II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
