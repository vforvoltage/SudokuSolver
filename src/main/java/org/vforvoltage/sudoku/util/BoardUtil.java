package org.vforvoltage.sudoku.util;

import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.SudokuBoard;

public class BoardUtil {

    public static GridCoordinates findFirstEmptyCoordinates(SudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for(int column = 0; column < 9; column++) {
                GridCoordinates coordinates = new GridCoordinates(row, column);
                if(board.getCell(coordinates) == 0) {
                    return coordinates;
                }
            }
        }
        throw new IllegalStateException("Cannot find starting coordinates on a full board");
    }
}
