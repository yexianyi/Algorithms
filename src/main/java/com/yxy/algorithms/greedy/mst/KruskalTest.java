package com.yxy.algorithms.greedy.mst;

import java.util.ArrayList;
import java.util.List;

public class KruskalTest {
	
	public static Edge[] kruskalMap(int[][] graph){
		Edge[] orderedEdges = orderEdges(graph) ;
		int[] connectedNodes = new int[graph.length] ;
		Edge[] selectedEdges = new Edge[graph.length-1] ;
		
		int j = 0 ;
		for(int i=0; i<orderedEdges.length; i++){
			Edge e = orderedEdges[i] ;
			if(connectedNodes[e.from] == 1 && connectedNodes[e.to] == 1){ //current two nodes have been connected by other edge
				continue ; //ignore this edge
			}else{
				connectedNodes[e.from] = 1 ; //mark this node as has been visited by a edge.
				connectedNodes[e.to] = 1 ; //mark this node as has been visited by a edge.
				selectedEdges[j++] = e ; //this edge has been chosen.
			}
		}
		
		return selectedEdges ;
	}
	

	private static Edge[] orderEdges(int[][] graph) {
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
	
	
	public static void quickSort(Edge[] arr){
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
