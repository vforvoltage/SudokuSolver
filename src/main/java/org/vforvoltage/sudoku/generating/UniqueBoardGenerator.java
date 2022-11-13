package org.vforvoltage.sudoku.generating;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.board.SimpleSudokuBoard;
import org.vforvoltage.sudoku.model.board.SudokuBoard;
import org.vforvoltage.sudoku.solving.BacktrackingSolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UniqueBoardGenerator {

    private static final Logger logger = LogManager.getLogger(UniqueBoardGenerator.class);

    private final SudokuBoard board;
    private final Random random;

    public UniqueBoardGenerator(SudokuBoard board) {
        this.board = board;
        this.random = new Random();
    }

    public UniqueBoardGenerator(SudokuBoard board, Random random) {
        this.board = board;
        this.random = random;
    }

    public SudokuBoard generateUniqueBoard() {
        while (!board.isSolved()) {
            GridCoordinates randomCell = getRandomUnfilledCell();
            int randomValue = getRandomEligibleValueForCell(randomCell);
            boolean valueSet = board.trySettingCell(randomCell, randomValue);
            if (!valueSet) {
                throw new IllegalStateException("Failed to set a cell to a value that should have been allowed");
            }

            boolean solvable = BacktrackingSolver.solveSudokuBoard(new SimpleSudokuBoard(board.getCopyOfBoardArray()));
            if (!solvable) {
                board.resetCellToNoValue(randomCell);
            }
        }
        logger.info(board);
        return board;
    }

    private int getRandomEligibleValueForCell(GridCoordinates randomCell) {
        if (board.getCell(randomCell) != 0) {
            throw new IllegalArgumentException("Provided cell has already been populated");
        }

        List<Integer> eligibleValuesForCell = new ArrayList<>(board.getEligibleValuesForCell(randomCell));
        Collections.shuffle(eligibleValuesForCell, random);
        return eligibleValuesForCell.get(0);
    }

    private GridCoordinates getRandomUnfilledCell() {
        List<GridCoordinates> emptyCells = board.getEmptyCells();
        Collections.shuffle(emptyCells, random);
        return emptyCells.get(0);
    }
}