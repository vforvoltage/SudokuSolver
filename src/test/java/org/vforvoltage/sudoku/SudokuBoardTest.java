package org.vforvoltage.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.SudokuBoard;

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

class SudokuBoardTest {

    @Test
    void testIsValid() {
        Assertions.assertTrue(new SudokuBoard(SOLVED()).isValid());
        Assertions.assertTrue(new SudokuBoard(ALL_ZEROS()).isValid());
        Assertions.assertFalse(new SudokuBoard(ALL_ONES()).isValid());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES()).isValid());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES()).isValid());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES()).isValid());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES()).isValid());
        Assertions.assertFalse(new SudokuBoard(VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES()).isValid());
        Assertions.assertFalse(new SudokuBoard(VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES()).isValid());
        Assertions.assertFalse(new SudokuBoard(VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES()).isValid());
        Assertions.assertTrue(new SudokuBoard(VALID_ROWS_VALID_COLUMNS_VALID_SQUARES()).isValid());
    }

    @Test
    void testIsFull() {
        Assertions.assertTrue(new SudokuBoard(SOLVED()).isFull());
        Assertions.assertTrue(new SudokuBoard(ALL_ONES()).isFull());
        Assertions.assertFalse(new SudokuBoard(ALL_ZEROS()).isFull());
        Assertions.assertFalse(new SudokuBoard(ALMOST_FULL()).isFull());

    }

    @Test
    void testIsSolved() {
        Assertions.assertTrue(new SudokuBoard(SOLVED()).isSolved());
        Assertions.assertFalse(new SudokuBoard(ALMOST_SOLVED()).isSolved());
        Assertions.assertFalse(new SudokuBoard(ALL_ZEROS()).isSolved());
        Assertions.assertFalse(new SudokuBoard(ALL_ONES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES()).isSolved());
        Assertions.assertFalse(new SudokuBoard(VALID_ROWS_VALID_COLUMNS_VALID_SQUARES()).isSolved());
    }
}