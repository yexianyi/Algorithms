package com.yxy.algorithms.array.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * @author yexianyi
 * 2019/04/25
 */
public class Solution {

    private static class IntervalComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] < o2[0])
                return -1;
            else if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else if (o1[1] > o2[1]) {
                return 1;
            }
            return 0;
        }

    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }

        Collections.sort(list, new IntervalComparator());
        for (int i = 0; i < list.size(); i++) {
            int[] nums = new int[2];
            nums[0] = list.get(i)[0];
            nums[1] = list.get(i)[1];
            intervals[i] = nums;
        }

        List<int[]> ans = new ArrayList<>();

        ans.add(new int[] { intervals[0][0], intervals[0][1] });
        for (int i = 1; i < intervals.length; i++) {
            int[] tail = ans.get(ans.size() - 1);
            if (tail[1] >= intervals[i][0]) {
                ans.remove(ans.size() - 1);
                ans.add(new int[] { Integer.min(tail[0], intervals[i][0]), Integer.max(tail[1], intervals[i][1]) });
            } else {
                ans.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        intervals = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            intervals[i][0] = ans.get(i)[0];
            intervals[i][1] = ans.get(i)[1];
        }

        return intervals;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 5, 10 }, { 15, 18 }, { 14, 19 }, { 0, 4 } };
        int[][] ans = merge(intervals);
        for (int[] array : ans) {
            System.out.println(array[0] + "," + array[1]);
        }
    }

}
