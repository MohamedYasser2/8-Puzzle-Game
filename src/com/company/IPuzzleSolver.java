package com.company;

import java.util.*;

public abstract class IPuzzleSolver {
    /*
    Data Structures used in different solving algorithms
     */
    Map<String, String> hashMap= new HashMap<>();
    List<String> pathList = new ArrayList<>();
    Queue<String> frontierQueue = new LinkedList();
    Stack<String> frontierStack = new Stack<>();
    Set<String> visited = new HashSet<>();
    PriorityQueue<State> frontierPriorityQueue = new PriorityQueue<>();
    String goalState = " 12345678";


    public abstract List<String> solvePuzzle(String initialState);

    /*
    A function that is called after solving the puzzle to get the path
    from the initial state to the goal state from the hash map
    */
    public void getPath(String state, String initialState) {
        if (hashMap.containsKey(state)) {
            String path = hashMap.get(state);
            pathList.add(path);
            while (!path.equals(initialState)) {
                path = hashMap.get(path);
                pathList.add(path);
            }
        }
    }

    /*
    A function that performs every move in the puzzle
    by swapping the '0' character with another character
    and returning the updated string after performing the puzzle move
    */
    public static String swapChar(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        char l = sb.charAt(i), r = sb.charAt(j);
        sb.setCharAt(i, r);
        sb.setCharAt(j, l);
        return sb.toString();
    }

    /*
    A function that takes the current state of the puzzle as a parameter
    and according to the position of '0',
    It generates all the neighbors of '0' that the '0' can be moved to
    and push them to the suitable frontier data structure
    according to the used algorithm for solving the puzzle
    */
    public void generateNeighbors(String state, Algorithm algorithm) {
        int index = state.indexOf(" ");
        switch (index) {
            case 0:
                String right0 = swapChar(state , index , index+1);
                String down0 = swapChar(state , index , index+3);
                addNeighborToFrontier(state, down0, algorithm);
                addNeighborToFrontier(state, right0, algorithm);
                break;
            case 1:
                String right1 = swapChar(state , index , index+1);
                String down1 = swapChar(state , index , index+3);
                String left1 = swapChar(state , index , index-1);
                addNeighborToFrontier(state, down1, algorithm);
                addNeighborToFrontier(state, left1, algorithm);
                addNeighborToFrontier(state, right1, algorithm);
                break;
            case 2:
                String down2 = swapChar(state , index , index+3);
                String left2 = swapChar(state , index , index-1);
                addNeighborToFrontier(state, down2, algorithm);
                addNeighborToFrontier(state, left2, algorithm);
                break;
            case 3:
                String right3 = swapChar(state , index , index+1);
                String down3 = swapChar(state , index , index+3);
                String up3 = swapChar(state , index , index-3);
                addNeighborToFrontier(state, down3, algorithm);
                addNeighborToFrontier(state, up3, algorithm);
                addNeighborToFrontier(state, right3, algorithm);
                break;
            case 4:
                String right4 = swapChar(state , index , index+1);
                String down4 = swapChar(state , index , index+3);
                String left4 = swapChar(state , index , index-1);
                String up4 = swapChar(state , index , index-3);
                addNeighborToFrontier(state, down4, algorithm);
                addNeighborToFrontier(state, up4, algorithm);
                addNeighborToFrontier(state, left4, algorithm);
                addNeighborToFrontier(state, right4, algorithm);
                break;
            case 5:
                String down5 = swapChar(state , index , index+3);
                String left5 = swapChar(state , index , index-1);
                String up5 = swapChar(state , index , index-3);
                addNeighborToFrontier(state, down5, algorithm);
                addNeighborToFrontier(state, up5, algorithm);
                addNeighborToFrontier(state, left5, algorithm);
                break;
            case 6:
                String right6 = swapChar(state , index , index+1);
                String up6 = swapChar(state , index , index-3);
                addNeighborToFrontier(state, up6, algorithm);
                addNeighborToFrontier(state, right6, algorithm);
                break;
            case 7:
                String right7 = swapChar(state , index , index+1);
                String left7 = swapChar(state , index , index-1);
                String up7 = swapChar(state , index , index-3);
                addNeighborToFrontier(state, up7, algorithm);
                addNeighborToFrontier(state, left7, algorithm);
                addNeighborToFrontier(state, right7, algorithm);
                break;
            case 8:
                String left8 = swapChar(state , index , index-1);
                String up8 = swapChar(state , index , index-3);
                addNeighborToFrontier(state, up8, algorithm);
                addNeighborToFrontier(state, left8, algorithm);
                break;
        }
    }
    /*
    A function that push every generated neighbor of '0'
    to the suitable frontier data structure
    according to the used algorithm for solving the puzzle
    */
    private void addNeighborToFrontier(String parentState, String childState, Algorithm algorithm) {
        switch (algorithm) {
            case BFS:
                if (!visited.contains(childState)) {
                    frontierQueue.add(childState);
                    hashMap.put(childState , parentState);
                }
                break;
            case DFS:
                if (!visited.contains(childState)) {
                    frontierStack.add(childState);
                    hashMap.put(childState , parentState);
                }
                break;
            default:
                break;
        }
    }

    public boolean inFrontier(String state,int key){
        Iterator it = frontierPriorityQueue.iterator();
        while (it.hasNext()){
            State tem = (State) it.next();
            if (tem.getValue().equals(state)) {
                frontierPriorityQueue.remove(tem);
                tem.setKey(Math.min(tem.getKey(),key));
                frontierPriorityQueue.add(tem);
                return true;
            }
        }
        return false;
    }
}

