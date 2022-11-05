package org.vforvoltage.sudoku.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.vforvoltage.sudoku.TestBoardHelper.ALL_ONES;
import static org.vforvoltage.sudoku.TestBoardHelper.ALL_ZEROS;
import static org.vforvoltage.sudoku.TestBoardHelper.SOLVED;

class SudokuBoardTest {

    @Test
    void getEligibleValuesForCell() {
        SudokuBoard board = new SudokuBoard(ALL_ZEROS());
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                List<Integer> eligibleValuesForCell = board.getEligibleValuesForCell(GridCoordinates.of(row, column));
                Assertions.assertEquals(9, eligibleValuesForCell.size());
            }
        }

        board = new SudokuBoard(ALL_ONES());
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                List<Integer> eligibleValuesForCell = board.getEligibleValuesForCell(GridCoordinates.of(row, column));
                Assertions.assertEquals(8, eligibleValuesForCell.size());
            }
        }

        board = new SudokuBoard(SOLVED());
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                List<Integer> eligibleValuesForCell = board.getEligibleValuesForCell(GridCoordinates.of(row, column));
                Assertions.assertEquals(0, eligibleValuesForCell.size());
            }
        }
    }
}