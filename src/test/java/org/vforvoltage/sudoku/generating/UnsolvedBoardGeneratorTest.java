package org.vforvoltage.sudoku.generating;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.SudokuBoard;
import org.vforvoltage.sudoku.solving.BacktrackingSolutionFinder;
import org.vforvoltage.sudoku.solving.BacktrackingSolver;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;

class UnsolvedBoardGeneratorTest {

    private static final Logger logger = LogManager.getLogger(UniqueBoardGeneratorTest.class);

    @Test
    void generateUnsolvedBoard() {
        UnsolvedBoardGenerator unsolvedBoardGenerator = new UnsolvedBoardGenerator(new Random(1));
        SudokuBoard sudokuBoard = unsolvedBoardGenerator.generateUnsolvedBoard();
        logger.warn(sudokuBoard);
        BacktrackingSolutionFinder backtrackingSolutionFinder = new BacktrackingSolutionFinder(2);
        int numberOfSolutions = backtrackingSolutionFinder.findNumberOfSolutions(new SudokuBoard(sudokuBoard));
        assertEquals(1, numberOfSolutions);
        logger.warn(numberOfSolutions + " solutions found");
        BacktrackingSolver.solveSudokuBoard(sudokuBoard);
        assertTrue(isSolved(sudokuBoard));
        logger.warn(sudokuBoard);
    }
}