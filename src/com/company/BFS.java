package com.company;

import java.util.*;

public class BFS implements IPuzzleSolver{


    Queue<String> queue = new LinkedList();
    Set<String> visited = new HashSet<>();
    HashMap<String, String> hashMap= new HashMap<String, String>();
    ArrayList<String> pathList = new ArrayList<>();
    String goalState = "012345678";

    public void neighbors(String state){
        int index = state.indexOf('0');
        switch (index){
            case 0:
                String right0 = swapChar(state , index , index+1);
                String down0 = swapChar(state , index , index+3);
                if (!visited.contains(down0)) {
                    queue.add(down0);
                    hashMap.put(down0 , state);
                }
                if (!visited.contains(right0)) {
                    queue.add(right0);
                    hashMap.put(right0 , state);
                }
                break;
            case 1:
                String right1 = swapChar(state , index , index+1);
                String down1 = swapChar(state , index , index+3);
                String left1 = swapChar(state , index , index-1);
                if (!visited.contains(down1)) {
                    queue.add(down1);
                    hashMap.put(down1 , state);
                }
                if (!visited.contains(left1)) {
                    queue.add(left1);
                    hashMap.put(left1 , state);
                }
                if (!visited.contains(right1)) {
                    queue.add(right1);
                    hashMap.put(right1 , state);
                }
                break;
            case 2:
                String down2 = swapChar(state , index , index+3);
                String left2 = swapChar(state , index , index-1);
                if (!visited.contains(down2)) {
                    queue.add(down2);
                    hashMap.put(down2 , state);
                }
                if (!visited.contains(left2)) {
                    queue.add(left2);
                    hashMap.put(left2 , state);
                }
                break;
            case 3:
                String right3 = swapChar(state , index , index+1);
                String down3 = swapChar(state , index , index+3);
                String up3 = swapChar(state , index , index-3);
                if (!visited.contains(up3)) {
                    queue.add(up3);
                    hashMap.put(up3 , state);
                }
                if (!visited.contains(down3)) {
                    queue.add(down3);
                    hashMap.put(down3 , state);
                }
                if (!visited.contains(right3)) {
                    queue.add(right3);
                    hashMap.put(right3 , state);
                }
                break;
            case 4:
                String right4 = swapChar(state , index , index+1);
                String down4 = swapChar(state , index , index+3);
                String left4 = swapChar(state , index , index-1);
                String up4 = swapChar(state , index , index-3);
                if (!visited.contains(up4)) {
                    queue.add(up4);
                    hashMap.put(up4 , state);
                }
                if (!visited.contains(down4)) {
                    queue.add(down4);
                    hashMap.put(down4 , state);
                }
                if (!visited.contains(left4)) {
                    queue.add(left4);
                    hashMap.put(left4 , state);
                }
                if (!visited.contains(right4)) {
                    queue.add(right4);
                    hashMap.put(right4 , state);
                }
                break;
            case 5:
                String down5 = swapChar(state , index , index+3);
                String left5 = swapChar(state , index , index-1);
                String up5 = swapChar(state , index , index-3);
                if (!visited.contains(up5)) {
                    queue.add(up5);
                    hashMap.put(up5 , state);
                }
                if (!visited.contains(down5)) {
                    queue.add(down5);
                    hashMap.put(down5 , state);
                }
                if (!visited.contains(left5)) {
                    queue.add(left5);
                    hashMap.put(left5 , state);
                }
                break;
            case 6:
                String right6 = swapChar(state , index , index+1);
                String up6 = swapChar(state , index , index-3);
                if (!visited.contains(up6)) {
                    queue.add(up6);
                    hashMap.put(up6 , state);
                }
                if (!visited.contains(right6)) {
                    queue.add(right6);
                    hashMap.put(right6 , state);
                }
                break;
            case 7:
                String right7 = swapChar(state , index , index+1);
                String left7 = swapChar(state , index , index-1);
                String up7 = swapChar(state , index , index-3);
                if (!visited.contains(up7)) {
                    queue.add(up7);
                    hashMap.put(up7 , state);
                }
                if (!visited.contains(left7)) {
                    queue.add(left7);
                    hashMap.put(left7 , state);
                }
                if (!visited.contains(right7)) {
                    queue.add(right7);
                    hashMap.put(right7 , state);
                }
                break;
            case 8:
                String left8 = swapChar(state , index , index-1);
                String up8 = swapChar(state , index , index-3);
                if (!visited.contains(up8)) {
                    queue.add(up8);
                    hashMap.put(up8 , state);

                }
                if (!visited.contains(left8)) {
                    queue.add(left8);
                    hashMap.put(left8 , state);
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


    public void getPath(String state){
        while (hashMap.containsKey(state)){
            String path = hashMap.get(state);
            pathList.add(path);
            state = path;
        }
    }

    @Override
    public List<String> solvePuzzle(String initialState) {
        queue.add(initialState);
        while (!queue.isEmpty()){
            String top = queue.poll();
            visited.add(top);
            if (top.equals(goalState)){
                getPath(top );
                Collections.reverse(pathList);
                return pathList;
            }
            neighbors(top);
        }

        return new ArrayList<>();
    }

//    public  Boolean Bfs(String initialState , String goalState){
//        queue.add(initialState);
//        while (!queue.isEmpty()){
//            String top = queue.poll();
//            visited.add(top);
//            if (top.equals(goalState)){
//                getPath(top );
//                Collections.reverse(pathList);
//                System.out.println(pathList);
//                return true;
//            }
//            neighbors(top);
//        }
//
//        return false;
//    }
}

