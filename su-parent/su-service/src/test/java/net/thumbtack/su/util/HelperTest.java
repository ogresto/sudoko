package net.thumbtack.su.util;


import net.thumbtack.su.entity.MoveResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelperTest {

    private static final String BOARD = "530070000600195300098000060800060003400803001700020006060000280000419005000080079";
    private static final String SOLVED_BOARD = "534678912672195348198342567859761423426853791713924856961537284287419635345286179";

    @Test
    public void testBoardCreation() {
        final int expected = 30;


        String board = Helper.generateRandomBoard();
        int toltalGeneratedNumbers = 0;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) != '0')
                toltalGeneratedNumbers++;
        }
        int actual = toltalGeneratedNumbers;
        assertEquals(expected, actual);
    }

    @Test
    public void testBoardCreatedIsValid() {
        int row = 4;
        int column = 4;
        int number = 8;
        int matrix[][] = Converter.convert(BOARD);
        assertTrue(MoveValidator.isRowContainedSameValue(row, number, matrix));
        assertTrue(MoveValidator.isColumnContainedSameValue(column, number, matrix));
        assertTrue(MoveValidator.isSquareContainedSameNumber(row, column, number, matrix));
    }

    @Test
    public void testIfMoveIsValid() {
        final MoveResult actual = Helper.checkMove(4, 4, 5, BOARD);
        final MoveResult expected = MoveResult.VALID;
        assertEquals(expected, actual);
    }

    @Test
    public void testIfMoveIsInValid() {
        final MoveResult actual = Helper.checkMove(1, 6, 1, BOARD);
        final MoveResult expected = MoveResult.INVALID;
        assertEquals(expected, actual);
    }

    @Test
    public void testIfComplete() {
        final MoveResult actual = Helper.checkMove(1, 6, 1, SOLVED_BOARD);
        final MoveResult expected = MoveResult.COMPLETE;
        assertEquals(expected, actual);
    }


}
