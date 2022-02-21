package com.vjay.algos;

import java.util.*;
import java.util.stream.Collectors;

public class ClimbingUpLeaderBoard {

    public List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        List<Integer> rankNum = new ArrayList<>();
        for (int i = 0; i < ranked.size(); i++) {
            if (i == 0) {
                rankNum.add(1);
            } else {
                int prevScore = ranked.get(i - 1);
                int currentScore = ranked.get(i);
                int prevRank = rankNum.get(i - 1);
                int currentRank = (prevScore == currentScore) ? prevRank : prevRank + 1;
                rankNum.add(currentRank);
            }
        }
        return player.stream().map(i -> findRankByBinarySearch(ranked, 0, ranked.size() - 1, rankNum, i)).collect(Collectors.toList());
    }

    int findRank(List<Integer> scores, List<Integer> ranks, int scoreToFind) {
        System.out.println(scores);
        for (int i = scores.size() - 1; i >= 0; i--) {
            System.out.println("i:" + i);
            if (scores.get(i) > scoreToFind) {
                return ranks.get(i) + 1;
            }
        }
        return 1;
    }

    int findRankByBinarySearch(List<Integer> scores, int startIndex, int endIndex, List<Integer> ranks, int scoreToFind) {
        if (endIndex == startIndex) {
            var index = (scoreToFind >= scores.get(endIndex)) ? ranks.get(endIndex) : ranks.get(endIndex) + 1;
            return index;
        } else if (endIndex - startIndex == 1) {
            if (scoreToFind >= scores.get(startIndex)) {
                return ranks.get(startIndex);
            } else if (scoreToFind >= scores.get(endIndex)) {

                return ranks.get(endIndex);
            } else if (scores.get(endIndex) > scoreToFind) {
                return ranks.get(endIndex) + 1;
            }
        } else {
            int middleIndex = (endIndex + startIndex) / 2;

            if (scores.get(middleIndex) > scoreToFind) {
                return findRankByBinarySearch(scores, middleIndex + 1, scores.size() - 1, ranks, scoreToFind);
            } else {
                return findRankByBinarySearch(scores, startIndex, middleIndex, ranks, scoreToFind);
            }
        }
        return -1;
    }

}
