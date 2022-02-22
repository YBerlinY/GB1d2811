package Java2.lesson3.hw3;

public class Main {
    private static String[][] arrS = {
            {"1", "2", "3", "4"},
            { "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}};
    private static int[][] arrI = new int[4][4];
    private static int iEx = 0;
    private static int jEx = 0;

    public static void main(String[] args) {
        try {
            System.out.println(arrays(arrS, arrI));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            arrS = new String[][]{
                    {"1", "2", "3", "45"},
                    {"5", "6", "7", "8"},
                    {"9", "10", "11", "12"},
                    {"13", "14", "15", "16"}};
            System.out.printf("Ошибка исправлена. Новое значение: %d", arrays(arrS, arrI));
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            arrS[iEx][jEx] = "0";
            System.out.printf("Ошибка исправлена. Новое значение: %d", arrays(arrS, arrI));
        }


    }

    public static int arrays(String[][] arrS, int[][] arrI) throws MyArrayDataException, MyArraySizeException {
        int summ = 0;
        for (int i = 0; i < arrS.length; i++) {
            for (int j = 0; j < arrS[i].length; j++) {
                if (Main.arrS.length != 4 || arrS[i].length != 4) {
                    throw new MyArraySizeException(arrS.length, arrS[i].length);
                }
                try {
                    arrI[i][j] = Integer.parseInt(arrS[i][j]);
                    summ += arrI[i][j];
                } catch (NumberFormatException e) {
                    iEx = i;
                    jEx = j;
                    throw new MyArrayDataException(i, j, arrS[i][j]);
                }
            }
        }
        return summ;
    }
}
