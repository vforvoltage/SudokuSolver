package org.vforvoltage.sudoku.model;

import java.util.Arrays;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isValid;

public class SudokuBoard {

    private final int[][] board;

    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    public int getCell(GridCoordinates coordinates) {
        return board[coordinates.row()][coordinates.column()];
    }

    public boolean trySettingCell(GridCoordinates coordinates, int value) {
        int originalCellValue = getCell(coordinates);
        if(originalCellValue != 0) {
            throw new IllegalArgumentException("Should not be trying to set a cell with a non-zero value");
        }

        setCell(coordinates, value);

        if(!isValid(this)) {
            setCell(coordinates, originalCellValue);
            return false;
        }

        return true;
    }

    private void setCell(GridCoordinates coordinates, int value) {
        board[coordinates.row()][coordinates.column()] = value;
    }

    public void resetCellToZero(GridCoordinates coordinates) {
        setCell(coordinates, 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(board).forEach(i -> sb.append(Arrays.toString(i)).append("\n"));
        return sb.toString();
    }
}
