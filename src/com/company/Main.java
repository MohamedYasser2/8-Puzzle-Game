package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        IPuzzleSolver solver = new BFS();
        System.out.println(solver.solvePuzzle("125340678"));
    }
}
