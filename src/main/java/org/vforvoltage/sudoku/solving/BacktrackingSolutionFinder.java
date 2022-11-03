package org.vforvoltage.sudoku.solving;

import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.SudokuBoard;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;
import static org.vforvoltage.sudoku.util.BoardUtil.findFirstEmptyCoordinates;

public class BacktrackingSolutionFinder {

    public static int findNumberOfSolutions(SudokuBoard board) {
        int totalSolutions = 0;
        GridCoordinates startingPoint = findFirstEmptyCoordinates(board);

        for(int i = 1; i <= 9; i++) {
            if(board.trySettingCell(startingPoint, i)) {
                if(isSolved(board)) {
                    board.resetCellToZero(startingPoint);
                    return 1;
                }
                totalSolutions+=findNumberOfSolutions(board);
                board.resetCellToZero(startingPoint);
            }
        }
        return totalSolutions;
    }
}
