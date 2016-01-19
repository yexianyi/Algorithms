package com.yxy.algorithms.bits.add;

/**
 * 
	67. Add Binary
	 My Submissions 
	Question 
	
	Total Accepted: 69323 Total Submissions: 265819 Difficulty: Easy 
	Given two binary strings, return their sum (also a binary string). 
	
	For example,
	 a = "11"
	 b = "1"
	 Return "100". 

 * @author xianyiye
 * 2016/1/11
 */
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
       
       int increase = 0 ;
       int i = 0 ;
       int j = 0 ;
       for(i=array.length-1 , j=b.length()-1; i>=0 && j>=0; i--,j--){
    	   if(array[i]=='1' && b.charAt(j)=='1'){//	11
    		   if(increase==1){
    			   array[i] = '1' ;
    		   }else{
    			   array[i] = '0' ;
    			   increase = 1 ;
    		   }
    	   }else if((array[i]=='1' ^ b.charAt(j)=='1')){// 10 or 01
    		   if(increase==1){
    			   increase = 1 ;
    			   array[i] = '0' ;
    		   }else{
    			   array[i] = '1' ;
    		   }
    	   }else{//	00
    		   if(increase==1){
    			   increase = 0 ;
    			   array[i] = '1' ;
    		   }else{
    			   array[i] = '0' ;
    		   }
    	   }
       }
       
       
       if(increase==1){
    	  while(i>=0 && array[i]=='1'){
    		  array[i] = '0' ;
    		  i-- ;
    	  }
    	  if(i>0){
    		  array[i] = '1' ;
    		  return new String(array) ;
    	  }else{
    		  return "1"+new String(array) ;
    	  }
       }
       
		return new String(array) ; 
    }

	public static void main(String[] args) {
		System.out.println(addBinary("0","0"));
		System.out.println(addBinary("11","01"));
		System.out.println(addBinary("1011","11"));
		System.out.println(addBinary("11","1011"));

	}

}
