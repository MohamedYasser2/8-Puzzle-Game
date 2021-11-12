package com.company;

import java.util.*;

public class BFS extends IPuzzleSolver{
    /*
    Implementing the bfs algorithm for solving 8-puzzle game using a queue for frontiers
    returns the path from the initial state to the goal state
    or empty list in case that the puzzle is unsolvable
    */
    @Override
    public List<String> solvePuzzle(String initialState) {
        frontierQueue.add(initialState);
        while (!frontierQueue.isEmpty()){
            String top = frontierQueue.poll();
            visited.add(top);
            if (top.equals(goalState)){
                getPath(top, initialState);
                Collections.reverse(pathList);
                pathList.add(goalState);
                return pathList;
            }
            generateNeighbors(top, Algorithm.BFS);
        }
        return new ArrayList<>();
    }
}

