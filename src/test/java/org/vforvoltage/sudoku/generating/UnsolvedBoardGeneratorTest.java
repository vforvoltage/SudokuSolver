package org.vforvoltage.sudoku.generating;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.board.AbstractSudokuBoard;
import org.vforvoltage.sudoku.model.board.SimpleSudokuBoard;
import org.vforvoltage.sudoku.model.board.SudokuBoard;
import org.vforvoltage.sudoku.solving.BacktrackingSolutionFinder;
import org.vforvoltage.sudoku.solving.BacktrackingSolver;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnsolvedBoardGeneratorTest {

    private static final Logger logger = LogManager.getLogger(UniqueBoardGeneratorTest.class);

    @Test
    void generateUnsolvedBoard() {
        UnsolvedBoardGenerator unsolvedBoardGenerator = new UnsolvedBoardGenerator(new Random(1));
        SudokuBoard sudokuBoard = unsolvedBoardGenerator.generateUnsolvedBoard();
        logger.trace(sudokuBoard);
        BacktrackingSolutionFinder backtrackingSolutionFinder = new BacktrackingSolutionFinder(2);
        int numberOfSolutions = backtrackingSolutionFinder.findNumberOfSolutions(new SimpleSudokuBoard(sudokuBoard.getCopyOfBoardArray()) {
        });
        assertEquals(1, numberOfSolutions);
        logger.trace(numberOfSolutions + " solutions found");
        AbstractSudokuBoard simpleSudokuBoard = new SimpleSudokuBoard(sudokuBoard.getCopyOfBoardArray());
        BacktrackingSolver.solveSudokuBoard(simpleSudokuBoard);
        assertTrue(simpleSudokuBoard.isSolved());
        logger.trace(simpleSudokuBoard);
    }
}