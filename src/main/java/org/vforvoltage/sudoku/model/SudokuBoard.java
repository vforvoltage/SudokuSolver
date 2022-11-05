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

    private final Map<Integer, Set<Integer>> rowEligibleValueMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> columnEligibleValueMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> squareEligibleValueMap = new HashMap<>();
    private final Set<Integer> eligibleVCellValues = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public SudokuBoard(int[][] board) {
        this.board = board;
        initializeMaps();
    }

    public SudokuBoard(SudokuBoard sudokuBoard) {
        this(Arrays.stream(sudokuBoard.board).map(int[]::clone).toArray(int[][]::new));
    }

    private void initializeMaps() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                rowEligibleValueMap.computeIfAbsent(row, r -> new HashSet<>(eligibleVCellValues)).remove(getCell(cell));
                columnEligibleValueMap.computeIfAbsent(column, r -> new HashSet<>(eligibleVCellValues)).remove(getCell(cell));
                squareEligibleValueMap.computeIfAbsent(cell.square(), r -> new HashSet<>(eligibleVCellValues)).remove(getCell(cell));
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

        if (!isValid(this)) {
            resetCellToZero(coordinates);
            return false;
        }

        return true;
    }

    private void setCell(GridCoordinates coordinates, int value) {
        board[coordinates.row()][coordinates.column()] = value;
        rowEligibleValueMap.get(coordinates.row()).remove(value);
        columnEligibleValueMap.get(coordinates.column()).remove(value);
        squareEligibleValueMap.get(coordinates.square()).remove(value);
    }

    public void resetCellToZero(GridCoordinates coordinates) {
        int value = getCell(coordinates);
        board[coordinates.row()][coordinates.column()] = 0;
        rowEligibleValueMap.get(coordinates.row()).add(value);
        columnEligibleValueMap.get(coordinates.column()).add(value);
        squareEligibleValueMap.get(coordinates.square()).add(value);
    }

    public List<Integer> getEligibleValuesForCell(GridCoordinates coordinates) {
        Set<Integer> eligibleValues = new HashSet<>(eligibleVCellValues);
        eligibleValues.retainAll(rowEligibleValueMap.get(coordinates.row()));
        eligibleValues.retainAll(columnEligibleValueMap.get(coordinates.column()));
        eligibleValues.retainAll(squareEligibleValueMap.get(coordinates.square()));
        return new ArrayList<>(eligibleValues);
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