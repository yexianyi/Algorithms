package com.yxy.algorithms.unique.paths;

public class Solution {
	
	private int count = 0 ;
	
	public int uniquePaths(int m, int n) {
		findPaths(m-1,n-1) ;
		
        return count ;
    }
	
	
	private void findPaths(int m, int n){
		if(m==0 && n==0){
			count++ ;
			return ;
		}
		
		if(m>0){
			findPaths(m-1,n) ;
		}
		
		if(n>0){
			findPaths(m, n-1) ;
		}
		
	}

	public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(3,7)) ;
		System.out.println(new Solution().uniquePaths(1,1)) ;

	}

}
