package lesson2.hw2;

public class Hw2 {
    public static void main(String[] args) {
        System.out.println(method1(5, 7));
        System.out.println(method2(25));
        System.out.println(method3(25));
        method4(4, "hello");
        System.out.println(method5(2100));
    }

    private static boolean method5(int year) {
        return year%4==0&&year%100!=0||year%400==0;
    }

    private static void method4(int e, String f) {
        for (int i = 0; i < e; i++) {
            System.out.println(f);
        }
    }

    private static boolean method3(int d) {
        return d < 0;
    }

    private static String method2(int c) {
        if (c < 0) {
            return "Отрицательное";
        } else {
            return "Положительное";
        }
    }

    private static boolean method1(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }
}
