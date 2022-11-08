package org.vforvoltage.sudoku;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.OriginalSudokuBoard;
import org.vforvoltage.sudoku.solving.BacktrackingSolver;

import static org.vforvoltage.sudoku.util.TestBoards.ALL_ZEROS;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Starting Up");
        OriginalSudokuBoard board = new OriginalSudokuBoard(ALL_ZEROS());
        BacktrackingSolver.solveSudokuBoard(board);
        logger.info("Shutting Down");
    }
}