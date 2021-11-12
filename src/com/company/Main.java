package com.company;

public class Main {

    public static void main(String[] args) {
        IPuzzleSolver solver = new BFS();
        IPuzzleSolver solver2 = new DFS();
        System.out.println(solver.solvePuzzle("123456708"));
        IPuzzleSolver solver3 = new InformedSearch();
        System.out.println(solver3.solvePuzzle("123456708"));

        System.out.println(solver2.solvePuzzle("012364578"));

    }
}
