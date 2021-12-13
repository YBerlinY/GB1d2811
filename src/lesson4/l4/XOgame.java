package lesson4.l4;

import java.util.Random;
import java.util.Scanner;

public class XOgame {
    private static final int SIZE = 3;
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';
    private static final int DOTS_TO_WIN = 3;
    static char[][] field;

    static final Scanner scanner = new Scanner(System.in);
    static final Random random = new Random();


    public static void main(String[] args) {
        initField();
        printField();

        while (true) {

            goPleer( DOT_X);
            printField();
            if (isWin(DOT_X, DOTS_TO_WIN)) {
                System.out.println("Вы победили!");
                return;
            } else if (isFull()) {
                System.out.println("Ничья");
                return;
            }

            goComputer(DOT_O);
            printField();
            if (isWin(DOT_O, DOTS_TO_WIN)) {
                System.out.println("Вы проиграли, попробуйте ещё раз!");
                return;
            } else if (isFull()) {
                System.out.println("Ничья");
                return;
            }
        }
    }

    public static void initField() {
        field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {

        System.out.print("   ");
        for (int n = 0; n < SIZE; n++) {
            System.out.printf("%-3d", n + 1);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%-3d", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%-3c", field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void goPleer( char dot) {
        int x;
        int y;
        String msg = "Введите номер столбца, а затем номер строки";

        do {
            System.out.println(msg);
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            y = scanner.nextInt() - 1;
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            x = scanner.nextInt() - 1;

            msg = "Вы ошиблсть, введите номер поля заново";
        } while (!isCellValid(x, y));
        field[x][y] = dot;
    }

    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE && field[x][y] == DOT_EMPTY;
    }

    private static void goComputer( char dot) {
        int x;
        int y;
        if (CanIWin( dot, DOTS_TO_WIN,1)) {
            return;
        } else if (CanILose(dot, DOTS_TO_WIN,1)) {
            return;
        } else if (CanIWin( dot, DOTS_TO_WIN - 1,0.5f)) {
            return;
        } else if (CanILose(dot, DOTS_TO_WIN - 1,0.5f)) {
            return;
        } else {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }
            while (!isCellValid(x, y));
            field[x][y] = dot;
        }
    }

    private static boolean CanIWin( char dot, int DOTS_TO_WIN,float probability) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isCellValid(i, j)) {
                    field[i][j] = dot;
                    if (isWin(dot, DOTS_TO_WIN)&&
                            (Math.random() <= probability)) {
                        return true;
                    }
                    field[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private static boolean CanILose(char dot, int DOTS_TO_WIN,float probability) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isCellValid(i, j)) {
                    field[i][j] = DOT_X;
                    if (isWin(DOT_X, DOTS_TO_WIN)&&
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

    private static boolean isWin( char dot, int DOTS_TO_WIN) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (isLineWin(i, j, 0, 1, dot,DOTS_TO_WIN) ||
                        isLineWin(i, j, 1, 0, dot, DOTS_TO_WIN) ||
                        isLineWin(i, j, 1, 1, dot,DOTS_TO_WIN) ||
                        isLineWin(i, j, -1, 1, dot, DOTS_TO_WIN)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isLineWin(int stX, int stY, int dinX, int dinY, char dot, int DOTS_TO_WIN) {
        if (stX + dinX * (DOTS_TO_WIN - 1) > SIZE - 1 || stY + dinY * (DOTS_TO_WIN - 1) > SIZE - 1 || stX + dinX * (DOTS_TO_WIN - 1) < 0) {
            return false;
        }
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (field[stX + i * dinX][stY + i * dinY] != dot) {
                return false;
            }
        }
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
