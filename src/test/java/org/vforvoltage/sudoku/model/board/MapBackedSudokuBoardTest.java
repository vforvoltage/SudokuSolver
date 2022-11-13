package org.vforvoltage.sudoku.model.board;

public class MapBackedSudokuBoardTest implements SudokuBoardTest<MapBackedSudokuBoard> {

    @Override
    public MapBackedSudokuBoard createSudokuBoard(int[][] boardArray) {
        return new MapBackedSudokuBoard(boardArray);
    }
}