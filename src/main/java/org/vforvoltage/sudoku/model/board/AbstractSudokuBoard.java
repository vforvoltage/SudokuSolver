package org.vforvoltage.sudoku.model.board;

import org.vforvoltage.sudoku.model.GridCoordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractSudokuBoard implements SudokuBoard {

    public static final int BOARD_START_INDEX = 0;
    public static final int SUBSECTION_SIZE = 3;
    public static final int BOARD_SIZE = SUBSECTION_SIZE * SUBSECTION_SIZE;
    public static final int MAX_VALUE = BOARD_SIZE;
    public static final int NO_VALUE = 0;
    public static final int MIN_VALUE = 1;
    protected final Set<Integer> ELIGIBLE_CELL_VALUES = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE).boxed().collect(Collectors.toSet());
    protected final int[][] board;

    protected <T extends SudokuBoard> AbstractSudokuBoard(T sudokuBoard) {
        this(sudokuBoard.getCopyOfBoardArray());
    }

    protected AbstractSudokuBoard(int[][] board) {
        this.board = board;
    }

    @Override
    public boolean isSolved() {
        return isValid() && isFull();
    }

    @Override
    public boolean isFull() {
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (getCell(GridCoordinates.of(row, column)) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isValid() {
        return areRowsValid() && areColumnsValid() && areSquaresValid();
    }

    @Override
    public int getCell(GridCoordinates coordinates) {
        return board[coordinates.row()][coordinates.column()];
    }

    @Override
    public boolean trySettingCell(GridCoordinates coordinates, int value) {
        int originalCellValue = getCell(coordinates);
        if (originalCellValue != 0) {
            throw new IllegalArgumentException("Should not be trying to set a cell with a non-zero value");
        }

        setCell(coordinates, value);

        if (!this.isValid()) {
            resetCellToNoValue(coordinates);
            return false;
        }

        return true;
    }

    protected void setCell(GridCoordinates coordinates, int value) {
        board[coordinates.row()][coordinates.column()] = value;
    }

    @Override
    public void resetCellToNoValue(GridCoordinates coordinates) {
        setCell(coordinates, NO_VALUE);
    }

    @Override
    public Set<Integer> getEligibleValuesForCell(GridCoordinates coordinates) {
        Set<Integer> eligibleValues = new HashSet<>(ELIGIBLE_CELL_VALUES);
        for (int i = BOARD_START_INDEX; i < BOARD_SIZE; i++) {
            eligibleValues.remove(getCell(GridCoordinates.of(i, coordinates.column())));
            eligibleValues.remove(getCell(GridCoordinates.of(coordinates.row(), i)));
        }

        GridCoordinates startOfSquare = coordinates.startOfSquare();
        for (int i = 0; i < SUBSECTION_SIZE; i++) {
            for (int j = 0; j < SUBSECTION_SIZE; j++) {
                eligibleValues.remove(getCell(GridCoordinates.of(startOfSquare.row() + i, startOfSquare.column() + j)));
            }
        }
        return eligibleValues;
    }

    @Override
    public List<GridCoordinates> getEmptyCells() {
        List<GridCoordinates> coordinates = new ArrayList<>();

        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                if (getCell(cell) == 0) {
                    coordinates.add(cell);
                }
            }
        }
        return coordinates;
    }

    @Override
    public GridCoordinates getFirstEmptyCoordinates() {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                GridCoordinates coordinates = new GridCoordinates(row, column);
                if (getCell(coordinates) == NO_VALUE) {
                    return coordinates;
                }
            }
        }
        throw new IllegalStateException("Cannot find empty coordinates on a full board");
    }

    @Override
    public int[][] getCopyOfBoardArray() {
        return Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
    }

    private boolean areRowsValid() {
        for (int row = 0; row < 9; row++) {
            Set<Integer> dupes = new HashSet<>();
            for (int column = 0; column < 9; column++) {
                if (getCell(GridCoordinates.of(row, column)) != 0) {
                    boolean isDupe = !dupes.add(getCell(GridCoordinates.of(row, column)));
                    if (isDupe) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean areColumnsValid() {
        for (int column = 0; column < 9; column++) {
            Set<Integer> dupes = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (getCell(GridCoordinates.of(row, column)) != 0) {
                    boolean isDupe = !dupes.add(getCell(GridCoordinates.of(row, column)));
                    if (isDupe) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean areSquaresValid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Integer> dupes = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        int x = (i * 3) + row;
                        int y = (j * 3) + column;
                        if (getCell(GridCoordinates.of(x, y)) != 0) {
                            boolean isDupe = !dupes.add(getCell(GridCoordinates.of(x, y)));
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

    @Override
    public final int hashCode() {
        return Arrays.deepHashCode(board);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractSudokuBoard that)) {
            return false;
        }
        return Arrays.deepEquals(board, that.board);
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append("\n");
        Arrays.stream(board).forEach(i -> sb.append(Arrays.toString(i)).append("\n"));
        return sb.toString();
    }
}