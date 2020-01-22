package com.yxy.algorithms.graph.course.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. Course Schedule
	Medium
	There are a total of n courses you have to take, labeled from 0 to n-1.
	
	Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	
	Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	
	Example 1:
	
	Input: 2, [[1,0]] 
	Output: true
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0. So it is possible.
	Example 2:
	
	Input: 2, [[1,0],[0,1]]
	Output: false
	Explanation: There are a total of 2 courses to take. 
	             To take course 1 you should have finished course 0, and to take course 0 you should
	             also have finished course 1. So it is impossible.
	Note:
	
	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	You may assume that there are no duplicate edges in the input prerequisites.
 * @author Ye Xianyi
 * 2020/01/22
 * 
 */
public class Solution {
	
	//timeout
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>() ;
		
		//init graph
		for(int[] prerequisite : prerequisites){
			int key = prerequisite[0] ;
			int preCourse = prerequisite[1] ;
			if(graph.containsKey(key)){
				graph.get(key).add(preCourse) ;
			}else{
				List<Integer> preList = new ArrayList<Integer>() ;
				preList.add(preCourse) ;
				graph.put(key, preList) ;
			}
		}
		
		for(int i=0; i<numCourses; i++){
			if(!dfsTravel(graph, i, new ArrayList<Integer>())){
				return false ;
			}
		}
		
		return true ;
	}

	private static boolean dfsTravel(Map<Integer, List<Integer>> graph, int course, List<Integer> path) {
		if(path.contains(course)){
			return false ;
		}
		
		path.add(course) ;
		List<Integer> preCourses = graph.get(course) ;
		if(preCourses!=null){
			for(Integer preCourse : preCourses){
				if(!dfsTravel(graph, preCourse, path)){
					return false ;
				}
			}
		}
		path.remove(path.size()-1) ;
		return true;
	}

	public static void main(String[] args) {
		int[][] prerequisites = {{0,1},{0,2},{1,2}} ;
		System.out.println(canFinish(3, prerequisites)) ;
	}

}
