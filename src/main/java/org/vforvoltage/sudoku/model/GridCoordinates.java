package org.vforvoltage.sudoku.model;

public record GridCoordinates(int row, int column) {
    public GridCoordinates {
        if (row < 0 || row > 8 || column < 0 || column > 8) {
            throw new IllegalArgumentException("Error creating GridCoordinates. Invalid value for row or column: (%d, %d).".formatted(row, column));
        }
    }

    public static GridCoordinates of(int row, int column) {
        return new GridCoordinates(row, column);
    }

    public int square() {
        return ((row / 3) * 3) + (column / 3);
    }
}
