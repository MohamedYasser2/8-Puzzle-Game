package com.company;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        BFS test = new BFS();
        test.Bfs("125340678" , "012345678");
    }


    Queue<String> queue = new LinkedList();
    ArrayList<String> visited = new ArrayList<>();


    public  Boolean Bfs(String initialState , String goalState){
        queue.add(initialState);
        while (!queue.isEmpty()){
            String top = queue.remove();
            visited.add(top);
            if (top.equals(goalState)){
                return true;
            }
            neighbors(top);
        }

        return true;
    }


    public void neighbors(String state){
        int index = state.indexOf('0');
        switch (index){
            case 0:
                String right0 = swapChar(state , index , index+1);
                String down0 = swapChar(state , index , index+3);
                if (!visited.contains(down0)) {
                    queue.add(down0);
                }
                if (!visited.contains(right0)) {
                    queue.add(right0);
                }
                break;
            case 1:
                String right1 = swapChar(state , index , index+1);
                String down1 = swapChar(state , index , index+3);
                String left1 = swapChar(state , index , index-1);
                if (!visited.contains(down1)) {
                    queue.add(down1);
                }
                if (!visited.contains(left1)) {
                    queue.add(left1);
                }
                if (!visited.contains(right1)) {
                    queue.add(right1);
                }
                break;
            case 2:
                String down2 = swapChar(state , index , index+3);
                String left2 = swapChar(state , index , index-1);
                if (!visited.contains(down2)) {
                    queue.add(down2);
                }
                if (!visited.contains(left2)) {
                    queue.add(left2);
                }
                break;
            case 3:
                String right3 = swapChar(state , index , index+1);
                String down3 = swapChar(state , index , index+3);
                String up3 = swapChar(state , index , index-3);
                if (!visited.contains(up3)) {
                    queue.add(up3);
                }
                if (!visited.contains(down3)) {
                    queue.add(down3);
                }
                if (!visited.contains(right3)) {
                    queue.add(right3);
                }
                break;
            case 4:
                String right4 = swapChar(state , index , index+1);
                String down4 = swapChar(state , index , index+3);
                String left4 = swapChar(state , index , index-1);
                String up4 = swapChar(state , index , index-3);
                if (!visited.contains(up4)) {
                    queue.add(up4);
                }
                if (!visited.contains(down4)) {
                    queue.add(down4);
                }
                if (!visited.contains(left4)) {
                    queue.add(left4);
                }
                if (!visited.contains(right4)) {
                    queue.add(right4);
                }
                break;
            case 5:
                String down5 = swapChar(state , index , index+3);
                String left5 = swapChar(state , index , index-1);
                String up5 = swapChar(state , index , index-3);
                if (!visited.contains(up5)) {
                    queue.add(up5);
                }
                if (!visited.contains(down5)) {
                    queue.add(down5);
                }
                if (!visited.contains(left5)) {
                    queue.add(left5);
                }
                break;
            case 6:
                String right6 = swapChar(state , index , index+1);
                String up6 = swapChar(state , index , index-3);
                if (!visited.contains(up6)) {
                    queue.add(up6);
                }
                if (!visited.contains(right6)) {
                    queue.add(right6);
                }
                break;
            case 7:
                String right7 = swapChar(state , index , index+1);
                String left7 = swapChar(state , index , index-1);
                String up7 = swapChar(state , index , index-3);
                if (!visited.contains(up7)) {
                    queue.add(up7);
                }
                if (!visited.contains(left7)) {
                    queue.add(left7);
                }
                if (!visited.contains(right7)) {
                    queue.add(right7);
                }
                break;
            case 8:
                String left8 = swapChar(state , index , index-1);
                String up8 = swapChar(state , index , index-3);
                if (!visited.contains(up8)) {
                    queue.add(up8);
                }
                if (!visited.contains(left8)) {
                    queue.add(left8);
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
