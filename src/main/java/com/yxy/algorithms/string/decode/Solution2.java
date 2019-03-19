package com.yxy.algorithms.string.decode;

/**
 * 394. Decode String
    Given an encoded string, return it's decoded string.
    
    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
    
    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
    
    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
    
    Examples:
    
    s = "3[a]2[bc]", return "aaabcbc".
    s = "3[a2[c]]", return "accaccacc".
    s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 * @author yexianyi
 * 2019/03/19
 * 
 * Copy from:
 * https://leetcode.com/problems/decode-string/discuss/257650/1ms-100-straightforward-recursive-sol-with-Chinese-comments
 */

public class Solution2 {

    public static String decodeString(String s) {
        int n = s.length(), index = s.indexOf("[");
        StringBuilder res = new StringBuilder();
        if (n == 0)
            return "";
        // 处理没有括号的字符串
        if (index < 0) {
            index = 0;
            int digitEnd = index, strEnd, mul;
            while (digitEnd < n && Character.isDigit(s.charAt(digitEnd)))
                digitEnd++;
            if (digitEnd == index)
                mul = 1;
            else
                mul = Integer.parseInt(s.substring(index, digitEnd));
            strEnd = digitEnd;
            while (strEnd < n && Character.isLetter(s.charAt(strEnd)))
                strEnd++;
            String tmp = s.substring(digitEnd, strEnd);
            for (int i = 0; i < mul; i++)
                res.append(tmp);
        } else {
            // 有括号的字符串：递归处理
            int digitStart = index - 1;
            while (digitStart >= 0 && Character.isDigit(s.charAt(digitStart)))
                digitStart--;
            digitStart++;
            int mul = Integer.parseInt(s.substring(digitStart, index));
            res.append(s.substring(0, digitStart));// 处理括号前面的字符串
            int balance = 1, right = index;// 由于括号可能存在嵌套，所以需要找到匹配的括号
            while (balance != 0) {
                right++;
                if (s.charAt(right) == '[')
                    balance++;
                else if (s.charAt(right) == ']')
                    balance--;
            }
            String tmp = decodeString(s.substring(index + 1, right));
            for (int i = 0; i < mul; i++)
                res.append(tmp);// 处理括号内字符串
            res.append(decodeString(s.substring(right + 1)));// 处理括号后面字符串
        }
        return res.toString();
    }
    
    

    public static void main(String[] args) {
        System.out.println(decodeString("2[20[bc]31[xy]]xd4[rt]"));
        System.out.println(decodeString("3[a2[c]]4[b]"));
        System.out.println(decodeString("3[c]"));

    }

}
