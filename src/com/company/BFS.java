package com.company;

import java.util.*;

public class BFS extends IPuzzleSolver{

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

