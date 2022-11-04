package org.vforvoltage.sudoku.solving;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.SudokuBoard;

import static org.vforvoltage.sudoku.TestBoardHelper.ALL_ONES;
import static org.vforvoltage.sudoku.TestBoardHelper.ALL_ZEROS;

class BacktrackingSolutionFinderTest {

    @Test
    void findNumberOfSolutions() {
        SudokuBoard board = new SudokuBoard(new int[][]{
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
        BacktrackingSolutionFinder finder = new BacktrackingSolutionFinder(10);
        Assertions.assertEquals(1, finder.findNumberOfSolutions(board));

        board = new SudokuBoard(new int[][]{
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
        finder = new BacktrackingSolutionFinder(10);
        Assertions.assertEquals(1, finder.findNumberOfSolutions(board));

        board = new SudokuBoard(new int[][]{
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
        finder = new BacktrackingSolutionFinder(10);
        Assertions.assertEquals(1, finder.findNumberOfSolutions(board));

        board = new SudokuBoard(new int[][]{
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
        finder = new BacktrackingSolutionFinder(10);
        Assertions.assertEquals(1, finder.findNumberOfSolutions(board));

        board = new SudokuBoard(new int[][]{
                {2, 9, 5, 7, 4, 3, 8, 6, 1},
                {4, 3, 1, 8, 6, 5, 9, 0, 0},
                {8, 7, 6, 1, 9, 2, 5, 4, 3},
                {3, 8, 7, 4, 5, 9, 2, 1, 6},
                {6, 1, 2, 3, 8, 7, 4, 9, 5},
                {5, 4, 9, 2, 1, 6, 7, 3, 8},
                {7, 6, 3, 5, 2, 4, 1, 8, 9},
                {9, 2, 8, 6, 7, 1, 3, 5, 4},
                {1, 5, 4, 9, 3, 8, 6, 0, 0}
        });
        finder = new BacktrackingSolutionFinder(10);
        Assertions.assertEquals(2, finder.findNumberOfSolutions(board));

        board = new SudokuBoard(ALL_ZEROS());
        finder = new BacktrackingSolutionFinder(100);
        Assertions.assertEquals(100, finder.findNumberOfSolutions(board));

        board = new SudokuBoard(ALL_ONES());
        finder = new BacktrackingSolutionFinder(100);
        Assertions.assertEquals(0, finder.findNumberOfSolutions(board));
    }
}