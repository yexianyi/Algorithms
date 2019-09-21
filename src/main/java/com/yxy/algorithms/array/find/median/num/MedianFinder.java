package com.yxy.algorithms.array.find.median.num;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 295. Find Median from Data Stream
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * @author yexianyi
 * 2019/09/21
 * 
 * Copy from:
 * https://www.cnblogs.com/Liok3187/p/4928667.html
 *
 */
public class MedianFinder {
	private Queue<Integer> left ;
	private Queue<Integer> right ;
	
	 /** initialize your data structure here. */
    public MedianFinder() {
    	left = new PriorityQueue<>(Collections.reverseOrder()) ;
    	right = new PriorityQueue<>() ;
    }
    
    public void addNum(int num) {
        if(left.size() < right.size()) {
        	left.offer(num) ;
        	right.offer(left.poll()) ;
        	left.offer(right.poll()) ;
        } else {
        	right.offer(num) ;
        	left.offer(right.poll()) ;
        	right.offer(left.poll()) ;
        }
    }
    
    public double findMedian() {
    	if(left.size() < right.size()) {
    		return right.peek() ;
    	}else if(left.size() > right.size()) {
    		return left.peek() ;
    	}else {
    		return (left.peek() + right.peek()) / 2.0 ;
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
