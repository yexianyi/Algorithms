/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.greedy.mst;
/**
 * 
 * @author xianyiye
 * @Date 9/18/2015
 * 
 * Requirement:
 * Develop a program to generate the Minimum spanning tree (MST) according following undirected graph.
 * int[][] graph = { { 0,  6, 12, -1, -1, -1, -1, -1},
					 {-1,  0,  5, -1, 14, -1, -1,  8},
					 {-1, -1,  0,  9, -1,  7, -1, -1},
					 {-1, -1, -1,  0, -1, -1, -1, -1},
					 {-1, -1, -1, -1,  0, -1, -1,  3},
					 {-1, -1, -1, -1, -1,  0, 15, 10},
					 {-1, -1, -1, -1, -1, -1,  0, -1},
					 {-1, -1, -1, -1, -1, -1,  -1, 0},
		} ;
 * 
 * 
 * Solution:
 * 1. Iterate the graph[i][j] and find out the first number which is greater than ZERO, which means that the two vertexes from i to j are connected.
 * 2. Consider i as the current vertex that is chose into the MST. 
 * 3. Find out which vertexes are connected to existing vertexes in MST by iterating the position from graph[i][0] to graph[i][graph.length] whose number is greater than ZERO.
 * 4. Choose the minimum weight of each edges as the distance of the vertex connects to existing vertexes in MST. Mark the distance on an array and set the distance as ZERO.  
 * 5. Iterate the array to find out the minimum non-zero value and mark the seq of this array as the number of vertex needs to be search in next.
 * 6. Mark above vertex as current vertex and repeat steps 3 to 6 until all the number of the array are ZERO.
 * 7. Iterate MST to display each of edges.
 * 
 * Time complexity: O(n^2)
 *
 *
 */

public class PrimTest {
	
	public static int[] PrimMST(int[][] graph){
		int[] edges = new int[graph.length-1] ;
		int num = 0 ;
		int[] vertexArray = new int[graph.length] ; //Store the distances of each vertex connect to MST. ZERO means current vertex has been chosen into MST.
		for(int i=0; i<vertexArray.length; i++){
			vertexArray[i] = Integer.MAX_VALUE ;
		}
		
		int currVertex = -1 ;
		
		//Search start point
		boolean found = false ;
		for(int i=0; i<graph.length && !found; i++){
			for(int j=i; j<graph.length; j++){
				if(graph[i][j]>0){
					currVertex = i ;
					vertexArray[currVertex] = 0 ;//mark current vertex has been chosen
					found = true ;
					break ;
				}
			}
		}
		
		while(true){
			if(num == graph.length-1){
				break ;
			}
		
			//decrease distance
			for(int j=currVertex; j<graph.length; j++){// Vertex J
				if(graph[currVertex][j]==0){
					continue ;
				}
				int new_distance_j = graph[currVertex][j] ;
				int old_distance_j = vertexArray[j] ;
				if(new_distance_j>0){
					if(old_distance_j > 0 && new_distance_j < old_distance_j){
						vertexArray[j] = new_distance_j ;
					}
				}
			}
			
			//reverse the searching direction, because the searching has already touch the bottom of the upper triangular matrix.
			if(currVertex==graph.length-1){
				for(int i=0; i<graph.length; i++){// Vertex J
					if(graph[i][currVertex]==0){
						continue ;
					}
					int new_distance_j = graph[i][currVertex] ;
					int old_distance_j = vertexArray[i] ;
					if(new_distance_j>0){
						if(old_distance_j > 0 && new_distance_j < old_distance_j){
							vertexArray[i] = new_distance_j ;
						}
					}
				}
			}
			
			//extract minimum distance to a vertex
			int min_distance = Integer.MAX_VALUE ;
			int min_distance_vertex = -1 ;
			for(int i=0; i<vertexArray.length; i++){
				if(vertexArray[i]!=0 && vertexArray[i]<min_distance){
					min_distance = vertexArray[i] ;
					min_distance_vertex = i ;
				}
			}
			
//			System.out.print(min_distance+" ");
			edges[num++] = min_distance ;
			vertexArray[min_distance_vertex] = 0 ;//mark current vertex has been chosen
			currVertex = min_distance_vertex ;
		}//end while
		
		return edges ;
		
	}
	

	
	public static void main(String[] args) {
		int[][] graph = {{ 0,  6, 12, -1, -1, -1, -1, -1},
						 {-1,  0,  5, -1, 14, -1, -1,  8},
						 {-1, -1,  0,  9, -1,  7, -1, -1},
						 {-1, -1, -1,  0, -1, -1, -1, -1},
						 {-1, -1, -1, -1,  0, -1, -1,  3},
						 {-1, -1, -1, -1, -1,  0, 15, 10},
						 {-1, -1, -1, -1, -1, -1,  0, -1},
						 {-1, -1, -1, -1, -1, -1,  -1, 0},
		} ;
		
		int[] edges = PrimMST(graph) ;
		for(int weight:edges){
			System.out.print(weight + " ");
		}
		
	}


}
