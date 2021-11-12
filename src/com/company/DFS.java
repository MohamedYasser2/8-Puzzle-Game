package com.company;

import java.util.*;


public class DFS extends IPuzzleSolver{
    @Override
    public List<String> solvePuzzle(String initialState) {
        frontierStack.add(initialState);
        while (!frontierStack.isEmpty()) {
            String currentState = frontierStack.pop();
            visited.add(currentState);
            if (currentState.equals(goalState)) {
                getPath(currentState, initialState);
                Collections.reverse(pathList);
                pathList.add(goalState);
                return pathList;
            }
            generateNeighbors(currentState, Algorithm.DFS);
        }
        return new ArrayList<>();
    }
}
