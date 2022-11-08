package org.vforvoltage.sudoku.generating;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.OriginalSudokuBoard;
import org.vforvoltage.sudoku.solving.BacktrackingSolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.vforvoltage.sudoku.util.BoardStatusChecker.isSolved;
import static org.vforvoltage.sudoku.util.TestBoards.ALL_ZEROS;

public class UniqueBoardGenerator {

    private static final Logger logger = LogManager.getLogger(UniqueBoardGenerator.class);

    private final OriginalSudokuBoard board = new OriginalSudokuBoard(ALL_ZEROS());
    private final Random random;

    public UniqueBoardGenerator() {
        this.random = new Random();
    }

    public UniqueBoardGenerator(Random random) {
        this.random = random;
    }

    public OriginalSudokuBoard generateUniqueBoard() {
        while (!isSolved(board)) {
            GridCoordinates randomCell = getRandomUnfilledCell();
            int randomValue = getRandomEligibleValueForCell(randomCell);
            boolean valueSet = board.trySettingCell(randomCell, randomValue);
            if (!valueSet) {
                throw new IllegalStateException("Failed to set a cell to a value that should have been allowed");
            }

            boolean solvable = BacktrackingSolver.solveSudokuBoard(new OriginalSudokuBoard(board));
            if (!solvable) {
                board.resetCellToZero(randomCell);
            }
        }
        logger.info(board);
        return board;
    }

    private int getRandomEligibleValueForCell(GridCoordinates randomCell) {
        if (board.getCell(randomCell) != 0) {
            throw new IllegalArgumentException("Provided cell has already been populated");
        }

        List<Integer> eligibleValuesForCell = board.getEligibleValuesForCell(randomCell);
        Collections.shuffle(eligibleValuesForCell, random);
        return eligibleValuesForCell.get(0);
    }

    private GridCoordinates getRandomUnfilledCell() {
        List<GridCoordinates> emptyCells = getEmptyCells();
        Collections.shuffle(emptyCells, random);
        return emptyCells.get(0);
    }

    private List<GridCoordinates> getEmptyCells() {
        List<GridCoordinates> coordinates = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                GridCoordinates cell = GridCoordinates.of(row, column);
                if (board.getCell(cell) == 0) {
                    coordinates.add(cell);
                }
            }
        }
        return coordinates;
    }
}