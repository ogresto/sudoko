package net.thumbtack.su.util;

import net.thumbtack.su.entity.MoveResult;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Helper {



    public static String generateRandomBoard() {
        int result[][] = new int[Const.ROWS][Const.COLUMNS];
        final int count[] = new int[1]; //variable used in lambda expression should be a little bit final

        while (count[0] < Const.AMOUNT_PRE_STATED_CELLS) {
            int x = getRandomNumberFromRange(0, Const.ROWS);
            int y = getRandomNumberFromRange(0, Const.COLUMNS);

            List<Integer> shuffled = getShuffledPossibleValues();

            shuffled.stream().forEach(i ->
            {
                if (MoveValidator.isValidMove(x, y, i, result)) {
                    result[x][y] = i;
                    count[0]++;
                }
            });
        }
        return Converter.deConvert(result);
    }



    public static String updateMove(int x, int y, int value, String board) {
        final int[][] result = Converter.convert(board);
        result[x][y] = value;

        return Converter.deConvert(result);
    }

    public static MoveResult checkMove(int x, int y, int value, String board) {
        int[][] matrix = Converter.convert(board);

        if (isSolved(matrix)) {
            return MoveResult.COMPLETE;
        }

        boolean isValid = MoveValidator.isValidMove(x, y, value, matrix);

        if (isValid) {
            return MoveResult.VALID;
        } else {
            return MoveResult.INVALID;
        }
    }

    private static List<Integer> getShuffledPossibleValues() {
        final int maxPossibleValue = 9;
        final int minPossibleValue = 1;
        List<Integer> list = IntStream
                .rangeClosed(minPossibleValue, maxPossibleValue)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(list);
        return list;
    }


    private static boolean isSolved(int[][] board) {
        for (int row = 0; row < Const.ROWS; row++) {
            for (int column = 0; column < Const.COLUMNS; column++) {
                if (board[column][row] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param min inclusive.
     * @param max exclusive.
     * @return
     */
    private static int getRandomNumberFromRange(int min, int max) {
        Random rand = new Random();
        return rand
                .ints(min, max)
                .limit(1)
                .findAny()
                .getAsInt();
    }
}
