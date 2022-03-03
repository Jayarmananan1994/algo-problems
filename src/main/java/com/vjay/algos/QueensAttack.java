package com.vjay.algos;

import java.util.List;

public class QueensAttack {

    public int queensAttack(int boardSize, int noOfObstacle, int r_q, int c_q, List<List<Integer>> obstacles) {
        int topDistance = topDistance(boardSize, r_q);
        int bottomDistance = bottomDistance(r_q);
        int leftDistance = leftDistance(c_q);
        int rightDistance = rightDistance(boardSize, c_q);
        int topLeftDistance = Math.min(topDistance, leftDistance);
        int bottomLeftDistance = Math.min(bottomDistance, leftDistance);
        int topRightDistance = Math.min(topDistance, rightDistance);
        int bottomRightDistance = Math.min(bottomDistance, rightDistance);
        for (List<Integer> obstacle : obstacles) {
            Integer r = obstacle.get(0);
            Integer c = obstacle.get(1);
            if (isInTopPath(obstacle, r_q, c_q)) {
                topDistance = (r - r_q - 1) < topDistance ? r - r_q - 1 : topDistance;
            } else if (isInBottomPath(obstacle, r_q, c_q)) {
                bottomDistance = (r_q - r - 1) < bottomDistance ? r_q - r - 1 : bottomDistance;
            } else if (isInLeftPath(obstacle, r_q, c_q)) {
                leftDistance = (c_q - c - 1) < leftDistance ? c_q - c - 1 : leftDistance;
            } else if (isInRightPath(obstacle, r_q, c_q)) {
                rightDistance = (c - c_q - 1) < rightDistance ? c - c_q - 1 : rightDistance;
            } else if (isInBottomRightPath(obstacle, r_q, c_q)) {
                bottomRightDistance = (c-c_q-1) < bottomRightDistance ? c-c_q-1 : bottomRightDistance;
            } else if (isInBottomLeftPath(obstacle, r_q, c_q)) {
                bottomLeftDistance = (c_q-c-1) < bottomLeftDistance ? c_q-c-1 : bottomLeftDistance;
            } else if (isInTopRightPath(boardSize, obstacle, r_q, c_q)) {
                topRightDistance = (c-c_q-1) < topRightDistance ? c-c_q-1 : topRightDistance;
            }else if (isInTopLeftPath(obstacle, r_q, c_q)) {
                topLeftDistance = (c_q-c-1) < topLeftDistance ? c_q-c-1 : topLeftDistance;
            }

        }

        return topDistance + bottomDistance + leftDistance + rightDistance
                + topLeftDistance + bottomLeftDistance + topRightDistance + bottomRightDistance;
    }

    private static int rightDistance(int boardSize, int c_q) {
        return boardSize - c_q;
    }

    private static int leftDistance(int c_q) {
        return c_q - 1;
    }

    private static int bottomDistance(int r_q) {
        return r_q - 1;
    }

    private static int topDistance(int boardSize, int r_q) {
        return boardSize - r_q;
    }

    private static boolean isInTopRightPath(int boardSize, List<Integer> obstacle, int r_q, int c_q) {
        int max = Math.min(topDistance(boardSize, r_q), rightDistance(boardSize, c_q));
        Integer r = obstacle.get(0);
        Integer c = obstacle.get(1);
        return r <= (r_q + max) && c <= (c_q + max) &&
                r > r_q && c > c_q && ((r - c) == (r_q - c_q));
    }

    private static boolean isInBottomLeftPath(List<Integer> obstacle, int r_q, int c_q) {
        int max = Math.min(bottomDistance(r_q), leftDistance(c_q));
        Integer r = obstacle.get(0);
        Integer c = obstacle.get(1);
        return r >= (r_q - max) && c >= (c_q - max) &&
                r < r_q && c < c_q && ((r - c) == (r_q - c_q));
    }

    private static boolean isInTopLeftPath(List<Integer> obstacle, int r_q, int c_q) {
        Integer r = obstacle.get(0);
        Integer c = obstacle.get(1);
        return (r_q + c_q == r + c) && r > r_q && c < c_q;
    }

    private static boolean isInBottomRightPath(List<Integer> obstacle, int r_q, int c_q) {
        Integer r = obstacle.get(0);
        Integer c = obstacle.get(1);
        return (r_q + c_q == r + c) && r < r_q && c > c_q;
    }

    private static boolean isInLeftPath(List<Integer> obstacle, int r_q, int c_q) {
        return r_q == obstacle.get(0) && obstacle.get(1) < c_q;
    }

    private static boolean isInRightPath(List<Integer> obstacle, int r_q, int c_q) {
        return r_q == obstacle.get(0) && obstacle.get(1) > c_q;
    }

    private static boolean isInBottomPath(List<Integer> obstacle, int r_q, int c_q) {
        return c_q == obstacle.get(1) && r_q > obstacle.get(0);
    }

    private static boolean isInTopPath(List<Integer> obstacle, int r_q, int c_q) {
        return c_q == obstacle.get(1) && r_q < obstacle.get(0);
    }

}