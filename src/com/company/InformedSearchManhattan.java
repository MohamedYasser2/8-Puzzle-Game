package com.company;

import java.util.*;


public class InformedSearchManhattan extends IPuzzleSolver{

    @Override
    public List<String> solvePuzzle(String initialState) {
        pathList = new ArrayList<>();
        visited = new HashSet<>();
        frontierPriorityQueue = new PriorityQueue<>();
        frontierPriorityQueue.add(new State(initialState,ManhattanDistance(initialState)));
        while (!frontierPriorityQueue.isEmpty()) {
            State top = frontierPriorityQueue.poll();
            visited.add(top.getValue());
            if (top.getValue().equals(goalState)){
                getPath(top.getValue(), initialState);
                Collections.reverse(pathList);
                pathList.add(goalState);
                return pathList;
            }
            neighbors(top);
        }
        return new ArrayList<>();
    }



    public static int ManhattanDistance(String st){
        int result = 0,x=0,y=0,xg=0,yg=0;
        for (int i=0;i<9;++i){
            switch (i){
                case 0:
                    xg=1;
                    yg=1;
                    break;
                case 1:
                    xg=2;
                    yg=1;
                    break;
                case 2:
                    xg=3;
                    yg=1;
                    break;
                case 3:
                    xg=1;
                    yg=2;
                    break;
                case 4:
                    xg=2;
                    yg=2;
                    break;
                case 5:
                    xg=3;
                    yg=2;
                    break;
                case 6:
                    xg=1;
                    yg=3;
                    break;
                case 7:
                    xg=2;
                    yg=3;
                    break;
                case 8:
                    xg=3;
                    yg=3;
                    break;
            }
            int ind = st.indexOf(Integer.toString(i));
            switch (ind){
                case 0:
                    x=1;
                    y=1;
                    break;
                case 1:
                    x=2;
                    y=1;
                    break;
                case 2:
                    x=3;
                    y=1;
                    break;
                case 3:
                    x=1;
                    y=2;
                    break;
                case 4:
                    x=2;
                    y=2;
                    break;
                case 5:
                    x=3;
                    y=2;
                    break;
                case 6:
                    x=1;
                    y=3;
                    break;
                case 7:
                    x=2;
                    y=3;
                    break;
                case 8:
                    x=3;
                    y=3;
                    break;
            }
            result+= Math.abs(x-xg)+Math.abs(y-yg);
        }
        return result;
    }


