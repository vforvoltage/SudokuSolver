package org.vforvoltage.sudoku.model;

import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.BOARD_SIZE;
import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.BOARD_START_INDEX;
import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.SUBSECTION_SIZE;

public record GridCoordinates(int row, int column) {
    public GridCoordinates {
        if (row < BOARD_START_INDEX || row >= BOARD_SIZE || column < BOARD_START_INDEX || column >= BOARD_SIZE) {
            throw new IllegalArgumentException("Error creating GridCoordinates. Invalid value for row or column: (%d, %d).".formatted(row, column));
        }
    }

    public static GridCoordinates of(int row, int column) {
        return new GridCoordinates(row, column);
    }

    public int square() {
        return ((row / SUBSECTION_SIZE) * SUBSECTION_SIZE) + (column / SUBSECTION_SIZE);
    }

    public GridCoordinates startOfSquare() {
        return GridCoordinates.of((row / SUBSECTION_SIZE) * SUBSECTION_SIZE, (column / SUBSECTION_SIZE) * SUBSECTION_SIZE);
    }
}