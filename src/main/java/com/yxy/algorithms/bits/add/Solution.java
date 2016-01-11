package com.yxy.algorithms.bits.add;

public class Solution {

	public static String addBinary(String a, String b) {
		if(a.length()<b.length()){
			String temp = a;
			a = b;
			b = temp ;
		}
        
       char[] array = new char[a.length()] ;
       for(int i=0; i<a.length(); i++){
    	   array[i] = a.charAt(i) ;
       }
       
       int i=0 ;
       for(i=array.length-1; i>=0; i--){
    	   if(array[i]=='1' && b.charAt(i)=='1'){//11
    		   array[i] = 0 ;
    		   array[i-1]++ ;
    	   }
       }
       
		return null  ;
    }

	public static void main(String[] args) {
		System.out.println(addBinary("0","0"));

	}

}
