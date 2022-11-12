package org.vforvoltage.sudoku.model.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.vforvoltage.sudoku.model.GridCoordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.BOARD_SIZE;
import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.BOARD_START_INDEX;
import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.MAX_VALUE;
import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.MIN_VALUE;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.ALL_ONES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.ALL_ZEROS;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.SOLVED;

interface SudokuBoardTest<T extends SudokuBoard> {

    T createSudokuBoard(int[][] board);

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#fullBoardArrays")
    default void isFullShouldReturnTrue(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        Assertions.assertTrue(board.isFull());
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#notFullBoardArrays")
    default void isFullShouldReturnFalse(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        Assertions.assertFalse(board.isFull());
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#validBoardArrays")
    default void isValidShouldReturnTrue(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        Assertions.assertTrue(board.isValid());
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#notValidBoardArrays")
    default void isValidShouldReturnFalse(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        Assertions.assertFalse(board.isValid());
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#solvedBoardArrays")
    default void isSolvedShouldReturnTrue(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        Assertions.assertTrue(board.isSolved());
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#notSolvedBoardArrays")
    default void isSolvedShouldReturnFalse(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        Assertions.assertFalse(board.isSolved());
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#testGetCellArrays")
    default void testGetCell(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        for (int row = BOARD_START_INDEX; row < boardArray.length; row++) {
            for (int column = BOARD_START_INDEX; column < boardArray.length; column++) {
                assertEquals(boardArray[row][column], board.getCell(GridCoordinates.of(row, column)));
            }
        }
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#solvedBoardArrays")
    default void testTrySettingCellShouldReturnTrue(int[][] boardArray) {
        T board = createSudokuBoard(new int[BOARD_SIZE][BOARD_SIZE]);
        for (int row = BOARD_START_INDEX; row < boardArray.length; row++) {
            for (int column = BOARD_START_INDEX; column < boardArray.length; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                int value = boardArray[row][column];
                Assertions.assertTrue(board.trySettingCell(cell, value));
                assertEquals(value, board.getCell(cell));
            }
        }
    }

    @ParameterizedTest
    @MethodSource("org.vforvoltage.sudoku.testutil.TestBoardArrayProvider#solvedBoardArrays")
    default void testTrySettingCellShouldReturnFalse(int[][] boardArray) {
        T board = createSudokuBoard(boardArray);
        for (int row = BOARD_START_INDEX; row < boardArray.length; row++) {
            for (int column = BOARD_START_INDEX; column < boardArray.length; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                int value = boardArray[row][column];
                board.resetCellToNoValue(cell);
                Assertions.assertFalse(board.trySettingCell(cell, value == 1 ? 9 : 1));
                assertEquals(0, board.getCell(cell));
                board.trySettingCell(cell, value);
            }
        }
    }

    @Test
    default void testTrySettingCellShouldThrowException() {
        T board = createSudokuBoard(ALL_ONES());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> board.trySettingCell(GridCoordinates.of(BOARD_START_INDEX, BOARD_START_INDEX), 2));
        assertEquals("Should not be trying to set a cell with a non-zero value", exception.getMessage());
    }

    @Test
    default void testResetCellToNoValue() {
        T board = createSudokuBoard(ALL_ONES());
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                board.resetCellToNoValue(cell);
                assertEquals(0, board.getCell(cell));
            }
        }
    }

    @Test
    default void testGetEligibleValuesForCell() {
        T board = createSudokuBoard(ALL_ZEROS());
        Set<Integer> eligibleValues = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE).boxed().collect(Collectors.toSet());
        assertEquals(eligibleValues, board.getEligibleValuesForCell(GridCoordinates.of(0, 0)));

        board.trySettingCell(GridCoordinates.of(0, 8), 9);
        eligibleValues.remove(9);
        assertEquals(eligibleValues, board.getEligibleValuesForCell(GridCoordinates.of(0, 0)));

        board.trySettingCell(GridCoordinates.of(8, 0), 8);
        eligibleValues.remove(8);
        assertEquals(eligibleValues, board.getEligibleValuesForCell(GridCoordinates.of(0, 0)));

        board.trySettingCell(GridCoordinates.of(1, 1), 7);
        eligibleValues.remove(7);
        assertEquals(eligibleValues, board.getEligibleValuesForCell(GridCoordinates.of(0, 0)));

        board.trySettingCell(GridCoordinates.of(3, 3), 6);
        assertEquals(eligibleValues, board.getEligibleValuesForCell(GridCoordinates.of(0, 0)));

        board.resetCellToNoValue(GridCoordinates.of(0, 8));
        eligibleValues.add(9);
        assertEquals(eligibleValues, board.getEligibleValuesForCell(GridCoordinates.of(0, 0)));
    }

    @Test
    default void testGetEmptyCells() {
        List<GridCoordinates> coordinates = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                coordinates.add(GridCoordinates.of(row, column));
            }
        }

        T board = createSudokuBoard(ALL_ZEROS());
        int[][] solved = SOLVED();
        assertEquals(coordinates, board.getEmptyCells());

        for (int i = 1; i <= BOARD_SIZE * BOARD_SIZE; i++) {
            GridCoordinates cell = coordinates.remove(0);
            board.trySettingCell(cell, solved[cell.row()][cell.column()]);
            assertEquals(coordinates, board.getEmptyCells());
        }
    }

    @Test
    default void testGetFirstEmptyCoordinates() {
        List<GridCoordinates> coordinates = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                coordinates.add(GridCoordinates.of(row, column));
            }
        }

        T board = createSudokuBoard(ALL_ZEROS());
        int[][] solved = SOLVED();
        assertEquals(coordinates, board.getEmptyCells());

        GridCoordinates cell = coordinates.remove(0);
        for (int i = 1; i < BOARD_SIZE * BOARD_SIZE; i++) {
            board.trySettingCell(cell, solved[cell.row()][cell.column()]);
            assertEquals(coordinates.get(0), board.getFirstEmptyCoordinates());
            cell = coordinates.remove(0);
        }
        assertEquals(cell, board.getFirstEmptyCoordinates());
    }

    @Test
    default void testGetCopyOfBoardArray() {
        int[][] solved = SOLVED();
        T board = createSudokuBoard(solved);
        assertTrue(Arrays.deepEquals(solved, board.getCopyOfBoardArray()));
    }
}