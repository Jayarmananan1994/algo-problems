package com.vjay.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class ProblemOneTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:4", "1,3,6,4,1,2:5", "-1,-3:1"}, delimiterString = ":")
    void shouldFindNonOccurringLeastPositiveNumber(String arrayStr, String expectedOutput){
        int[] arr = Arrays.stream(arrayStr.split(",")).mapToInt(Integer::parseInt).toArray();

        int actual = new ProblemOne().missingNumber(arr);
        Assertions.assertEquals(Integer.parseInt(expectedOutput), actual);
    }
}