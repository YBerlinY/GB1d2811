package lesson6.hw6;

public abstract class Animals {
    protected String name;
    protected int swimLimit;
    protected int runLimit;
   static int anim=0;

    public Animals(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.swimLimit = swimLimit;
        this.runLimit = runLimit;
        anim++;
    }
    public static void anim(){
        System.out.println(anim);
    }

    public boolean run(int runDistance) {
        if (runDistance <= runLimit) {
            System.out.printf("%s пробежал %d метров!\n", name, runDistance);
        } else {
            System.out.printf("%s не смог пробежать дистанцию длинной %d метров!\n", name, runDistance);
        }
        return runDistance <= runLimit;
    }

    public boolean swim(int swimDistance) {
        if (swimDistance <= swimLimit) {
            System.out.printf("%s проплыл %d метров!\n", name, swimDistance);
        } else {
            System.out.printf("%s не смог проплыть дистанцию длинной %d метров!\n", name, swimDistance);
        }
        return swimDistance <= swimLimit;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                '}';
    }
}
