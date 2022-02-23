package com.vjay.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RepeatedStringTest {

    @ParameterizedTest
    @CsvSource(value = {"aba,10,7", "abcac,10,4"})
    void shouldGiveNumberOfAInSubString(String text, String freq, String expected) {
        long actual = new RepeatedString().repeatedString(text, Integer.parseInt(freq));
        Assertions.assertEquals(Long.parseLong(expected), actual);
    }
}