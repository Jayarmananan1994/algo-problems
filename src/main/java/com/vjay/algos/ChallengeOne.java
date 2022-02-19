package com.vjay.algos;

import java.util.ArrayList;
import java.util.List;

public class ChallengeOne {

    public int missingNumber(int arr[]) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                nums.add(arr[i]);
            }
        }
        int answer = 1;
        for (int i = 1; i <= nums.size() + 1; i++) {
            if (!nums.contains(i)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
