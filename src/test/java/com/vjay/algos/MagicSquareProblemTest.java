package com.vjay.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MagicSquareProblemTest {

    @Test
    void shouldReturnMinimumStepForMagicSquare() {
        List<List<Integer>> input = List.of(
                List.of(4,8,2),
                List.of(4,5,7),
                List.of(6,1,6)
        );

        int actual = new MagicSquareProblem().formingMagicSquare(input);
        Assertions.assertEquals(4, actual);
    }
}