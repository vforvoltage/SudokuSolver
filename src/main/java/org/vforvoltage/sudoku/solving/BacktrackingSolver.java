package org.vforvoltage.sudoku.solving;

import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.SudokuBoard;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;

public class BacktrackingSolver {

    public static boolean solveSudokuBoard(SudokuBoard board) {
        if(isSolved(board)) {
            System.out.println(board);
            return true;
        }

        GridCoordinates startingPoint = findFirstEmptyCoordinates(board);

        for(int i = 1; i <= 9; i++) {
            if(board.trySettingCell(startingPoint, i)) {
                if(solveSudokuBoard(board)) {
                    return true;
                } else {
                    board.resetCellToZero(startingPoint);
                }
            }
        }

        return false;
    }

    private static GridCoordinates findFirstEmptyCoordinates(SudokuBoard board) {
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
