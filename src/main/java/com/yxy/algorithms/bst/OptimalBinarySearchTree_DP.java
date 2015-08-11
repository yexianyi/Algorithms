package com.yxy.algorithms.bst;
/**
 * @author xianyi ye
 * @Date 8/11/2015
 * 
 * Question:
 * Create an OBST based on existing searching percentage:
 * k{0.0f, 0.24f, 0.18f, 0.09f, 0.13f, 0.3f, 0.06f}
 * 
 * Solution:
 * Given that e[k,k] = sum[dept(k)+p(k)] = dept(k)+p(k) = 0 + p(k) ;
 * So that,   e[i,j] = sum[dept(k)+p(k)] (i<=k<=j)
 *                   = dept(i)+p(i)+dept(i+1)+p(i+1)+...+dept(j)+p(j)
 * 
 * Assume that "r" is the root node of the nodes from "i" to "j",
 * so that e[r,r] = sum[dept(r)+p(r)] = 0 + p(r) = p(r) ;
 *         e[i,j] = dept(i)+p(i)+dept(i+1)+p(i+1)+...+dept(r-1)+p(r-1)+dept(r)+p(r)+dept(r+1)+p(r+1)+...+dept(j)+p(j)
 * 		  = sum[dept(k)+p(k)]+w(k) + dept(r)+p(r) + sum[dept(k)+p(k)]+w(k)
 * 			     (i<=k<=r-1)		 	(r+1<=k<=j)			  
 *		  = e[i,r-1]+w[i,r-1]+dept(r)+p(r)+e[r+1,j]+w[r+1,j]	
 * 		  = e[i,r-1]+w[i,r-1]+0+p(r)+e[r+1,j]+w[r+1,j]	
 * 		  = e[i,r-1]+e[r+1,j]+w[i,r-1]+w[r+1,j]+p(r)
 * 		  = e[i,r-1]+e[r+1,j]+w[i,j]
 * 
 * To find out which node is to be the best root of nodes, each of nodes must be tested.
 * Therefore, e[i,j] = min{e[i,r-1]+e[r+1,j]+w[i,j]} (i<=j), 
 * Especially, if i=j+1, e[i,j] = e[i, i-1] = 0 (That's because e[i, i-1] is meaningless.)
 * 
 * T(n) = O(n^3)
 * 
 *
 */
public class OptimalBinarySearchTree_DP {
	
	private static float[][] e = null ; //Store e[i,j]
	private static float[][] w = null ; //Store w[i,j]
	private static float[][] root = null ; //Store root candidates

	public static void optimal_bst(float[] p){
		int nodeCount = p.length ;
		e = new float[nodeCount+1][nodeCount]  ;
		w = new float[nodeCount+1][nodeCount]  ;
		root = new float[nodeCount][nodeCount]  ;
		
		
		for(int l=1; l<=nodeCount; l++){	// l:the num of nodes on the tree
			for(int i=1; i<nodeCount-l+1; i++){		//left boundary is from 1 to nodeCount-l+1
				int j = i+l-1 ; 	//calculate right boundary based on left.
				w[i][j] = w[i][j-1] + p[j] ;
				e[i][j] = Float.MAX_VALUE ;
				
				for(int r=i; r<=j; r++){ //possible root node
					float e_left = cal_e(i, r-1, e, p) ;  //e[i,r-1]
					float e_right = cal_e(r+1, j, e, p) ; //e[r+1,j]
					float e_val = e_left + e_right + w[i][j] ;
					if(e_val < e[i][j]){
						e[i][j] = e_val ;
						root[i][j] = r ;
					}
				}
			}
		}
		
		display(w) ;
		display(e) ;
		display(root) ;
		
	}
	
	
	private static float cal_w(int left, int right, float[][] w, float[] p) {
		if(w[left][right]==0.0f){
			for(int index = left; index<=right ; index++){
				w[left][right] += p[index-1] ;
			}
		}
		
		return w[left][right];
	}

	private static float cal_e(int left, int right, float[][] e, float[] p) {
		if(left == right + 1){
			e[left][right] = 0.0f ;
		}
		else if(e[left][right]==0.0f){
			for(int index = left; index<=right ; index++){
				e[left][right] += p[index] ;
			}
		}
		
		return e[left][right];
	}
	
	
	public static void display(float[][] array){
		System.out.print("i\\j") ;
		for(int j=0; j<array[0].length; j++){
			System.out.print("  "+j) ;
		}
		
		System.out.println() ;
		
		for(int i=0; i<array.length; i++){
			System.out.print(i+"   ") ;
			for(int j=0; j<array[i].length; j++){
				System.out.print(array[i][j]+" ") ;
			}
			System.out.println() ;
		}
		
		System.out.println("-----------------------\n") ;
	}

	public static void main(String[] args) {
		float[] p = {0.0f, 0.24f, 0.18f, 0.09f, 0.13f, 0.3f, 0.06f} ;
		optimal_bst(p) ;
		
	}

}
