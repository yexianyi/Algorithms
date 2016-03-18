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
