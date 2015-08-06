package com.yxy.algorithms.max.matrix;

import com.yxy.algorithms.max.sum.MaxSumTest_DP;

public class MaxMatrixTest {

	public static int maxMatrix(int[][] matrix) {
		int maxSum = 0;

		for (int m1 = 0; m1 < matrix.length; m1++) { // horizontal cursor 1
			for (int n1 = 0; n1 < matrix[0].length; n1++) { // vertical cursor 1
				System.out.println("Start:" + m1 + " " + n1);
				for (int m2 = m1; m2 < matrix.length; m2++) { // horizontal cursor 2
					int[] temp = new int[matrix[0].length - n1];

					for (int n2 = n1; n2 < matrix[0].length; n2++) { // vertical cursor 2
						temp[n2 - n1] += matrix[m2][n2];
						System.out.println(m2 + " " + n2);
					}
					int subMax = MaxSumTest_DP.maxSum(temp);
					if (subMax > maxSum) {
						maxSum = subMax;
					}
					System.out.println("------------");
				}
			}
		}

		return maxSum;
	}

	public static int maxMatrix2(int[][] matrix) {
		int maxSum = 0;
		int[] b = new int[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) { // horizontal cursor 1
			for (int k = 0; k < matrix[0].length; k++) { // vertical cursor 1
				b[k] = 0 ;
				System.out.println("-----Reset b["+k+"]---");
			}
				for (int j = i; j < matrix.length; j++) { // horizontal cursor 2
					for (int k = 0; k < matrix[0].length; k++) { // vertical cursor 2
						b[k] += matrix[j][k];
						System.out.println("b["+k+"]+="+"["+j+"]["+k+"]"+matrix[j][k]+"="+b[k]) ;
//						System.out.println(j + " " + k);
					}
					int subMax = MaxSumTest_DP.maxSum(b);
					if (subMax > maxSum) {
						maxSum = subMax;
					}
					System.out.println("-----Compare-----");
				}
		}

		return maxSum;

	}

	public static void main(String[] args) {
		int[][] nums = { { -1, -2, -3 }, 
						 { 15, -4, 6 }, 
						 { -7, 8, 9 } };
		 System.out.println(maxMatrix2(nums));
	}

}
