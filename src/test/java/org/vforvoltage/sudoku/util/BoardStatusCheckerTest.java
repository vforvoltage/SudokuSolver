package org.vforvoltage.sudoku.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.OriginalSudokuBoard;

import static org.vforvoltage.sudoku.TestBoardHelper.ALL_ONES;
import static org.vforvoltage.sudoku.TestBoardHelper.ALL_ZEROS;
import static org.vforvoltage.sudoku.TestBoardHelper.ALMOST_FULL;
import static org.vforvoltage.sudoku.TestBoardHelper.ALMOST_SOLVED;
import static org.vforvoltage.sudoku.TestBoardHelper.INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.TestBoardHelper.INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES;
import static org.vforvoltage.sudoku.TestBoardHelper.INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.TestBoardHelper.INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES;
import static org.vforvoltage.sudoku.TestBoardHelper.SOLVED;
import static org.vforvoltage.sudoku.TestBoardHelper.VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.TestBoardHelper.VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES;
import static org.vforvoltage.sudoku.TestBoardHelper.VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.TestBoardHelper.VALID_ROWS_VALID_COLUMNS_VALID_SQUARES;
import static org.vforvoltage.sudoku.util.BoardStatusChecker.isFull;
import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;
import static org.vforvoltage.sudoku.util.BoardStatusChecker.isValid;

public class BoardStatusCheckerTest {

    @Test
    void testIsValid() {
        Assertions.assertTrue(isValid(new OriginalSudokuBoard(SOLVED())));
        Assertions.assertTrue(isValid(new OriginalSudokuBoard(ALL_ZEROS())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(ALL_ONES())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES())));
        Assertions.assertFalse(isValid(new OriginalSudokuBoard(VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertTrue(isValid(new OriginalSudokuBoard(VALID_ROWS_VALID_COLUMNS_VALID_SQUARES())));
    }

    @Test
    void testIsFull() {
        Assertions.assertTrue(isFull(new OriginalSudokuBoard(SOLVED())));
        Assertions.assertTrue(isFull(new OriginalSudokuBoard(ALL_ONES())));
        Assertions.assertFalse(isFull(new OriginalSudokuBoard(ALL_ZEROS())));
        Assertions.assertFalse(isFull(new OriginalSudokuBoard(ALMOST_FULL())));

    }

    @Test
    void testIsSolved() {
        Assertions.assertTrue(isSolved(new OriginalSudokuBoard(SOLVED())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(ALMOST_SOLVED())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(ALL_ZEROS())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(ALL_ONES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES())));
        Assertions.assertFalse(isSolved(new OriginalSudokuBoard(VALID_ROWS_VALID_COLUMNS_VALID_SQUARES())));
    }
}