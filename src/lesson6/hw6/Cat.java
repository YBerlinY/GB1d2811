package lesson6.hw6;

public class Cat extends Animals{
     static int c=0;

    public Cat(String name, int runLimit, int swimLimit) {
        super(name,runLimit,swimLimit);
        c++;
    }
    public static void c (){
        System.out.println(c);
    }

}
