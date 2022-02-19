package com.vjay.algos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ScratchPad {

    @Test
    void test() {
        String str = "x we test coders";

        int k = 14;
        String result = new Algos().solution(str, k);
        Assertions.assertEquals(result, "Codality we");
    }

    @Test
    void test2() {
        int[] A = {10,10};
        var val = Arrays.stream(A).boxed().collect(Collectors.toList());
        Assertions.assertEquals(val.size(), 0);
    }

    @Test
    void test3() {
        int[] A = {3,0,5};
        int count = new Algos().numberOfFiler(A);
        Assertions.assertEquals(2, count);
    }
}
