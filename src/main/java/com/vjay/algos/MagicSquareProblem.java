package com.vjay.algos;

import java.util.List;
import java.util.stream.Collectors;

public class MagicSquareProblem {

    public int formingMagicSquare(List<List<Integer>> s) {
        int minimum = Integer.MAX_VALUE;
        List<List<Integer>> possibleSolution = List.of(
               List.of(2,9,4,7,5,3,6,1,8),
               List.of(6,7,2,1,5,9,8,3,4),
               List.of(8,1,6,3,5,7,4,9,2),
               List.of(4,3,8,9,5,1,2,7,6),
               List.of(4,9,2,3,5,7,8,1,6),
               List.of(8,3,4,1,5,9,6,7,2),
               List.of(6,1,8,7,5,3,2,9,4),
               List.of(2,7,6,9,5,1,4,3,8)
       );
        List<Integer> input = s.stream().flatMap(List::stream).collect(Collectors.toList());
        for(List<Integer> sol : possibleSolution) {
            int diff = calculateDif(input, sol);
            if(diff==1 || diff == 0) {
                minimum = diff;
                break;
            }else if(diff< minimum) {
                minimum = diff;
            }
        }
        return minimum;
    }

    private int calculateDif(List<Integer> input, List<Integer> sol) {
        int diff = 0;
        for(int i=0; i< sol.size(); i++) {
            if( input.get(i) != sol.get(i)) {
                diff += Math.abs(input.get(i) - sol.get(i));
            }
        }
        return diff;
    }


}
