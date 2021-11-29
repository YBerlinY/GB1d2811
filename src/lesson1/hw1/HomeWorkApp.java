package lesson1.hw1;


public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void compareNumbers() {
        int a = 56;
        int b = 27;
        if (a >= b) {
            System.out.printf("%d>=%d", a, b);
        } else {
            System.out.printf("%d<%d", a, b);
        }
    }

    private static void printColor() {
        int value = 34;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (0 < value || value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    private static void checkSumSign() {
        int a = 5;
        int b = 7;
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


