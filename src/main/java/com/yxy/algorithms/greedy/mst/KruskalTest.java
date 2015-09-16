package com.yxy.algorithms.greedy.mst;
/**
 * 
 * @author xianyiye
 * @Date 9/16/2015
 * 
 * Requirement:
 * Develop a program to generate the Minimum spanning tree (MST) according following undirected graph.
 * int[][] graph = 	{{0,  -1, -1, -1, -1, -1, -1, -1},
					 {6,   0, -1, -1, -1, -1, -1, -1},
					 {12,  5,  0, -1, -1, -1, -1, -1},
					 {-1, -1,  9,  0, -1, -1, -1, -1},
					 {-1, 14, -1, -1,  0, -1, -1, -1},
					 {-1, -1,  7, -1, -1,  0, -1, -1},
					 {-1, -1, -1, -1, -1, 15,  0, -1},
					 {-1,  8, -1, -1,  3, 10, -1,  0},
		} ;
 * 
 * 
 * Solution:
 * 1. Sort all the edges by weight (from smaller to bigger)
 * 2. Check the sorted edges one by one
 * 3. If there is no circuit after choose an edge candidate by comparing the number of selected edges and nodes,
 * 	  then current edge will be chose.
 * 4. Otherwise, current edge will be ignored and repeat step 2 and 3 for the next edge candidate.
 * 
 * Time complexity: O(E*log(V))
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

public class KruskalTest {
	
	public static Edge[] kruskalMap(int[][] graph){
		Edge[] sortedEdges = sortEdges(graph) ; //sort all the edges by weight
		int[] connectedNodes = new int[graph.length] ; //record the chose nodes
		Edge[] selectedEdges = new Edge[graph.length-1] ;//store the chose edges
		int connectedNodesCount = 0 ; //counter: the number of nodes which have been chosen
		int selectedEdgesCount = 0 ; //counter: the number of edges which have been chosen
		
		int j = 0 ;
		for(int i=0; i<sortedEdges.length; i++){
			Edge e = sortedEdges[i] ;
			int sum = connectedNodes[e.from] + connectedNodes[e.to] ;
			
			if(sum == 2){ //current two nodes have been chosen by other edges, but it doesn't mean these 2 nodes are connected for sure.
				if(!checkExistCircuit(connectedNodesCount, selectedEdgesCount+1)){
					selectedEdges[j++] = e ; //make this edge into chosen
					selectedEdgesCount++ ;
				}
			}else if(sum == 1){ //One of two nodes has not been connected yet.
				if(!checkExistCircuit(connectedNodesCount+1, selectedEdgesCount+1)){
					connectedNodes[e.from] = 1 ; //mark this node as has been visited by a edge.
					connectedNodes[e.to] = 1 ; //mark this node as has been visited by a edge.
					selectedEdges[j++] = e ; //this edge has been chosen.
					
					connectedNodesCount++ ;
					selectedEdgesCount++ ;
				}
				
			}else{ // connectedNodes[e.from] + connectedNodes[e.to]==0; Both of the two nodes has not been connected yet.
				if(!checkExistCircuit(connectedNodesCount+2, selectedEdgesCount+1)){
					connectedNodes[e.from] = 1 ; //mark this node as has been visited by a edge.
					connectedNodes[e.to] = 1 ; //mark this node as has been visited by a edge.
					selectedEdges[j++] = e ; //make this edge into chosen
					
					connectedNodesCount+=2 ;
					selectedEdgesCount++ ;
				}
				
			}
			
		}
		
		return selectedEdges ;
	}
	

	private static boolean checkExistCircuit(int connectedNodesCount, int selectedEdgesCount) {
		return selectedEdgesCount>=connectedNodesCount ; // if the num of edges >= the num of nodes, then there must be existed an circuit
	}


	private static Edge[] sortEdges(int[][] graph) {
		List<Edge> list = new ArrayList<Edge>() ;
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<i; j++){
				if(graph[i][j]>0){
					Edge e = new Edge() ;
					e.from = i;
					e.to = j ;
					e.weight = graph[i][j] ;
					list.add(e) ;
				}
				
			}
		}
		
		Edge[] edges = list.toArray(new Edge[list.size()]) ;
		quickSort(edges) ;
		return edges ;
	}
	
	
	private static void quickSort(Edge[] arr){
	    qsort(arr, 0, arr.length-1);
	}
	private static void qsort(Edge[] arr, int low, int high){
	    if (low < high){
	        int pivot=partition(arr, low, high);  
	        qsort(arr, low, pivot-1);         
	        qsort(arr, pivot+1, high);              
	    }
	}
	private static int partition(Edge[] arr, int low, int high){
		Edge pivot = arr[low];  
	    while (low<high){
	        while (low<high && arr[high].weight>=pivot.weight) --high;
	        arr[low]=arr[high];             
	        while (low<high && arr[low].weight<=pivot.weight) ++low;
	        arr[high] = arr[low];      
	    }
	   
	    arr[low] = pivot;
	  
	    return low;
	}


	public static void main(String[] args) {
		int[][] graph = {{0,  -1, -1, -1, -1, -1, -1, -1},
						 {6,   0, -1, -1, -1, -1, -1, -1},
						 {12,  5,  0, -1, -1, -1, -1, -1},
						 {-1, -1,  9,  0, -1, -1, -1, -1},
						 {-1, 14, -1, -1,  0, -1, -1, -1},
						 {-1, -1,  7, -1, -1,  0, -1, -1},
						 {-1, -1, -1, -1, -1, 15,  0, -1},
						 {-1,  8, -1, -1,  3, 10, -1,  0},
		} ;
		
		Edge[] map = kruskalMap(graph) ;
		for(Edge edge:map){
			System.out.print(edge.weight + " ");
		}
		
	}
	
	static class Edge {
		public int from ;
		public int to ;
		public int weight ;
		
	}

}
