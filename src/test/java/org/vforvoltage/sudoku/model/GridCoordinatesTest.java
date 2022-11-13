package org.vforvoltage.sudoku.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridCoordinatesTest {

    @Test
    void testSquare() {
        Assertions.assertEquals(0, GridCoordinates.of(0, 0).square());
        Assertions.assertEquals(0, GridCoordinates.of(0, 1).square());
        Assertions.assertEquals(0, GridCoordinates.of(0, 2).square());
        Assertions.assertEquals(0, GridCoordinates.of(1, 0).square());
        Assertions.assertEquals(0, GridCoordinates.of(1, 1).square());
        Assertions.assertEquals(0, GridCoordinates.of(1, 2).square());
        Assertions.assertEquals(0, GridCoordinates.of(2, 0).square());
        Assertions.assertEquals(0, GridCoordinates.of(2, 1).square());
        Assertions.assertEquals(0, GridCoordinates.of(2, 2).square());

        Assertions.assertEquals(1, GridCoordinates.of(0, 3).square());
        Assertions.assertEquals(1, GridCoordinates.of(0, 4).square());
        Assertions.assertEquals(1, GridCoordinates.of(0, 5).square());
        Assertions.assertEquals(1, GridCoordinates.of(1, 3).square());
        Assertions.assertEquals(1, GridCoordinates.of(1, 4).square());
        Assertions.assertEquals(1, GridCoordinates.of(1, 5).square());
        Assertions.assertEquals(1, GridCoordinates.of(2, 3).square());
        Assertions.assertEquals(1, GridCoordinates.of(2, 4).square());
        Assertions.assertEquals(1, GridCoordinates.of(2, 5).square());

        Assertions.assertEquals(2, GridCoordinates.of(0, 6).square());
        Assertions.assertEquals(2, GridCoordinates.of(0, 7).square());
        Assertions.assertEquals(2, GridCoordinates.of(0, 8).square());
        Assertions.assertEquals(2, GridCoordinates.of(1, 6).square());
        Assertions.assertEquals(2, GridCoordinates.of(1, 7).square());
        Assertions.assertEquals(2, GridCoordinates.of(1, 8).square());
        Assertions.assertEquals(2, GridCoordinates.of(2, 6).square());
        Assertions.assertEquals(2, GridCoordinates.of(2, 7).square());
        Assertions.assertEquals(2, GridCoordinates.of(2, 8).square());

        Assertions.assertEquals(3, GridCoordinates.of(3, 0).square());
        Assertions.assertEquals(3, GridCoordinates.of(3, 1).square());
        Assertions.assertEquals(3, GridCoordinates.of(3, 2).square());
        Assertions.assertEquals(3, GridCoordinates.of(4, 0).square());
        Assertions.assertEquals(3, GridCoordinates.of(4, 1).square());
        Assertions.assertEquals(3, GridCoordinates.of(4, 2).square());
        Assertions.assertEquals(3, GridCoordinates.of(5, 0).square());
        Assertions.assertEquals(3, GridCoordinates.of(5, 1).square());
        Assertions.assertEquals(3, GridCoordinates.of(5, 2).square());

        Assertions.assertEquals(4, GridCoordinates.of(3, 3).square());
        Assertions.assertEquals(4, GridCoordinates.of(3, 4).square());
        Assertions.assertEquals(4, GridCoordinates.of(3, 5).square());
        Assertions.assertEquals(4, GridCoordinates.of(4, 3).square());
        Assertions.assertEquals(4, GridCoordinates.of(4, 4).square());
        Assertions.assertEquals(4, GridCoordinates.of(4, 5).square());
        Assertions.assertEquals(4, GridCoordinates.of(5, 3).square());
        Assertions.assertEquals(4, GridCoordinates.of(5, 4).square());
        Assertions.assertEquals(4, GridCoordinates.of(5, 5).square());

        Assertions.assertEquals(5, GridCoordinates.of(3, 6).square());
        Assertions.assertEquals(5, GridCoordinates.of(3, 7).square());
        Assertions.assertEquals(5, GridCoordinates.of(3, 8).square());
        Assertions.assertEquals(5, GridCoordinates.of(4, 6).square());
        Assertions.assertEquals(5, GridCoordinates.of(4, 7).square());
        Assertions.assertEquals(5, GridCoordinates.of(4, 8).square());
        Assertions.assertEquals(5, GridCoordinates.of(5, 6).square());
        Assertions.assertEquals(5, GridCoordinates.of(5, 7).square());
        Assertions.assertEquals(5, GridCoordinates.of(5, 8).square());

        Assertions.assertEquals(6, GridCoordinates.of(6, 0).square());
        Assertions.assertEquals(6, GridCoordinates.of(6, 1).square());
        Assertions.assertEquals(6, GridCoordinates.of(6, 2).square());
        Assertions.assertEquals(6, GridCoordinates.of(7, 0).square());
        Assertions.assertEquals(6, GridCoordinates.of(7, 1).square());
        Assertions.assertEquals(6, GridCoordinates.of(7, 2).square());
        Assertions.assertEquals(6, GridCoordinates.of(8, 0).square());
        Assertions.assertEquals(6, GridCoordinates.of(8, 1).square());
        Assertions.assertEquals(6, GridCoordinates.of(8, 2).square());

        Assertions.assertEquals(7, GridCoordinates.of(6, 3).square());
        Assertions.assertEquals(7, GridCoordinates.of(6, 4).square());
        Assertions.assertEquals(7, GridCoordinates.of(6, 5).square());
        Assertions.assertEquals(7, GridCoordinates.of(7, 3).square());
        Assertions.assertEquals(7, GridCoordinates.of(7, 4).square());
        Assertions.assertEquals(7, GridCoordinates.of(7, 5).square());
        Assertions.assertEquals(7, GridCoordinates.of(8, 3).square());
        Assertions.assertEquals(7, GridCoordinates.of(8, 4).square());
        Assertions.assertEquals(7, GridCoordinates.of(8, 5).square());

        Assertions.assertEquals(8, GridCoordinates.of(6, 6).square());
        Assertions.assertEquals(8, GridCoordinates.of(6, 7).square());
        Assertions.assertEquals(8, GridCoordinates.of(6, 8).square());
        Assertions.assertEquals(8, GridCoordinates.of(7, 6).square());
        Assertions.assertEquals(8, GridCoordinates.of(7, 7).square());
        Assertions.assertEquals(8, GridCoordinates.of(7, 8).square());
        Assertions.assertEquals(8, GridCoordinates.of(8, 6).square());
        Assertions.assertEquals(8, GridCoordinates.of(8, 7).square());
        Assertions.assertEquals(8, GridCoordinates.of(8, 8).square());
    }

    @Test
    void testStartOfSquare() {
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(0, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(0, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(0, 2).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(1, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(1, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(1, 2).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(2, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(2, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 0), GridCoordinates.of(2, 2).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(0, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(0, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(0, 5).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(1, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(1, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(1, 5).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(2, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(2, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 3), GridCoordinates.of(2, 5).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(0, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(0, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(0, 8).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(1, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(1, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(1, 8).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(2, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(2, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(0, 6), GridCoordinates.of(2, 8).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(3, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(3, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(3, 2).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(4, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(4, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(4, 2).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(5, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(5, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 0), GridCoordinates.of(5, 2).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(3, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(3, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(3, 5).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(4, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(4, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(4, 5).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(5, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(5, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 3), GridCoordinates.of(5, 5).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(3, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(3, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(3, 8).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(4, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(4, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(4, 8).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(5, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(5, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(3, 6), GridCoordinates.of(5, 8).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(6, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(6, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(6, 2).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(7, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(7, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(7, 2).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(8, 0).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(8, 1).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 0), GridCoordinates.of(8, 2).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(6, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(6, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(6, 5).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(7, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(7, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(7, 5).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(8, 3).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(8, 4).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 3), GridCoordinates.of(8, 5).startOfSquare());

        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(6, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(6, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(6, 8).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(7, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(7, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(7, 8).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(8, 6).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(8, 7).startOfSquare());
        Assertions.assertEquals(GridCoordinates.of(6, 6), GridCoordinates.of(8, 8).startOfSquare());
    }
}