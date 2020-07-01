package com.yxy.algorithms.graph.course.schedule.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
 * Reference:
 * https://leetcode.com/problems/course-schedule-ii/solution/
 * 
 */
public class Solution2 {

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Queue<Integer> queue = new LinkedList<>() ; // store all Zero in-degree nodes
		Map<Integer, List<Integer>> adjList = new HashMap<>() ; // record IN node for each node
		int[] inDegrees = new int[numCourses] ;
		int[] res = new int[numCourses] ;
		
		for(int i=0; i<prerequisites.length; i++) {
		    int source = prerequisites[i][0] ;
		    int pre = prerequisites[i][1] ;
		    List<Integer> list = adjList.getOrDefault(pre, new ArrayList<>()) ;
		    list.add(source) ;
		    adjList.put(pre, list) ;
		    
		    inDegrees[source]++ ;
		}
		
		// pull all zero in-degree nodes to the queue
		for(int i=0; i<numCourses; i++) {
		    if(inDegrees[i] == 0) {
		        queue.add(i) ;
		    }
		}
		
		// pop the node from stack until it is empty
		int resPos = 0;
		while(!queue.isEmpty()) {
		    int currCourse = queue.poll() ;
		    res[resPos++] = currCourse ;
		    // assume currCourse is learned, 
		    // so the IN Degree of each course conducted by it should be reduce 1.
		    if(adjList.containsKey(currCourse)) {
		        for(int course : adjList.get(currCourse)) { 
		            inDegrees[course] -- ;
		            
		            if(inDegrees[course] == 0) {
		                queue.add(course) ;
		            }
		        }
		    }
		}
		
		
		if(resPos == numCourses) {
		    return res ;
		}
		
		return new int[0];
		
	}

	public static void main(String[] args) {
		int[] result = findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}) ;
//		int[] result = findOrder(2, new int[][]{{1,0}}) ;
//		int[] result = findOrder(2, new int[][]{}) ;
//		int[] result = findOrder(3, new int[][]{{1,0}}) ;
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + " ") ;
		}
	}

}
