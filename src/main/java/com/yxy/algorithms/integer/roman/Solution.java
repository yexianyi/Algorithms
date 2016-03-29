package com.yxy.algorithms.integer.roman;

/**
 * 	12. Integer to Roman My Submissions QuestionEditorial Solution
	Total Accepted: 59951 Total Submissions: 156694 Difficulty: Medium
	Given an integer, convert it to a roman numeral.
	
	Input is guaranteed to be within the range from 1 to 3999.
 * @author Xianyi Ye
 * @Date 03/28/2016
 * Copy from:
 * https://leetcode.com/discuss/91819/simple-java-solution
 * https://leetcode.com/discuss/91364/my-java-solution
 */ 
public class Solution {
	private static String[] g = {"", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static String[] s = {"", "X","XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String[] b = {"", "C","CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String[] q = {"", "M","MM", "MMM"};  

    //Beats 91%
    public String intToRoman2(int num) {

        StringBuilder roman = new StringBuilder();
        return roman.append(q[num / 1000])
                .append(b[num / 100 % 10])
                .append(s[num / 10 % 10])
                .append(g[num % 10]).toString();
    }
	
    //Beats 46%
	public String intToRoman(int num) {
	    String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
	}

	public static void main(String[] args) {

	}

}
