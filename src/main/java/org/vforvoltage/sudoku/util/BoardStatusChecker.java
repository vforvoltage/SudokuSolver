package org.vforvoltage.sudoku.util;

import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.OriginalSudokuBoard;

import java.util.HashSet;
import java.util.Set;

public class BoardStatusChecker {

    public static boolean isSolved(OriginalSudokuBoard board) {
        return isValid(board) && isFull(board);
    }

    public static boolean isValid(OriginalSudokuBoard board) {
        return areRowsValid(board) && areColumnsValid(board) && areSquaresValid(board);
    }

    public static boolean isFull(OriginalSudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board.getCell(GridCoordinates.of(row, column)) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean areRowsValid(OriginalSudokuBoard board) {
        for (int row = 0; row < 9; row++) {
            Set<Integer> dupes = new HashSet<>();
            for (int column = 0; column < 9; column++) {
                if (board.getCell(GridCoordinates.of(row, column)) != 0) {
                    boolean isDupe = !dupes.add(board.getCell(GridCoordinates.of(row, column)));
                    if (isDupe) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean areColumnsValid(OriginalSudokuBoard board) {
        for (int column = 0; column < 9; column++) {
            Set<Integer> dupes = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (board.getCell(GridCoordinates.of(row, column)) != 0) {
                    boolean isDupe = !dupes.add(board.getCell(GridCoordinates.of(row, column)));
                    if (isDupe) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean areSquaresValid(OriginalSudokuBoard board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Integer> dupes = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        int x = (i * 3) + row;
                        int y = (j * 3) + column;
                        if (board.getCell(GridCoordinates.of(x, y)) != 0) {
                            boolean isDupe = !dupes.add(board.getCell(GridCoordinates.of(x, y)));
                            if (isDupe) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}