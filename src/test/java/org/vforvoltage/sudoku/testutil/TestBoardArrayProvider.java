package org.vforvoltage.sudoku.testutil;

import java.util.stream.Stream;

import static org.vforvoltage.sudoku.testutil.TestBoardHelper.ALL_ONES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.ALL_ZEROS;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.ALMOST_FULL;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.ALMOST_SOLVED;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.MISSING_DIAGONAL;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.SOLVED;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.SOLVED_1;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.SOLVED_2;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES;
import static org.vforvoltage.sudoku.testutil.TestBoardHelper.VALID_ROWS_VALID_COLUMNS_VALID_SQUARES;

public class TestBoardArrayProvider {

    public static Stream<int[][]> fullBoardArrays() {
        return Stream.of(ALL_ONES(), SOLVED(), SOLVED_1(), SOLVED_2());
    }

    public static Stream<int[][]> notFullBoardArrays() {
        return Stream.of(ALL_ZEROS(), ALMOST_SOLVED(), ALMOST_FULL(), MISSING_DIAGONAL());
    }

    public static Stream<int[][]> validBoardArrays() {
        return Stream.of(SOLVED(), SOLVED_1(), SOLVED_2(), ALL_ZEROS(), MISSING_DIAGONAL(), VALID_ROWS_VALID_COLUMNS_VALID_SQUARES());
    }

    public static Stream<int[][]> notValidBoardArrays() {
        return Stream.of(ALL_ONES(),
                INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES(),
                INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES(),
                INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES(),
                INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES(),
                VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES(),
                VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES(),
                VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES());
    }

    public static Stream<int[][]> solvedBoardArrays() {
        return Stream.of(SOLVED(), SOLVED_1(), SOLVED_2());
    }

    public static Stream<int[][]> notSolvedBoardArrays() {
        return Stream.of(ALL_ONES(), ALL_ZEROS(), MISSING_DIAGONAL(), ALMOST_SOLVED(), ALMOST_FULL(),
                INVALID_ROWS_VALID_COLUMNS_VALID_SQUARES(),
                INVALID_ROWS_INVALID_COLUMNS_VALID_SQUARES(),
                INVALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES(),
                INVALID_ROWS_VALID_COLUMNS_INVALID_SQUARES(),
                VALID_ROWS_VALID_COLUMNS_INVALID_SQUARES(),
                VALID_ROWS_INVALID_COLUMNS_VALID_SQUARES(),
                VALID_ROWS_INVALID_COLUMNS_INVALID_SQUARES());
    }

    public static Stream<int[][]> testGetCellArrays() {
        return Stream.of(ALL_ZEROS(), ALL_ONES(), SOLVED(), SOLVED_1(), SOLVED_2(), ALMOST_SOLVED(), ALMOST_FULL());
    }
}