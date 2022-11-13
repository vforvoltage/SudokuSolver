package org.vforvoltage.sudoku.generating;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.vforvoltage.sudoku.model.GridCoordinates;
import org.vforvoltage.sudoku.model.board.SimpleSudokuBoard;
import org.vforvoltage.sudoku.model.board.SudokuBoard;
import org.vforvoltage.sudoku.solving.BacktrackingSolutionFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.vforvoltage.sudoku.util.TestBoards.ALL_ZEROS;

public class UnsolvedBoardGenerator {

    private static final Logger logger = LogManager.getLogger(UnsolvedBoardGenerator.class);

    private final Random random;

    public UnsolvedBoardGenerator(Random random) {
        this.random = random;
    }

    public SudokuBoard generateUnsolvedBoard() {

        UniqueBoardGenerator uniqueBoardGenerator = new UniqueBoardGenerator(new SimpleSudokuBoard(ALL_ZEROS()), random);
        SudokuBoard board = uniqueBoardGenerator.generateUniqueBoard();

        List<GridCoordinates> cells = getCellsInRandomOrder();

        for (GridCoordinates cell : cells) {
            int value = board.getCell(cell);
            board.resetCellToNoValue(cell);
            BacktrackingSolutionFinder solutionFinder = new BacktrackingSolutionFinder(2);
            if (solutionFinder.findNumberOfSolutions(new SimpleSudokuBoard(board.getCopyOfBoardArray())) > 1) {
                board.trySettingCell(cell, value);
            }
        }

        return board;
    }

    private List<GridCoordinates> getCellsInRandomOrder() {
        List<GridCoordinates> coordinates = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                coordinates.add(GridCoordinates.of(row, column));
            }
        }
        Collections.shuffle(coordinates, random);
        return coordinates;
    }
}