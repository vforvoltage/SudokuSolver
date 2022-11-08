package org.vforvoltage.sudoku.solving;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.OriginalSudokuBoard;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isFull;
import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;
import static org.vforvoltage.sudoku.util.BoardUtil.findFirstEmptyCoordinates;

public class BacktrackingSolutionFinder {

    private static final Logger logger = LogManager.getLogger(BacktrackingSolutionFinder.class);
    private int foundSolutions = 0;

    private final int maxSolutions;

    public BacktrackingSolutionFinder(int maxSolutions) {
        this.maxSolutions = maxSolutions;
    }

    public int findNumberOfSolutions(OriginalSudokuBoard board) {

        if (isSolved(board)) {
            return 1;
        } else if (isFull(board)) {
            return 0;
        }

        GridCoordinates startingPoint = findFirstEmptyCoordinates(board);

        for (int i = 1; i <= 9; i++) {
            if (board.trySettingCell(startingPoint, i)) {
                if (isSolved(board)) {
                    logger.trace("\n%s".formatted(board));
                    foundSolutions++;
                    board.resetCellToZero(startingPoint);
                    return foundSolutions;
                }
                if (foundSolutions < maxSolutions) {
                    findNumberOfSolutions(board);
                } else {
                    return foundSolutions;
                }
                board.resetCellToZero(startingPoint);
            }
        }
        return foundSolutions;
    }
}