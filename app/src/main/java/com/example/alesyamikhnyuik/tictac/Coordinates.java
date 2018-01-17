package com.example.alesyamikhnyuik.tictac;

/**
 * Created by Alesya Mikhnyuik on 17.01.2018.
 */

public class Coordinates {
    private int row;
    private int col;
    private boolean checkRepeat = false;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }


    public int getCol() {
        return col;
    }


    public void setCol(int col) {
        this.col = col;
    }


    public int getRow(){
        return row;
    }


    public void setRow(int row){
        this.row = row;
    }


    public boolean getCheckRepeat() {
        return checkRepeat;
    }


    public void setCheckRepeat(boolean checkRepeat) {
        this.checkRepeat = checkRepeat;
    }

    @Override
    public String toString(){
        String coordinateStr = "(" + this.row + "," + this.col + ")";
        return coordinateStr;
    }
}

