package org.vforvoltage.sudoku.model.board;

public class SimpleSudokuBoard extends AbstractSudokuBoard implements SudokuBoard {

    public SimpleSudokuBoard(int[][] board) {
        super(board);
    }

    public <T extends AbstractSudokuBoard> SimpleSudokuBoard(T sudokuBoard) {
        super(sudokuBoard);
    }

}