package com.vjay.algos;

import java.util.Arrays;

public class Algos {

    public String solution(String message, int k) {
        String[] words = message.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.length() + stringBuilder.length() > 14) {
                break;
            }
            stringBuilder.append(word + " ");
        }

        return stringBuilder.toString().trim();
    }

    public int numberOfFiler(int[] A) {
        double[] aCopy = Arrays.stream(A).asDoubleStream().toArray();;
        //Arrays.sort(aCopy);
        int count = 0;
        double target = sumOf(A)/2;
        for (int i = aCopy.length - 1; i >= 0; i++) {
            count +=1;
            sortAndHalfLastIndex(aCopy);
            if (sumOf(aCopy) <= target) {
                break;
            }
        }
        return count;
    }

    private void sortAndHalfLastIndex(double[] aCopy) {
        Arrays.sort(aCopy);
        aCopy[aCopy.length-1] = aCopy[aCopy.length-1]/2;
    }

    private double sumOf(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

    private int sumOf(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
    }

}
