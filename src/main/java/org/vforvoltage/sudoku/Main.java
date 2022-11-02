package org.vforvoltage.sudoku;

import org.vforvoltage.sudoku.model.SudokuBoard;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isFull;
import static org.vforvoltage.sudoku.util.BoardStatusChecker.isValid;
import static org.vforvoltage.sudoku.util.TestBoards.ALL_ZEROS;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SudokuBoard board = new SudokuBoard(ALL_ZEROS());
        System.out.println(board);
        System.out.println(isFull(board));
        System.out.println(isValid(board));
    }
}