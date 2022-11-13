package org.vforvoltage.sudoku.model.board;

import org.vforvoltage.sudoku.model.GridCoordinates;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapBackedSudokuBoard extends AbstractSudokuBoard implements SudokuBoard {

    private final Map<Integer, Set<Integer>> rowEligibleValueMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> columnEligibleValueMap = new HashMap<>();
    private final Map<Integer, Set<Integer>> squareEligibleValueMap = new HashMap<>();

    public MapBackedSudokuBoard(int[][] board) {
        super(board);
        initializeMaps();
    }

    private void initializeMaps() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                rowEligibleValueMap.computeIfAbsent(row, r -> new HashSet<>(ELIGIBLE_CELL_VALUES)).remove(getCell(cell));
                columnEligibleValueMap.computeIfAbsent(column, r -> new HashSet<>(ELIGIBLE_CELL_VALUES)).remove(getCell(cell));
                squareEligibleValueMap.computeIfAbsent(cell.square(), r -> new HashSet<>(ELIGIBLE_CELL_VALUES)).remove(getCell(cell));
            }
        }
    }

    public <T extends AbstractSudokuBoard> MapBackedSudokuBoard(T sudokuBoard) {
        super(sudokuBoard);
        initializeMaps();
    }

    @Override
    protected void setCell(GridCoordinates coordinates, int value) {
        board[coordinates.row()][coordinates.column()] = value;
        rowEligibleValueMap.get(coordinates.row()).remove(value);
        columnEligibleValueMap.get(coordinates.column()).remove(value);
        squareEligibleValueMap.get(coordinates.square()).remove(value);
    }


    @Override
    public void resetCellToNoValue(GridCoordinates coordinates) {
        int value = getCell(coordinates);
        board[coordinates.row()][coordinates.column()] = NO_VALUE;
        rowEligibleValueMap.get(coordinates.row()).add(value);
        columnEligibleValueMap.get(coordinates.column()).add(value);
        squareEligibleValueMap.get(coordinates.square()).add(value);
    }

    @Override
    public Set<Integer> getEligibleValuesForCell(GridCoordinates coordinates) {
        Set<Integer> eligibleValues = new HashSet<>(ELIGIBLE_CELL_VALUES);
        eligibleValues.retainAll(rowEligibleValueMap.get(coordinates.row()));
        eligibleValues.retainAll(columnEligibleValueMap.get(coordinates.column()));
        eligibleValues.retainAll(squareEligibleValueMap.get(coordinates.square()));
        return eligibleValues;
    }
}