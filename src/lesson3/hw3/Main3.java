package lesson3.hw3;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {

        int[] arr1 = {1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0};
        System.out.println(Arrays.toString(arrExchange(arr1)));

        int[] arr2 = new int[100];
        System.out.println(Arrays.toString(arrFull(arr2)));

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrMultiplication(arr3)));

        int[][] arr4 = new int[5][5];
        printArr(arrDiagonal(arr4));

        System.out.println(Arrays.toString(arrInitialValue(5, "hello")));

        int[] arr6 = {1, 8, 19, 7, 37, 46, 123, 5, 8, -7, 99};
        System.out.println("Max value of array: " + arrMax(arr6));
        System.out.println("Min value of array: " + arrMin(arr6));

        int[] arr7 = {1, 7, 5, 2, 10, 5};
        System.out.println(checkBalance(arr7, summArr(arr7)));

        int[] arr8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(Arrays.toString(arrShift(arr8, 6)));

    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    private static int[] arrExchange(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
        return arr;
    }

    /**
     * . Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 …100;
     */
    private static int[] arrFull(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    private static int[] arrMultiplication(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
        }
        return arr;
    }

    /**
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     * (можно только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
     * то есть [0][0], [1][1], [2][2], …, [n][n];
     */
    private static int[][] arrDiagonal(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = (i == j || i + j == arr.length - 1) ? 1 : 0;
            }
        }
        return arr;
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%-3d", arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа
     * int длиной len, каждая ячейка которого равна initialValue;
     */
    private static String[] arrInitialValue(int len, String initialValue) {
        String[] arr = new String[len];

        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    /**
     * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
     */
    private static int arrMax(int[] arr) {
        int n = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (n < arr[i]) {
                n = arr[i];
            }
        }
        return n;
    }

    private static int arrMin(int[] arr) {
        int n = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (n > arr[i]) {
                n = arr[i];
            }
        }
        return n;
    }

    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     * если в массиве есть место, в котором сумма левой и правой части массива равны.
     * checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
     * checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
     * checkBalance([1, 14, 1, ||| 2, 1, 6, 7]) → true, т.е. 1 + 14 + 1 = 2 + 1 + 6 + 7
     * граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
     */
    private static boolean checkBalance(int[] arr, int summ) {
        int n = 0;
        if (summ % 2 == 0) {
            for (int i = 0; i < arr.length; i++) {
                n += arr[i];
                if (n == summ / 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int summArr(int[] arr) {
        int summ = 0;

        for (int i = 0; i < arr.length; i++) {
            summ += arr[i];
        }
        return summ;
    }

    /**
     * Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
     * отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
     * Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1
     * (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
     * При каком n в какую сторону
     * сдвиг можете выбирать сами.
     */
    private static int[] arrShift(int[] arr, int n) {
        int k = (n < 0) ? (n % arr.length + arr.length) : (n % arr.length);

        for (int i = 0; i < k; i++) {
            int arrZiro = arr[arr.length - 1];

            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = arrZiro;
        }
        return arr;
    }

}
