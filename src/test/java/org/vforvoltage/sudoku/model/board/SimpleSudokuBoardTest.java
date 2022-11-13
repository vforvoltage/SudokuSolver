package org.vforvoltage.sudoku.model.board;

public class SimpleSudokuBoardTest implements SudokuBoardTest<SimpleSudokuBoard> {
    @Override
    public SimpleSudokuBoard createSudokuBoard(int[][] boardArray) {
        return new SimpleSudokuBoard(boardArray);
    }
}