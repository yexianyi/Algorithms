package com.yxy.algorithms.binary.tree.average.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.yxy.algorithms.binary.tree.TreeNode;
import com.yxy.algorithms.binary.tree.util.BinaryTreeUtil;
/**
 * 637. Average of Levels in Binary Tree
    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
    Example 1:
    Input:
        3
       / \
      9  20
        /  \
       15   7
    Output: [3, 14.5, 11]
    Explanation:
    The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
    Note:
    The range of node's value is in the range of 32-bit signed integer.
    
 * @author yexianyi
 * 2019/03/18
 */
public class Solution {

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> avgList = new ArrayList<>();
        if (root == null) {
            return avgList;
        }

        queue.add(root);
        int count = 1;

        while (!queue.isEmpty()) {
            int nextCount = 0;
            double sum = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    nextCount++;
                    queue.add(node.left);
                }

                if (node.right != null) {
                    nextCount++;
                    queue.add(node.right);
                }
            }
            avgList.add(sum / count);
            count = nextCount;
        }

        return avgList;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeUtil.create(new Integer[] { 3, 9, 20, 15, 7 }, TreeNode.class);
        List<Double> avgList = averageOfLevels(root);
        for (double avg : avgList) {
            System.out.println(avg);
        }
    }

}
