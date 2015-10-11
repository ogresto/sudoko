package net.thumbtack.su.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveValidatorTest {

    private int[][] array;


    @Before
    public void setUp() throws Exception {
        array = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };
    }

    @Test
    public void isValidMove() {
        int x = 2;
        int y = 0;
        int value = 1;

        boolean b = MoveValidator.isValidMove(x, y, value, array);

        assertTrue(b);
    }

    @Test
    public void isValidMoveFailCellNotEmpty() {
        int x = 0;
        int y = 0;
        int value = 1;

        boolean b = MoveValidator.isValidMove(x, y, value, array);

        assertFalse(b);
    }

    @Test
    public void squareAlreadyHave() {
        int x = 1;
        int y = 1;
        int value = 6;

        boolean b = MoveValidator.isValidMove(x, y, value, array);

        assertFalse(b);
    }

    @Test
    public void rowAlreadyHave() {
        int x = 1;
        int y = 1;
        int value = 5;

        boolean b = MoveValidator.isValidMove(x, y, value, array);

        assertFalse(b);
    }

    @Test
    public void columnAlreadyHave() {
        int x = 1;
        int y = 1;
        int value = 9;

        boolean b = MoveValidator.isValidMove(x, y, value, array);

        assertFalse(b);
    }

    @Test
    public void isSquareContainedSameNumber() {
        int x = 1;
        int y = 1;
        int value = 8;

        boolean b = MoveValidator.isSquareContainedSameNumber(x, y, value, array);

        assertTrue(b);
    }

    @Test
    public void isNotSquareContainedSameNumber() {
        int x = 1;
        int y = 1;
        int value = 1;

        boolean b = MoveValidator.isSquareContainedSameNumber(x, y, value, array);

        assertFalse(b);
    }



    @Test
    public void isRowContainedSameValue() {
        int targetRow = 1;
        int value = 1;

        boolean b = MoveValidator.isRowContainedSameValue( targetRow, value, array);

        assertTrue(b);
    }

    @Test
    public void isRowContainedSameValueNo() {
        int targetRow = 1;
        int value = 2;

        boolean b = MoveValidator.isRowContainedSameValue( targetRow, value, array);

        assertFalse(b);
    }

    @Test
    public void isColumnContainedSameValue() {
        int targetRow = 1;
        int value = 3;

        boolean b = MoveValidator.isColumnContainedSameValue( targetRow, value, array);

        assertTrue(b);
    }

    @Test
    public void isColumnContainedSameValueNo() {
        int targetRow = 1;
        int value = 1;

        boolean b = MoveValidator.isColumnContainedSameValue( targetRow, value, array);

        assertFalse(b);
    }







}
