package net.thumbtack.su.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoveValidator {

    private static final int GRID_LENGTH = 9;
    private static final int SUB_GRID_LENGTH = 3;

    public static boolean isValidMove(int x, int y, int number, int[][] board) {
        if (board[x][y] != 0) return false;
        if (isRowContainedSameValue(x, number, board)) return false;
        if (isColumnContainedSameValue(y, number, board)) return false;
        if (isSquareContainedSameNumber(x, y, number, board)) return false;
        return true;
    }

    protected static boolean isSquareContainedSameNumber(int targetRow, int targetColumn, int value, int[][] board) {
        int cell = calcTargetSquare(targetRow, targetColumn);

        int[] startCoordinates = getStartCoordinatesByCell(cell);

        for (int i = startCoordinates[0]; i < startCoordinates[0] + SUB_GRID_LENGTH; i++) {
            for (int j = startCoordinates[1]; j < startCoordinates[1] + SUB_GRID_LENGTH; j++) {
                if (board[i][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }


    private static int calcTargetSquare(int rowToCheck, int columnToCheck) {
        List<Integer> suspectX = getSuspectCellsX(rowToCheck);
        List<Integer> suspectY = getSuspectCellsY(columnToCheck);

        List<Integer> guilty = new LinkedList<>();
        guilty.addAll(suspectX);
        guilty.retainAll(suspectY);

        return guilty.iterator().next();
    }

    private static List<Integer> getSuspectCellsY(int columnToCheck) {
        List<Integer> result = new ArrayList<>(SUB_GRID_LENGTH);
        switch (columnToCheck) {
            case 0:
            case 1:
            case 2:
                result = Arrays.asList(1, 4, 7);
                break;
            case 3:
            case 4:
            case 5:
                result = Arrays.asList(2, 5, 8);
                break;
            case 6:
            case 7:
            case 8:
                result = Arrays.asList(3, 6, 9);
                break;
        }
        return result;
    }

    private static List<Integer> getSuspectCellsX(int rowToCheck) {
        List<Integer> result = new ArrayList<>(SUB_GRID_LENGTH);
        switch (rowToCheck) {
            case 0:
            case 1:
            case 2:
                result = Arrays.asList(1, 2, 3);
                break;
            case 3:
            case 4:
            case 5:
                result = Arrays.asList(4, 5, 6);
                break;
            case 6:
            case 7:
            case 8:
                result = Arrays.asList(7, 8, 9);
                break;
        }
        return result;
    }

    private static int[] getStartCoordinatesByCell(int cell) {
        switch (cell) {
            case 1:
                return new int[]{0, 0};
            case 2:
                return new int[]{0, 3};
            case 3:
                return new int[]{0, 6};
            case 4:
                return new int[]{3, 0};
            case 5:
                return new int[]{3, 3};
            case 6:
                return new int[]{3, 6};
            case 7:
                return new int[]{6, 0};
            case 8:
                return new int[]{6, 3};
            case 9:
                return new int[]{6, 6};
            default:
                throw new IllegalArgumentException("Not supported value:" + cell);
        }
    }

    protected static boolean isRowContainedSameValue(int targetRow, int value, int[][] board) {
        for (int column = 0; column < GRID_LENGTH; column++) {
            if (board[targetRow][column] == value) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isColumnContainedSameValue(int targetColumn, int value, int[][] board) {
        for (int row = 0; row < GRID_LENGTH; row++) {
            if (board[row][targetColumn] == value) {
                return true;
            }
        }
        return false;
    }
}
