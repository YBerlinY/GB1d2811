package lesson8;

import java.util.Random;

public class Logic {
    static int size;
    static int dotsToWin;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';
    static int res;
    static char[][] field;
    static int sX;
    static int sY;
    static int dX;
    static int dY;
    static boolean winLine = false;
    static final Random random = new Random();


    public static void initField() {
        field = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    static boolean isFinishedFGame() {

        if (isWin(DOT_X, dotsToWin)) {
            res = 1;
            winLine = true;
            return true;
        }
        if (isFull()) {
            res = 2;
            return true;
        }
        if (isWin(DOT_O, dotsToWin)) {
            res = 3;
            winLine = true;
            return true;
        }
        return false;
    }

    static void goPleer(int y, int x) {
        if (Logic.isCellValid(y, x)) {
            field[y][x] = DOT_X;
            if (!isFinishedFGame()) {
                goComputer(DOT_O);
                isFinishedFGame();
            }
        }
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && field[x][y] == DOT_EMPTY;
    }

    private static void goComputer(char dot) {
        int x;
        int y;
        if (canIWin(dot, dotsToWin, 1)) {
            return;
        } else if (canILose(dot, dotsToWin, 1)) {
            return;
        } else if (canIWin(dot, dotsToWin - 1, 0.5f)) {
            return;
        } else if (canILose(dot, dotsToWin - 1, 0.5f)) {
            return;
        } else {
            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
            }
            while (!isCellValid(x, y));
            field[x][y] = dot;
        }
    }

    private static boolean canIWin(char dot, int DOTS_TO_WIN, float probability) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isCellValid(i, j)) {
                    field[i][j] = dot;
                    if (isWin(dot, DOTS_TO_WIN) &&
                            (Math.random() <= probability)) {
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private static boolean canILose(char dot, int DOTS_TO_WIN, float probability) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isCellValid(i, j)) {
                    field[i][j] = DOT_X;
                    if (isWin(DOT_X, DOTS_TO_WIN) &&
                            (Math.random() <= probability)) {
                        field[i][j] = dot;
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private static boolean isWin(char dot, int DOTS_TO_WIN) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isLineWin(i, j, 0, 1, dot, DOTS_TO_WIN) ||
                        isLineWin(i, j, 1, 0, dot, DOTS_TO_WIN) ||
                        isLineWin(i, j, 1, 1, dot, DOTS_TO_WIN) ||
                        isLineWin(i, j, -1, 1, dot, DOTS_TO_WIN)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isLineWin(int stX, int stY, int dinX, int dinY, char dot, int DOTS_TO_WIN) {
        if (stX + dinX * (DOTS_TO_WIN - 1) > size - 1 || stY + dinY * (DOTS_TO_WIN - 1) > size - 1 || stX + dinX * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (field[stX + i * dinX][stY + i * dinY] != dot) {
                return false;
            }
        }
        sX = stY;
        sY = stX;
        dX = dinY;
        dY = dinX;
        return true;
    }

    private static boolean isFull() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

}
