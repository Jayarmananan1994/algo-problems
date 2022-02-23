package com.vjay.algos;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NonDivisibleSubsetTest {

    @ParameterizedTest
    @CsvSource(value = {"1,7,2,4,6,6:3:4"}, delimiterString = ":")
    void shouldReturnSizeOfMaxSubSet(String arrayStr, String divisor, String expected) {
        List<Integer> list = Arrays.stream(arrayStr.split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int actual = new NonDivisibleSubset().nonDivisibleSubset(parseInt(divisor), list);
        assertEquals(parseInt(expected), actual);
        list.add(1,1);
    }
}