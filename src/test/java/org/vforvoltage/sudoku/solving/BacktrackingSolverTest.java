package org.vforvoltage.sudoku.solving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.TestBoardHelper;
import org.vforvoltage.sudoku.model.OriginalSudokuBoard;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;

class BacktrackingSolverTest {

    @Test
    void solveSudokuBoard() {
        OriginalSudokuBoard board = new OriginalSudokuBoard(TestBoardHelper.ALMOST_SOLVED());
        BacktrackingSolver.solveSudokuBoard(board);
        Assertions.assertTrue(isSolved(board));

        board = new OriginalSudokuBoard(TestBoardHelper.MISSING_DIAGONAL());
        BacktrackingSolver.solveSudokuBoard(board);
        Assertions.assertTrue(isSolved(board));

        board = new OriginalSudokuBoard(TestBoardHelper.ALL_ZEROS());
        BacktrackingSolver.solveSudokuBoard(board);
        Assertions.assertTrue(isSolved(board));
    }

    @Test
    void solveActual() {
        OriginalSudokuBoard board = new OriginalSudokuBoard(new int[][]{
                {2, 5, 4, 6, 9, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 3, 0, 5, 6},
                {9, 6, 0, 0, 7, 0, 0, 4, 2},
                {6, 0, 0, 7, 0, 1, 2, 0, 0},
                {1, 3, 0, 0, 0, 2, 5, 0, 7},
                {8, 0, 0, 0, 5, 0, 1, 0, 0},
                {0, 0, 8, 3, 0, 7, 0, 0, 9},
                {0, 0, 6, 2, 0, 0, 7, 0, 5},
                {0, 7, 2, 5, 0, 0, 0, 8, 0}
        });
        BacktrackingSolver.solveSudokuBoard(board);
        Assertions.assertTrue(isSolved(board));

        board = new OriginalSudokuBoard(new int[][]{
                {0, 3, 0, 0, 0, 0, 0, 2, 0},
                {0, 0, 4, 0, 0, 0, 7, 8, 9},
                {6, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 3, 0, 0, 0},
                {0, 0, 3, 2, 7, 0, 0, 0, 4},
                {7, 0, 0, 0, 0, 8, 2, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 9, 6, 0, 4, 0, 0},
                {0, 0, 2, 7, 5, 0, 0, 0, 6}
        });
        BacktrackingSolver.solveSudokuBoard(board);
        Assertions.assertTrue(isSolved(board));

        board = new OriginalSudokuBoard(new int[][]{
                {0, 0, 0, 0, 0, 0, 5, 1, 0},
                {4, 0, 0, 6, 0, 2, 0, 0, 0},
                {5, 0, 0, 0, 0, 0, 0, 0, 4},
                {0, 3, 0, 8, 0, 0, 0, 0, 0},
                {6, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 9, 7, 0, 2, 8, 0},
                {3, 2, 0, 0, 0, 7, 9, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 1},
                {0, 0, 0, 0, 9, 0, 0, 0, 0}
        });
        BacktrackingSolver.solveSudokuBoard(board);
        Assertions.assertTrue(isSolved(board));

        board = new OriginalSudokuBoard(new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        });
        BacktrackingSolver.solveSudokuBoard(board);
        Assertions.assertTrue(isSolved(board));
    }
}