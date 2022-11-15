package org.vforvoltage.sudoku.solving;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.board.SudokuBoard;

import java.util.Set;

import static org.vforvoltage.sudoku.model.board.AbstractSudokuBoard.NO_VALUE;

public class LogicalSolver {
    private static final Logger logger = LogManager.getLogger(LogicalSolver.class);

    private final SudokuBoard board;

    public LogicalSolver(SudokuBoard board) {
        this.board = board;
    }

    public boolean solveBoard() {
        boolean madeProgress;

        do {
            madeProgress = findSingleCandidates();
        }
        while (!board.isSolved() && madeProgress);
        return false;
    }

    protected boolean findSingleCandidates() {
        logger.info("Checking each position to see if we can set any cells based on the presence of all other values in the corresponding row, column, and square");
        boolean setAnyValues = false;
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                if (board.getCell(cell) == NO_VALUE) {
                    Set<Integer> eligibleValuesForCell = board.getEligibleValuesForCell(cell);
                    if (eligibleValuesForCell.size() == 1) {
                        Integer value = eligibleValuesForCell.stream().findFirst().orElseThrow();
                        logger.info("Setting %s to %d because it is the only value that doesn't already appear in row %d, column %d and square %d".formatted(cell, value, cell.row(), cell.column(), cell.square()));
                        setAnyValues = board.trySettingCell(cell, value);
                        if (!setAnyValues) {
                            throw new IllegalStateException("Could not set the only eligible value for cell.");
                        }
                    }
                }
            }
        }
        if (setAnyValues) {
            logger.info("Re-checking for single candidates again since we found some this go round");
            findSingleCandidates();
        } else {
            logger.info("Didn't find any single candidates this time");
        }
        return setAnyValues;
    }
}