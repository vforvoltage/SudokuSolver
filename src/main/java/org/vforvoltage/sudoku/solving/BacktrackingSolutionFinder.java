package org.vforvoltage.sudoku.solving;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.board.SudokuBoard;

public class BacktrackingSolutionFinder {

    private static final Logger logger = LogManager.getLogger(BacktrackingSolutionFinder.class);
    private int foundSolutions = 0;

    private final int maxSolutions;

    public BacktrackingSolutionFinder(int maxSolutions) {
        this.maxSolutions = maxSolutions;
    }

    public int findNumberOfSolutions(SudokuBoard board) {

        if (foundSolutions >= maxSolutions) {
            return foundSolutions;
        }

        if (board.isSolved()) {
            return 1;
        } else if (board.isFull()) {
            return 0;
        }

        GridCoordinates startingPoint = board.getFirstEmptyCoordinates();

        for (int i = 1; i <= 9; i++) {
            if (board.trySettingCell(startingPoint, i)) {
                if (board.isSolved()) {
                    logger.trace("\n%s".formatted(board));
                    foundSolutions++;
                    board.resetCellToNoValue(startingPoint);
                    return foundSolutions;
                }
                if (foundSolutions < maxSolutions) {
                    findNumberOfSolutions(board);
                } else {
                    return foundSolutions;
                }
                board.resetCellToNoValue(startingPoint);
            }
        }
        return foundSolutions;
    }
}