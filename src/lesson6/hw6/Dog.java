package lesson6.hw6;

public class Dog extends Animals {
    static int d=0;
    public Dog(String name, int runLimit, int swimLimit) {
        super(name, runLimit, swimLimit);
        d++;
    }
    public static void d (){
        System.out.println(d);
    }

}

