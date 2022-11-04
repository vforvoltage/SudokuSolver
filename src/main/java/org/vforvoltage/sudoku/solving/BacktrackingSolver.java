package org.vforvoltage.sudoku.solving;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.SudokuBoard;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;
import static org.vforvoltage.sudoku.util.BoardUtil.findFirstEmptyCoordinates;

public class BacktrackingSolver {

    private static final Logger logger = LogManager.getLogger(BacktrackingSolver.class);
    public static boolean solveSudokuBoard(SudokuBoard board) {
        if(isSolved(board)) {
            logger.info(board);
            return true;
        }

        GridCoordinates startingPoint = findFirstEmptyCoordinates(board);

        for(int i = 1; i <= 9; i++) {
            if(board.trySettingCell(startingPoint, i)) {
                if(solveSudokuBoard(board)) {
                    return true;
                } else {
                    logger.trace(String.format("Resetting %s from %d", startingPoint, i));
                    board.resetCellToZero(startingPoint);
                }
            }
        }

        return false;
    }
}