    public void neighbors(State state) {
        int index = state.getValue().indexOf(' ');
        switch (index){
            case 0:
                String right0 = swapChar(state.getValue() , index , index+1);
                String down0 = swapChar(state.getValue() , index , index+3);
                if (!visited.contains(down0) && !inFrontier(down0,calcKey(state,down0))) {
                    frontierPriorityQueue.add(new State(down0,calcKey(state,down0)));
                    hashMap.put(down0 , state.getValue());
                }
                if (!visited.contains(right0) && !inFrontier(right0,calcKey(state,right0))) {
                    frontierPriorityQueue.add(new State(right0,calcKey(state,right0)));
                    hashMap.put(right0 , state.getValue());
                }
                break;
            case 1:
                String right1 = swapChar(state.getValue() , index , index+1);
                String down1 = swapChar(state.getValue() , index , index+3);
                String left1 = swapChar(state.getValue() , index , index-1);
                if (!visited.contains(down1) && !inFrontier(down1,calcKey(state,down1))) {
                    frontierPriorityQueue.add(new State(down1,calcKey(state,down1)));
                    hashMap.put(down1 , state.getValue());
                }
                if (!visited.contains(left1) && !inFrontier(left1,calcKey(state,left1))) {
                    frontierPriorityQueue.add(new State(left1,calcKey(state,left1)));
                    hashMap.put(left1 , state.getValue());
                }
                if (!visited.contains(right1) && !inFrontier(right1,calcKey(state,right1))) {
                    frontierPriorityQueue.add(new State(right1,calcKey(state,right1)));
                    hashMap.put(right1 , state.getValue());
                }
                break;
            case 2:
                String down2 = swapChar(state.getValue() , index , index+3);
                String left2 = swapChar(state.getValue() , index , index-1);
                if (!visited.contains(down2) && !inFrontier(down2,calcKey(state,down2))) {
                    frontierPriorityQueue.add(new State(down2,calcKey(state,down2)));
                    hashMap.put(down2 , state.getValue());
                }
                if (!visited.contains(left2) && !inFrontier(left2,calcKey(state,left2))) {
                    frontierPriorityQueue.add(new State(left2,calcKey(state,left2)));
                    hashMap.put(left2 , state.getValue());
                }
                break;
            case 3:
                String right3 = swapChar(state.getValue() , index , index+1);
                String down3 = swapChar(state.getValue() , index , index+3);
                String up3 = swapChar(state.getValue() , index , index-3);
                if (!visited.contains(up3) && !inFrontier(up3,calcKey(state,up3))) {
                    frontierPriorityQueue.add(new State(up3,calcKey(state,up3)));
                    hashMap.put(up3 , state.getValue());
                }
                if (!visited.contains(down3) && !inFrontier(down3,calcKey(state,down3))) {
                    frontierPriorityQueue.add(new State(down3,calcKey(state,down3)));
                    hashMap.put(down3 , state.getValue());
                }
                if (!visited.contains(right3) && !inFrontier(right3,calcKey(state,right3))) {
                    frontierPriorityQueue.add(new State(right3,calcKey(state,right3)));
                    hashMap.put(right3 , state.getValue());
                }
                break;
            case 4:
                String right4 = swapChar(state.getValue() , index , index+1);
                String down4 = swapChar(state.getValue() , index , index+3);
                String left4 = swapChar(state.getValue() , index , index-1);
                String up4 = swapChar(state.getValue() , index , index-3);
                if (!visited.contains(up4) && !inFrontier(up4,calcKey(state,up4))) {
                    frontierPriorityQueue.add(new State(up4,calcKey(state,up4)));
                    hashMap.put(up4 , state.getValue());
                }
                if (!visited.contains(down4) && !inFrontier(down4,calcKey(state,down4))) {
                    frontierPriorityQueue.add(new State(down4,calcKey(state,down4)));
                    hashMap.put(down4 , state.getValue());
                }
                if (!visited.contains(left4) && !inFrontier(left4,calcKey(state,left4))) {
                    frontierPriorityQueue.add(new State(left4,calcKey(state,left4)));
                    hashMap.put(left4 , state.getValue());
                }
                if (!visited.contains(right4) && !inFrontier(right4,calcKey(state,right4))) {
                    frontierPriorityQueue.add(new State(right4,calcKey(state,right4)));
                    hashMap.put(right4 , state.getValue());
                }
                break;
            case 5:
                String down5 = swapChar(state.getValue() , index , index+3);
                String left5 = swapChar(state.getValue() , index , index-1);
                String up5 = swapChar(state.getValue() , index , index-3);
                if (!visited.contains(up5) && !inFrontier(up5,calcKey(state,up5))) {
                    frontierPriorityQueue.add(new State(up5,calcKey(state,up5)));
                    hashMap.put(up5 , state.getValue());
                }
                if (!visited.contains(down5) && !inFrontier(down5,calcKey(state,down5))) {
                    frontierPriorityQueue.add(new State(down5,calcKey(state,down5)));
                    hashMap.put(down5 , state.getValue());
                }
                if (!visited.contains(left5) && !inFrontier(left5,calcKey(state,left5))) {
                    frontierPriorityQueue.add(new State(left5,calcKey(state,left5)));
                    hashMap.put(left5 , state.getValue());
                }
                break;
            case 6:
                String right6 = swapChar(state.getValue() , index , index+1);
                String up6 = swapChar(state.getValue() , index , index-3);
                if (!visited.contains(up6) && !inFrontier(up6,calcKey(state,up6))) {
                    frontierPriorityQueue.add(new State(up6,calcKey(state,up6)));
                    hashMap.put(up6 , state.getValue());
                }
                if (!visited.contains(right6) && !inFrontier(right6,calcKey(state,right6))) {
                    frontierPriorityQueue.add(new State(right6,calcKey(state,right6)));
                    hashMap.put(right6 , state.getValue());
                }
                break;
            case 7:
                String right7 = swapChar(state.getValue() , index , index+1);
                String left7 = swapChar(state.getValue() , index , index-1);
                String up7 = swapChar(state.getValue() , index , index-3);
                if (!visited.contains(up7) && !inFrontier(up7,calcKey(state,up7))) {
                    frontierPriorityQueue.add(new State(up7,calcKey(state,up7)));
                    hashMap.put(up7 , state.getValue());
                }
                if (!visited.contains(left7) && !inFrontier(left7,calcKey(state,left7))) {
                    frontierPriorityQueue.add(new State(left7,calcKey(state,left7)));
                    hashMap.put(left7 , state.getValue());
                }
                if (!visited.contains(right7) && !inFrontier(right7,calcKey(state,right7))) {
                    frontierPriorityQueue.add(new State(right7,calcKey(state,right7)));
                    hashMap.put(right7 , state.getValue());
                }
                break;
            case 8:
                String left8 = swapChar(state.getValue() , index , index-1);
                String up8 = swapChar(state.getValue() , index , index-3);
                if (!visited.contains(up8) && !inFrontier(up8,calcKey(state,up8))) {
                    frontierPriorityQueue.add(new State(up8,calcKey(state,up8)));
                    hashMap.put(up8 , state.getValue());

                }
                if (!visited.contains(left8) && !inFrontier(left8,calcKey(state,left8))) {
                    frontierPriorityQueue.add(new State(left8,calcKey(state,left8)));
                    hashMap.put(left8 , state.getValue());
                }
                break;
        }
    }
    private static int calcKey(State parent, String st){

        return (parent.getKey()-ManhattanDistance(parent.getValue()))+ManhattanDistance(st)+1;
    }




}
