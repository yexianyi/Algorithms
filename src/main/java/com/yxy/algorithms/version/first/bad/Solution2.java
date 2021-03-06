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
package com.yxy.algorithms.version.first.bad;

import java.util.Random;

public class Solution2 extends VersionControl{
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	public int firstBadVersion(int n) {
		return isBadVersion(n, 1,n) ;
    }
	
	public int isBadVersion(int n, int low, int high){
		if(low<high){
			int mid = generateInt(low, high) ;
			if(isBadVersion((int)mid)){
				return isBadVersion(n, low, mid-1) ;
			}else{
				return isBadVersion(n, mid+1, high) ;
			}
		}else{//low==high
			if(low-1>0 && high+1<=n && isBadVersion((int)low-1)){
				return (int)low-1 ;
			}else if(low>0 && high<=n && isBadVersion((int)low)){
				return (int)low ;
			}else{
				return (int)low+1 ;
			}
		}
	}
	
	private int generateInt(int min, int max){
		Random random = new Random();
		return random.nextInt(max)%(max-min+1) + min;
		
	}


	public static void main(String[] args) {
		Solution2 s = new Solution2() ;
//		System.out.println(s.firstBadVersion(100));
//		System.out.println(s.firstBadVersion(3));
//		System.out.println(s.firstBadVersion(2));
		System.out.println(s.firstBadVersion(2126753390));
	    

	}

}
