package com.company;

public class Main {

    public static void main(String[] args) {
        IPuzzleSolver solver = new BFS();
        IPuzzleSolver solver2 = new DFS();
        System.out.println(solver.solvePuzzle("123456708".replace("0", " ")));
        IPuzzleSolver solver3 = new InformedSearchManhattan();
        System.out.println(solver3.solvePuzzle("123456708".replace("0", " ")));

//        System.out.println(solver2.solvePuzzle("123456708".replace("0", " ")));

    }
}
