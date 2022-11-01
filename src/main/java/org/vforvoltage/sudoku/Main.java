package org.vforvoltage.sudoku;

import org.vforvoltage.sudoku.model.SudokuBoard;

import static org.vforvoltage.sudoku.util.TestBoards.ALL_ZEROS;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SudokuBoard board = new SudokuBoard(ALL_ZEROS());
        System.out.println(board);
        System.out.println(board.isFull());
        System.out.println(board.isValid());
    }
}