package org.vforvoltage.sudoku.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuBoard {

    private final int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public boolean isValid() {
        return areRowsValid() && areColumnsValid() && areSquaresValid();
    }

    private boolean areRowsValid() {
        for(int row = 0; row < 9; row++) {
            Set<Integer> dupes = new HashSet<>();
            for (int column = 0; column < 9; column++) {
                if(board[row][column] != 0) {
                    boolean isDupe = !dupes.add(board[row][column]);
                    if(isDupe) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean areColumnsValid() {
        for(int column = 0; column < 9; column++) {
            Set<Integer> dupes = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if(board[row][column] != 0) {
                    boolean isDupe = !dupes.add(board[row][column]);
                    if(isDupe) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean areSquaresValid() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Set<Integer> dupes = new HashSet<>();
                for(int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        int x = (i * 3) + row;
                        int y = (j * 3) + column;
                        if(board[x][y] != 0) {
                            boolean isDupe = !dupes.add(board[x][y]);
                            if(isDupe) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isFull() {
        for(int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if(board[row][column] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSolved() {
        return isValid() && isFull();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(board).forEach(i -> sb.append(Arrays.toString(i)).append("\n"));
        return sb.toString();
    }
}
