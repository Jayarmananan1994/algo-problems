package com.vjay.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemTwoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,7,2,4:3:3"}, delimiterString = ":")
    void shouldReturnSizeOfMaxSubSet(String arrayStr, String divisor, String expected) {
        List<Integer> list = Arrays.stream(arrayStr.split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int actual = new ProblemTwo().nonDivisibleSubset(parseInt(divisor), list);
        assertEquals(parseInt(expected), actual);
        list.add(1,1);
    }
}