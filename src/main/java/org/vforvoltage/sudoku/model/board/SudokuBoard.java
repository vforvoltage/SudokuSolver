package org.vforvoltage.sudoku.model.board;

import org.vforvoltage.sudoku.model.GridCoordinates;

import java.util.List;
import java.util.Set;

public interface SudokuBoard {

    boolean isSolved();

    boolean isFull();

    boolean isValid();

    int getCell(GridCoordinates coordinates);

    boolean trySettingCell(GridCoordinates coordinates, int value);

    void resetCellToNoValue(GridCoordinates coordinates);

    Set<Integer> getEligibleValuesForCell(GridCoordinates coordinates);

    List<GridCoordinates> getEmptyCells();

    GridCoordinates getFirstEmptyCoordinates();

    int[][] getCopyOfBoardArray();
}