package com.company;

class State implements Comparable<State> {
    private String value;
    private int key;

    public State(String value, int key) {
        this.value = value;
        this.key = key;
    }


    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    @Override
    public int compareTo(State other) {
        if (this.getKey()>other.getKey())
            return 1;
        else if(this.getKey()<other.getKey())
            return -1;
        else
            return 0;
    }
}
