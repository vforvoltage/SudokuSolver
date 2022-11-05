package org.vforvoltage.sudoku.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isValid;

public class SudokuBoard {

    private final int[][] board;

    private final Map<Integer, Set<Integer>> rowValueMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> columnValueMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> squareValueMap = new HashMap<>();

    public SudokuBoard(int[][] board) {
        this.board = board;
        initializeMaps();
    }

    public SudokuBoard(SudokuBoard sudokuBoard) {
        this(Arrays.stream(sudokuBoard.board).map(int[]::clone).toArray(int[][]::new));
    }

    private void initializeMaps() {
        rowValueMap.clear();
        columnValueMap.clear();
        squareValueMap.clear();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                rowValueMap.computeIfAbsent(row, r -> new HashSet<>()).add(getCell(cell));
                columnValueMap.computeIfAbsent(column, r -> new HashSet<>()).add(getCell(cell));
                squareValueMap.computeIfAbsent(cell.square(), r -> new HashSet<>()).add(getCell(cell));
            }
        }
    }

    public int getCell(GridCoordinates coordinates) {
        return board[coordinates.row()][coordinates.column()];
    }

    public boolean trySettingCell(GridCoordinates coordinates, int value) {
        int originalCellValue = getCell(coordinates);
        if (originalCellValue != 0) {
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
        initializeMaps();
    }

    public void resetCellToZero(GridCoordinates coordinates) {
        setCell(coordinates, 0);
    }

    public List<Integer> getEligibleValuesForCell(GridCoordinates coordinates) {
        List<Integer> eligibleValues = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!rowValueMap.get(coordinates.row()).contains(i)
                    && !columnValueMap.get(coordinates.column()).contains(i)
                    && !squareValueMap.get(coordinates.square()).contains(i)) {
                eligibleValues.add(i);
            }
        }
        return eligibleValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SudokuBoard that)) {
            return false;
        }
        return Arrays.deepEquals(board, that.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(board).forEach(i -> sb.append(Arrays.toString(i)).append("\n"));
        return sb.toString();
    }
}
