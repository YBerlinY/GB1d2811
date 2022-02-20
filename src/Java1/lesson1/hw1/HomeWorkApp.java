package Java1.lesson1.hw1;


public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(5,7);
        printColor(34);
        compareNumbers(56,27);
    }

    private static void compareNumbers(int a,int b) {

        if (a >= b) {
            System.out.printf("%d>=%d", a, b);
        } else {
            System.out.printf("%d<%d", a, b);
        }
    }

    private static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (0 < value || value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void checkSumSign(int a,int b) {

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
}


