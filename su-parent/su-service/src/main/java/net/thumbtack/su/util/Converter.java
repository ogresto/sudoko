package net.thumbtack.su.util;


public class Converter {

    public static int[][] convert(String board) {
        int result[][] = new int[Const.ROWS][Const.COLUMNS];
        for (int row = 0; row < Const.ROWS; row++) {
            for (int column = 0; column < Const.COLUMNS; column++) {
                int i = Character.getNumericValue(board.charAt(row * Const.COLUMNS + column));
                result[row][column] = i;
            }
        }
        return result;
    }

    public static String deConvert(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Const.ROWS; i++) {
            for (int j = 0; j < Const.COLUMNS; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }


}
