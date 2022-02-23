package com.vjay.algos;

public class RepeatedString {

    public  long repeatedString(String s, long n) {
        int noOfAInFullSet = noOfA(s);
        long noOfSubSet = n/ s.length();
        long reminder = n % s.length() ;
        return noOfSubSet*noOfAInFullSet + noOfA(s.substring(0, (int)reminder));
    }

    private int noOfA(String s) {
        int count = 0;
        for(int i=0; i< s.toCharArray().length; i++) {
            if(s.charAt(i)=='a') {
                count +=1;
            }
        }
        return count;
    }

}
