package com.example.alesyamikhnyuik.tictac;

/**
 * Created by Alesya Mikhnyuik on 17.01.2018.
 */

public class Cell {
    private Coordinates coordinates;
    private char symbol;


    Cell(Coordinates coordinates){
        this.coordinates = coordinates;
        this.symbol = '-';
    }


    Cell (Coordinates coordinates, char symbol){
        this.coordinates = coordinates;
        this.symbol = symbol;
    }

    Cell(int row, int column, char symbol){
        this.coordinates = new Coordinates(row,column);
        this.symbol = symbol;
    }


    public char getSymbol() {
        return symbol;
    }


    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }


    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return Character.toString(this.symbol);
    }
}


