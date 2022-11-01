package org.vforvoltage.sudoku.solving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.TestBoardHelper;
import org.vforvoltage.sudoku.model.SudokuBoard;

class BruteForceSolverTest {

    @Test
    void solveSudokuBoard() {
        SudokuBoard board = new SudokuBoard(TestBoardHelper.ALMOST_SOLVED());
        System.out.println(board);
        BruteForceSolver.solveSudokuBoard(board);
        Assertions.assertTrue(board.isSolved());

        board = new SudokuBoard(TestBoardHelper.MISSING_DIAGONAL());
        System.out.println(board);
        BruteForceSolver.solveSudokuBoard(board);
        Assertions.assertTrue(board.isSolved());

        board = new SudokuBoard(TestBoardHelper.ALL_ZEROS());
        System.out.println(board);
        BruteForceSolver.solveSudokuBoard(board);
        Assertions.assertTrue(board.isSolved());
    }
}