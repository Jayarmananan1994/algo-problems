package com.vjay.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;
import java.util.stream.Collectors;

class SmallestPositiveNumberTest {

    @ParameterizedTest
    @CsvSource({"1,2,3:4", "1,3,6,4,1,2:5", "-1,-3:1"})
    void shouldReturnSmallestPositiveNumber(String input, String expected) {
        int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        SmallestPositiveNumber sol = new SmallestPositiveNumber();
        var actual = sol.solution(numbers);
        Assertions.assertEquals(expected, actual);
    }

    public static int nonDivisibleSubsetV2(int k, List<Integer> s) {
        if (k == 1 || k == 0) {
            return 1;
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>(s);
        List<Integer> reminderList = set.stream().map(i -> i % k).collect(Collectors.toList());
        Map<Integer, Integer> reminderCount = new HashMap<>();
        for (Integer num : set) {
            if (reminderCount.containsKey(num % k)) {
                int newVal = reminderCount.get(num % k) + 1;
                reminderCount.put(num % k, newVal);
            } else {
                reminderCount.put(num % k, 1);
            }
        }
        for (Integer num : reminderList) {
            if (reminderCount.containsKey(k - num)) {
                int opponentCount = reminderCount.get(k - num);
                int myCount = reminderCount.get(num);
                System.out.println(opponentCount + " > " + myCount);
                if ( myCount > opponentCount) {
                    result.add(num);
                }
            } else {
                result.add(num);
            }
        }

        return result.size();
    }


    public int nonDivisibleSubset(int k, List<Integer> s) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>(s);
        List<Integer> sortedList = new ArrayList<>(set);
        List<Integer> subset = new ArrayList<>();

        for (int i = 0; i < sortedList.size(); i++) {
            maxLength = subset.size() > maxLength ? subset.size() : maxLength;
            subset.clear();
            subset.add(sortedList.get(i));
            for (int j = 0; j < set.size(); j++) {
                if (j != i) {
                    boolean canAdd = canAddNum(subset, sortedList.get(j), k);
                    if (canAdd) {
                        subset.add(sortedList.get(j));
                    }
                }
            }
        }
        return maxLength;
    }

    static boolean canAddNum(List<Integer> numbers, int num, int divisor) {
        for (int n : numbers) {
            if ((n + num) % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {

        Assertions.assertEquals(3, nonDivisibleSubsetV2(3, List.of(1, 7, 2, 4)));
    }
}