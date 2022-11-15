package org.vforvoltage.sudoku.model.board;

public class SimpleSudokuBoard extends AbstractSudokuBoard implements SudokuBoard {

    public SimpleSudokuBoard(int[][] board) {
        super(board);
    }

    public <T extends SudokuBoard> SimpleSudokuBoard(T sudokuBoard) {
        super(sudokuBoard);
    }

}