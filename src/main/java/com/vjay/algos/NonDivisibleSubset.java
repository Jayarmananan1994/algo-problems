package com.vjay.algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonDivisibleSubset {

    public int nonDivisibleSubset(int k, List<Integer> s) {
        if (k == 1 || k == 0) {
            return 1;
        }
        List<Integer> result = new ArrayList<>();
        List<Integer> reminderList = s.stream().map(i -> i % k).collect(Collectors.toList());
        Map<Integer, Integer> reminderCount = new HashMap<>();
        for (Integer num : reminderList) {
            if (reminderCount.containsKey(num % k)) {
                int newVal = reminderCount.get(num % k) + 1;
                reminderCount.put(num % k, newVal);
            } else {
                reminderCount.put(num % k, 1);
            }
        }
        for (Integer num : reminderList) {
            if (num == 0) {
                if (!result.contains(0)) {
                    result.add(num);
                }
            } else if (reminderCount.containsKey(k - num)) {
                int opponentCount = reminderCount.get(k - num);
                int myCount = reminderCount.get(num);
                if (myCount > opponentCount) {
                    result.add(num);
                } else if (myCount == opponentCount && !result.contains(k - num)) {
                    result.add(num);
                }
            } else {
                result.add(num);
            }
        }

        return result.size();
    }


}
