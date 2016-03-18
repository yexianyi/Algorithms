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
package com.yxy.algorithms.greedy.course.scheduler;

/**
 * 
 * @author xianyiye
 * @Date 9/14/2015
 * 
 * Questions:
 * According an course table which is mentioned the start time and finish time of each curse in a day.
 * Find out which courses in maximum could be arranged in a day in same class room without conflict. 
 * 
 * Solution:
 * 1. Sort the course table by finish time.
 * 2. Find the scheduled course I (1<=I<=N).
 * 	2.1 If the start time of M < the finish time of I, 
 * 		it means course M gets start before course I finishes. 
 * 		Therefore, this course, M , should be ignored.
 *  2.2 Else, current course is the qualified course which is the most close to course I, 
 *      therefore, it should be chose.
 *  2.3 If M>N, all the course have been decided. The iterator should be end.
 * 
 * Time complexity: O(n)
 *
 *
 */

public class CourseSchedulerTest {
	
	/*
	 * start: the start time of each course
	 * finish: the end time of each course
	 * i: the sequence of the course where the scheduler search from
	 */
	public static void courseScheduler(int[] start, int[] finish, int i){
		if(i==0){
			System.out.print((i+1)+" ");
		}
		
		int m = i ; //temp var to store the seq of current searched course
		
		while(m<start.length && start[m]<finish[i]){
			m++ ; //ignored, because the course 'm' gets start before course 'i'.
		}
		
		if(m<start.length){
			System.out.print((m+1)+" ");
			courseScheduler(start, finish, m) ;
		}
		
	}
	
	public static void courseScheduler2(int[] start, int[] finish, int i){
		System.out.print(i+1+" ");
		for(int m=i+1; m<start.length; m++){
			if(start[m]>=finish[i]){
				System.out.print(m+1+" ");
				i = m ;
			}
		}
		
	}
	

	public static void main(String[] args) {
		int[] start =  {0,2,4,3, 6, 8, 9,10,11,12,13,15} ;
		int[] finish = {3,5,7,8,10,10,11,13,15,15,17,18} ;

		for(int i=0; i<start.length; i++){
			if(start[i]<10){
				System.out.print((i+1)+" ");
			}
			else{
				System.out.print(" "+(i+1));
			}
		}
		
		System.out.println() ;
		
		for(int i=0; i<start.length; i++){
			System.out.print(start[i]+" ");
		}
		
		System.out.println() ;
		
		for(int i=0; i<finish.length; i++){
			System.out.print(finish[i]+" ");
		}
		
		System.out.println() ;
		System.out.println("Result:") ;
		//do scheduler
		courseScheduler(start, finish, 0) ;
		System.out.println() ;
		courseScheduler2(start, finish, 0) ;
	}

}
