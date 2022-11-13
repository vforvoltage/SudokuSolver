package org.vforvoltage.sudoku.generating;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.board.SimpleSudokuBoard;
import org.vforvoltage.sudoku.model.board.SudokuBoard;

import java.util.Random;

import static org.vforvoltage.sudoku.testutil.TestBoardHelper.ALL_ZEROS;

class UniqueBoardGeneratorTest {

    @Test
    void generateUniqueBoard() {
        UniqueBoardGenerator generator = new UniqueBoardGenerator(new SimpleSudokuBoard(ALL_ZEROS()), new Random(1));
        SudokuBoard sudokuBoard = generator.generateUniqueBoard();
        SudokuBoard expected = new SimpleSudokuBoard(new int[][]{
                {9, 4, 2, 7, 1, 6, 3, 8, 5},
                {5, 1, 3, 8, 4, 2, 9, 7, 6},
                {8, 7, 6, 9, 5, 3, 2, 1, 4},
                {7, 8, 4, 2, 9, 5, 1, 6, 3},
                {6, 5, 1, 4, 3, 8, 7, 9, 2},
                {3, 2, 9, 1, 6, 7, 5, 4, 8},
                {4, 6, 7, 5, 2, 1, 8, 3, 9},
                {2, 3, 8, 6, 7, 9, 4, 5, 1},
                {1, 9, 5, 3, 8, 4, 6, 2, 7}});
        Assertions.assertEquals(expected, sudokuBoard);

        generator = new UniqueBoardGenerator(new SimpleSudokuBoard(ALL_ZEROS()), new Random(127));
        sudokuBoard = generator.generateUniqueBoard();
        expected = new SimpleSudokuBoard(new int[][]{
                {1, 7, 6, 3, 8, 2, 4, 5, 9},
                {9, 4, 3, 5, 1, 7, 8, 2, 6},
                {2, 8, 5, 4, 6, 9, 1, 7, 3},
                {4, 5, 9, 8, 2, 1, 6, 3, 7},
                {6, 1, 2, 7, 4, 3, 9, 8, 5},
                {7, 3, 8, 9, 5, 6, 2, 1, 4},
                {8, 9, 1, 6, 7, 5, 3, 4, 2},
                {5, 6, 4, 2, 3, 8, 7, 9, 1},
                {3, 2, 7, 1, 9, 4, 5, 6, 8}});
        Assertions.assertEquals(expected, sudokuBoard);
    }
}