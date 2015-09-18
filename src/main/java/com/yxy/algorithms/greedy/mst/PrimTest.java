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
 *
 * 
 * Time complexity: 
 *
 *
 */

public class PrimTest {
	
	public static int[] PrimMST(int[][] graph){
		int[] edges = new int[graph.length-1] ;
		int num = 0 ;
		int[] vertexArray = new int[graph.length] ;
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
			
			//reverse the searching direction
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
