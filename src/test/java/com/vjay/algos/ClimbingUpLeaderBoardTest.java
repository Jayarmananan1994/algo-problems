package com.vjay.algos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ClimbingUpLeaderBoardTest {

    @Test
    void shouldReturnValidRankingList() {
        var ranked = List.of(100, 90, 90, 80);
        var player = List.of(70, 80, 105);
        var actual = new ClimbingUpLeaderBoard().climbingLeaderboard(ranked, player);
        List<Integer> expected = List.of(4, 3, 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnValidRankingListV2() {
        var ranked = List.of(100, 90, 90, 80, 75, 60);
        var player = List.of(50, 65, 77, 90, 102);
        var actual = new ClimbingUpLeaderBoard().climbingLeaderboard(ranked, player);
        List<Integer> expected = List.of(6, 5, 4, 2, 1);
        Assertions.assertEquals(expected, actual);
    }

}