package com.yxy.algorithms.lcs;

/**
 * 
 * @author xianyiye
 * @Date 7/31/2015
 * 
 *Space complexity: O(n^2)
 *Time complexity: O(n^2)
 *
 *
 *Reference: 
 *http://blog.csdn.net/v_JULY_v/article/details/6110269
 *http://qiangmzsx.blog.51cto.com/2052549/824842
 *http://baike.baidu.com/view/2020307.htm
 *
 *
 */

public class LCSTest {
	
	public static int getLCSLength(String str1, String str2, String[][] lcsPath){
		int[][] c = new int[str1.length()+1][str2.length()+1] ;
		
		for(int i=1 ; i<=str1.length(); i++){
			for(int j=1; j<=str2.length(); j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					c[i][j] = c[i-1][j-1]+1 ;
					lcsPath[i-1][j-1] = "↖" ;
				}else if(c[i-1][j]<=c[i][j-1]){
					c[i][j] = c[i][j-1] ;
					lcsPath[i-1][j-1] = "←" ;
				}else{
					c[i][j] = c[i-1][j] ;
					lcsPath[i-1][j-1] = "↑" ;
				}
			}
		}
		
		return c[str1.length()][str2.length()] ;
	}
	
	public static void LCS(int i, int j, String str1, String[][] lcsPath){
		if(i==0 || j==0){
			if(lcsPath[i][j].equalsIgnoreCase("↖")){
				System.out.print(str1.charAt(i));
			}
			return ;
		}
		
		if(lcsPath[i][j].equalsIgnoreCase("↖")){
			LCS(i-1, j-1, str1, lcsPath) ;
			System.out.print(str1.charAt(i));
		}else if(lcsPath[i][j].equalsIgnoreCase("←")){
			LCS(i, j-1, str1, lcsPath) ;
		}else{
			LCS(i-1, j, str1, lcsPath) ;
		}
	}
	
	public static int maxLCSLength(String str1, String str2){
		for(int i=0 ; i<str1.length(); i++){
			for(int j=0; j<str2.length(); j++){
				if(str1.charAt(i) == str2.charAt(j)){
					return maxLCSLength(str1.substring(i+1), str2.substring(j+1))+1 ;
				}else {
					int left = maxLCSLength(str1.substring(i+1), str2) ;
					int right = maxLCSLength(str1, str2.substring(j+1)) ;
					if(left<=right){
						return right ;
					}else{
						return left ;
					}
				}
				
			}
		}
		return 0 ;
	}
	
	
	public static void main(String[] args) {
		String str1 = "ABCBDAB" ;
		String str2 = "BDCABA" ;
		String[][] lcsPath = new String[str1.length()][str2.length()] ;
		System.out.println(getLCSLength(str1,str2,lcsPath)) ;
		LCS(str1.length()-1,str2.length()-1,str1,lcsPath)  ;
		
	}

}
