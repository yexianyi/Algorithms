package com.yxy.algorithms.graph.course.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
