package com.yxy.algorithms.array.majority.element.II;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
Medium
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 * @author Ye Xianyi
 * Copy from:
 * https://blog.csdn.net/qq_41951186/article/details/82937069
 */
public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        //记得corner case， 长度为0要记得；
        if(nums.length == 0) return res;
        //c1为1是因为赋值为nums里面的值
        int n1 = nums[0], c1 = 1;
        //c2为0，是因为没有赋值nums里面的值；
        int n2 = 0, c2 = 0;
        for(int i = 1; i < nums.length; i++) {
            
            if (nums[i] == n1) ++c1;
            else if (nums[i] ==n2) ++c2;
            else if (c1 == 0) {n1 = nums[i]; c1 = 1;}
            else if (c2 == 0) {n2 = nums[i]; c2 = 1; }
            else {--c1; --c2;}
        }
        
        //因为多于三分之一的数最多可能出现2个，但是你最后通过上面筛选下来的那两个值不一定都是众数
        //所以需要对这两个数再审查一遍
        c1 = 0;
        c2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == n1) {
                c1++;
            }else if(nums[i] == n2) {
                c2++;
            }
        }
        if(c1 > nums.length / 3) res.add(n1);
        if(c2 > nums.length / 3) res.add(n2);
        return res;
        
    }


    public static void main(String[] args) {

    }

}
