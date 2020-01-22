package com.yxy.algorithms.graph.course.schedule;

import java.util.ArrayList;
import java.util.List;

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
 * Copy from:
 * https://leetcode.com/problems/course-schedule/discuss/480820/Simple-Java-DFS
 */
public class Solution2 {

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		
		boolean[] restoredStack = new boolean[numCourses];
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (visited[i])
				continue;
			if (isCycle(visited, restoredStack, i, graph))
				return false;
		}
		return true;
	}

	private static boolean isCycle(boolean[] visited, boolean[] restoredStack, int idx, List<Integer>[] graph) {
		if (restoredStack[idx])
			return true;
		if (visited[idx])
			return false;
		visited[idx] = true;
		restoredStack[idx] = true;
		for (int i = 0; i < graph[idx].size(); i++) {
			if (isCycle(visited, restoredStack, graph[idx].get(i), graph))
				return true;
		}
		restoredStack[idx] = false;
		return false;
	}

	public static void main(String[] args) {
//		int[][] prerequisites = {{0,1},{0,2},{1,2}} ;
		int[][] prerequisites = { { 1, 3 }, { 3, 4 }, { 4, 2 }, { 2, 1 }, { 5, 3 } };
		System.out.println(canFinish(3, prerequisites));
	}

}
