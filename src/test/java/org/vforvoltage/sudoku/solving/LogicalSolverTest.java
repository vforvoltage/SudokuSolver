package org.vforvoltage.sudoku.solving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.SudokuBoard;

class LogicalSolverTest {

    @Test
    void solveBoard() {
    }

    @Test
    void findSingleCandidates() {
        SudokuBoard board = new SudokuBoard(new int[][]{
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 7, 0, 0, 0, 0},
                {0, 0, 0, 0, 8, 0, 0, 0, 0},
                {0, 0, 0, 0, 9, 0, 0, 0, 0}
        });
        LogicalSolver solver = new LogicalSolver(board);
        Assertions.assertTrue(solver.findSingleCandidates());
        Assertions.assertEquals(5, board.getCell(GridCoordinates.of(4, 4)));

        board = new SudokuBoard(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 2, 3, 4, 0, 6, 7, 8, 9},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        });
        solver = new LogicalSolver(board);
        Assertions.assertTrue(solver.findSingleCandidates());
        Assertions.assertEquals(5, board.getCell(GridCoordinates.of(4, 4)));

        board = new SudokuBoard(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 2, 3, 0, 0, 0},
                {0, 0, 0, 4, 0, 6, 0, 0, 0},
                {0, 0, 0, 7, 8, 9, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        });
        solver = new LogicalSolver(board);
        Assertions.assertTrue(solver.findSingleCandidates());
        Assertions.assertEquals(5, board.getCell(GridCoordinates.of(4, 4)));

        board = new SudokuBoard(new int[][]{
                {0, 0, 0, 0, 4, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 2, 0, 0, 0},
                {0, 7, 0, 0, 0, 0, 0, 8, 9},
                {0, 0, 0, 3, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        });
        solver = new LogicalSolver(board);
        Assertions.assertTrue(solver.findSingleCandidates());
        Assertions.assertEquals(5, board.getCell(GridCoordinates.of(4, 4)));

//        board = new SudokuBoard(new int[][]{
//                {1, 0, 0, 0, 4, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {2, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0, 2, 0, 0, 0},
//                {0, 7, 0, 0, 0, 0, 4, 8, 9},
//                {0, 8, 9, 3, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 6, 0, 0, 0, 0},
//                {3, 0, 0, 0, 0, 0, 0, 0, 0}
//        });
//        Assertions.assertTrue(BacktrackingSolver.solveSudokuBoard(new SudokuBoard(board)));
//        solver = new LogicalSolver(board);
//        Assertions.assertTrue(solver.findSingleCandidates());
//        Assertions.assertEquals(5, board.getCell(GridCoordinates.of(4, 4)));
//        Assertions.assertEquals(6, board.getCell(GridCoordinates.of(4, 5)));
//        Assertions.assertEquals(6, board.getCell(GridCoordinates.of(5, 4)));
//        Assertions.assertEquals(6, board.getCell(GridCoordinates.of(5, 5)));
//        Assertions.assertTrue(BacktrackingSolver.solveSudokuBoard(new SudokuBoard(board)));
    }
}