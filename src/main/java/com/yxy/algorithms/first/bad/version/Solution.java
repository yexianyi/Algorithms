package com.yxy.algorithms.first.bad.version;



public class Solution extends VersionControl{
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
		return isBadVersion(1,n) ;
    }
	
	public int isBadVersion(int start, int end){
		int version = (start+end)/2 ;
		if(start==end){
			if(isBadVersion(version)){
				if(isBadVersion(start-1)){
					return start-1 ;
				}else{
					return start ;
				}
			}else{
				return version+1 ;
			}
			
		}
		
		if(isBadVersion(version)){
			return isBadVersion(1, version-1) ;
		}else{
			return isBadVersion(version+1, end) ;
		}
		
	}


	public static void main(String[] args) {
		Solution s = new Solution() ;
		System.out.println(s.firstBadVersion(6));

	}

}
