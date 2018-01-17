package com.example.alesyamikhnyuik.tictac;

/**
 * Created by Alesya Mikhnyuik on 17.01.2018.
 */

public class TicTacToeBoard {
    private int nDimension;
    private Cell[][] grid;


    public TicTacToeBoard(int nDimension){
        this.nDimension = nDimension;
        initializeBoard();
    }

    public void initializeBoard(){
        grid = new Cell[nDimension][nDimension];
        for (int row = 0; row < nDimension; row++)
            for (int col = 0; col < nDimension; col++){
                grid[row][col] = new Cell(row,col,'-');
            }
    }


    public void printBoard(){
        for (int i = 0; i < nDimension; i++) {
            System.out.print("| ");
            for (int j = 0; j < nDimension; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public boolean isValidMove(Coordinates coordinates) {

        if (coordinates.getRow() > nDimension - 1 || coordinates.getCol() > nDimension - 1) {
            int x = coordinates.getRow() + 1;
            int y = coordinates.getCol() + 1;

            System.out.println("(" + x + "," + y + ")" + " is not a valid move!");
            return false;
        }


        if (coordinates.getRow() == 0 - 1 && coordinates.getCol() == 0 - 1){
            int x = coordinates.getRow() + 1;
            int y = coordinates.getCol() + 1;

            System.out.println("(" + x + "," + y + ")" + " is not a valid move!");
            return false;
        }


        if (grid[coordinates.getRow()][coordinates.getCol()].getSymbol() != '-') {
            int x = coordinates.getRow() + 1;
            int y = coordinates.getCol() + 1;

            System.out.println("(" + x + " , " + y + ")" + " is not a valid move!");
            return false;
        }

        return true;
    }


    public void makeMove(Coordinates coordinates, char playerSymbol){
        grid[coordinates.getRow()][coordinates.getCol()].setSymbol(playerSymbol);
    }


    public boolean isWinner(char playerSymbol) {

        return (isRowWin(playerSymbol) || isColumnWin(playerSymbol) || isDiagnalWin(playerSymbol));

    }


    private boolean isRowWin(char playerSymbol){
        int charctr;
        for(int x = 0; x < nDimension; x++){
            charctr = 0;
            for(int y = 0; y < nDimension; y++){
                if(grid[x][y].getSymbol() == playerSymbol){
                    charctr++;
                }
                if(charctr == nDimension){
                    System.out.println("\nCongratulations, " + playerSymbol + " wins!");
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isColumnWin(char playerSymbol) {
        int charctr;
        for(int y = 0; y < nDimension; y++){
            charctr = 0;
            for(int x = 0; x < nDimension; x++){
                if(grid[x][y].getSymbol() == playerSymbol){
                    charctr++;
                }
                if(charctr == nDimension){
                    System.out.println("\nCongratulations, " + playerSymbol + " wins!");
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isDiagnalWin(char playerSymbol) {
        int charctr = 0;
        int charctr2 = 0;
        for (int d = 0; d < nDimension; d++) {
            if (grid[d][d].getSymbol() == playerSymbol) {
                charctr++;
            }
            if (grid[d][nDimension-d-1].getSymbol() == playerSymbol){
                charctr2++;
            }
            if (charctr == nDimension || charctr2 == nDimension) {
                System.out.println("\nCongratulations, " + playerSymbol + " wins!");
                return true;
            }
        }
        return false;
    }


    public boolean isFull() {
        for(int x = 0; x < nDimension; x++){
            for(int y = 0; y < nDimension; y++){
                if(grid[x][y].getSymbol() == '-'){
                    return false;
                }
            }
        }
        System.out.println("\nThe game is a scratch :(. \n");
        return true;
    }

    @Override
    public String toString() {
        String boardStr = "";
        for (int row = 0; row < nDimension; row++){
            for (int col = 0; col < nDimension; col++){
                Cell curCell = grid[row][col];
                String cellStr = curCell.toString();
                boardStr += cellStr;
            }
            boardStr += '\n';
        }
        return boardStr;
    }

}
