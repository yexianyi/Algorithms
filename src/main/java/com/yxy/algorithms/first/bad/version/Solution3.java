package com.yxy.algorithms.first.bad.version;

import java.util.Random;

public class Solution3 extends VersionControl{
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
		int start=1,end=n;
        int res=-1;
        while(start<=end){
            int mid = start + ((end-start)>>1); //same to (start+end)/2
            if(isBadVersion(mid)){
                res=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return res;
    }
	


	public static void main(String[] args) {
		Solution3 s = new Solution3() ;
//		System.out.println(s.firstBadVersion(100));
//		System.out.println(s.firstBadVersion(3));
//		System.out.println(s.firstBadVersion(2));
		System.out.println(s.firstBadVersion(2126753390));
	    

	}

}
