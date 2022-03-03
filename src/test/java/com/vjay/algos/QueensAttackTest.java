package com.vjay.algos;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueensAttackTest {

    @Test
    void shouldReturnValidNumberOfQueenPositionWithNoObstacle() {
        int actual = new QueensAttack().queensAttack(4, 0, 4, 4, List.of());
        assertEquals(9, actual);
    }

    @Test
    void shouldReturnValidNumberOfQueenPositionWithFewObstacle() {
        int actual = new QueensAttack().queensAttack(100000, 0, 4187, 5068, List.of());
        assertEquals(308369, actual);
    }

    @Test
    void shouldReturnValidNumberOfQueenPositionInCenter() {
        int actual = new QueensAttack().queensAttack(5, 0, 3, 3, List.of());
        assertEquals(16, actual);
    }

    @Test
    void shouldReturnValidNumberOfQueenPositionWithOneSquare() {
        int actual = new QueensAttack().queensAttack(1, 0, 1, 1, List.of());
        assertEquals(0, actual);
    }

    @Test
    void shouldReturnValidNumberOfQueenPositionWithObstacle() {
        List<List<Integer>> obstacles = List.of(
                List.of(5, 5),
                List.of(4, 2),
                List.of(2, 3)
        );
        int actual = new QueensAttack().queensAttack(5, 3, 4, 3, obstacles);
        assertEquals(10, actual);
    }
}