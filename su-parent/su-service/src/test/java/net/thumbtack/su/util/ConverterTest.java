package net.thumbtack.su.util;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class ConverterTest {
    public static final String board = "530070000600195000098000060800060003400803001700020006060000280000419005000080079";
    public static final String board2 = "030070000600195000098000060800060003400803001700020006060000280000419005000080079";
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
    public void testConvert() throws Exception {
        int[][] matrix = Converter.convert(board);
        assertArrayEquals(matrix, array);
    }

    @Test
    public void testConvertNotTheSame() throws Exception {
        int[][] matrix = Converter.convert(board2);
        assertFalse(Arrays.deepEquals(matrix, array));
    }


    @Test
    public void testDeConvert() throws Exception {
        String s = Converter.deConvert(array);
        assertEquals(s, board);
    }

    @Test
    public void testDeConvertNotTheSame() throws Exception {
        String s = Converter.deConvert(array);
        assertNotEquals(s, board2);
    }
}