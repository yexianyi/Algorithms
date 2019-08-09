package com.yxy.algorithms.numbers.permutations.sequence;

import java.util.LinkedList;
import java.util.List;

/**
 * 60. Permutation Sequence
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 * @author yexianyi
 * 2019/08/09
 * 
 * Reference:
 * https://blog.csdn.net/qq_26410101/article/details/81261401
 */

public class Solution {

    public static String getPermutation(int n, int k) {
        List<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }

        StringBuilder res = new StringBuilder();
        k = k - 1;
        while (n > 0) {
            int idx = k / factorial(n - 1);
            res.append(nums.get(idx));
            nums.remove(idx);
            k = k % factorial(n - 1);
            n--;
        }

        return res.toString();
    }

    public static int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 17));

    }

}
