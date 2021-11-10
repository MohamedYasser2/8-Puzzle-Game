package com.company;

import java.util.*;


public class DFS {
    public static void main(String[]args){
        String initial = "132456780";
        System.out.println(new DFS().dfs(initial));
    }
    String goalState = "123456780";
    public boolean dfs (String initialState) {
        Stack<String> frontier = new Stack<>();
        frontier.add(initialState);
        Set<String> visitedStates = new HashSet<>();
        while (!frontier.isEmpty()) {
            String currentState = frontier.pop();
            System.out.println(currentState);
            visitedStates.add(currentState);
            if (currentState.equals(goalState)) return true;
            generateNeighbors(currentState, frontier, visitedStates);
        }
        return false;
    }
    private void generateNeighbors(String state, Stack<String> frontier, Set<String> visited) {
        int index = state.indexOf('0');
        switch (index) {
            case 0:
            String right0 = swapChar(state, index, index + 1);
            String down0 = swapChar(state, index, index + 3);
            if (!visited.contains(down0)) {
                frontier.push(down0);
            }
            if (!visited.contains(right0)) {
                frontier.push(right0);
            }
            break;
            case 1:
                String right1 = swapChar(state, index, index + 1);
                String down1 = swapChar(state, index, index + 3);
                String left1 = swapChar(state, index, index - 1);
                if (!visited.contains(down1)) {
                    frontier.push(down1);
                }
                if (!visited.contains(left1)) {
                    frontier.push(left1);
                }
                if (!visited.contains(right1)) {
                    frontier.push(right1);
                }
                break;
            case 2:
                String down2 = swapChar(state, index, index + 3);
                String left2 = swapChar(state, index, index - 1);
                if (!visited.contains(down2)) {
                    frontier.push(down2);
                }
                if (!visited.contains(left2)) {
                    frontier.push(left2);
                }
                break;
            case 3:
                String right3 = swapChar(state, index, index + 1);
                String down3 = swapChar(state, index, index + 3);
                String up3 = swapChar(state, index, index - 3);
                if (!visited.contains(up3)) {
                    frontier.push(up3);
                }
                if (!visited.contains(down3)) {
                    frontier.push(down3);
                }
                if (!visited.contains(right3)) {
                    frontier.push(right3);
                }
                break;
            case 4:
                String right4 = swapChar(state, index, index + 1);
                String down4 = swapChar(state, index, index + 3);
                String left4 = swapChar(state, index, index - 1);
                String up4 = swapChar(state, index, index - 3);
                if (!visited.contains(up4)) {
                    frontier.push(up4);
                }
                if (!visited.contains(down4)) {
                    frontier.push(down4);
                }
                if (!visited.contains(left4)) {
                    frontier.push(left4);
                }
                if (!visited.contains(right4)) {
                    frontier.push(right4);
                }
                break;
            case 5:
                String down5 = swapChar(state, index, index + 3);
                String left5 = swapChar(state, index, index - 1);
                String up5 = swapChar(state, index, index - 3);
                if (!visited.contains(up5)) {
                    frontier.push(up5);
                }
                if (!visited.contains(down5)) {
                    frontier.push(down5);
                }
                if (!visited.contains(left5)) {
                    frontier.push(left5);
                }
                break;
            case 6:
                String right6 = swapChar(state, index, index + 1);
                String up6 = swapChar(state, index, index - 3);
                if (!visited.contains(up6)) {
                    frontier.push(up6);
                }
                if (!visited.contains(right6)) {
                    frontier.push(right6);
                }
                break;
            case 7:
                String right7 = swapChar(state, index, index + 1);
                String left7 = swapChar(state, index, index - 1);
                String up7 = swapChar(state, index, index - 3);
                if (!visited.contains(up7)) {
                    frontier.push(up7);
                }
                if (!visited.contains(left7)) {
                    frontier.push(left7);
                }
                if (!visited.contains(right7)) {
                    frontier.push(right7);
                }
                break;
            case 8:
                String left8 = swapChar(state, index, index - 1);
                String up8 = swapChar(state, index, index - 3);
                if (!visited.contains(up8)) {
                    frontier.push(up8);
                }
                if (!visited.contains(left8)) {
                    frontier.push(left8);
                }
                break;
        }
    }

    private  String swapChar(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(i), r = sb.charAt(j);
        sb.setCharAt(i, r);
        sb.setCharAt(j, l);
        return sb.toString();
    }
}
