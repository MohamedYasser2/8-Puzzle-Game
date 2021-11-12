package com.company;

import java.util.*;


public class DFS extends IPuzzleSolver{
    /*
    Implementing the dfs algorithm for solving 8-puzzle game using a stack for frontiers
    returns the path from the initial state to the goal state
    or empty list in case that the puzzle is unsolvable
    */
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
