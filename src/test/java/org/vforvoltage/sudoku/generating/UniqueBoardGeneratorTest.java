package org.vforvoltage.sudoku.generating;

import org.junit.jupiter.api.Test;
import org.vforvoltage.sudoku.model.SudokuBoard;

import java.util.Random;

class UniqueBoardGeneratorTest {

    @Test
    void generateUniqueBoard() {
        UniqueBoardGenerator generator = new UniqueBoardGenerator(new Random(1));
        SudokuBoard sudokuBoard = generator.generateUniqueBoard();
        System.out.println(sudokuBoard);
    }
}