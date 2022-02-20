package Java2.lesson1.hw1;

public class Cat implements Participants {
    private final String name;
    private final int runLimit;
    private final float jumpLimit;
    private final Enum type;

    public Cat(Enum type, String name, int runLimit, float jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.type=type;
    }

    @Override
    public boolean run(Treadmill treadmill) {
        if (treadmill.getDistance() <= runLimit) {
            System.out.printf("%s преодолел расттояние в %d метра(ов)\n",this, treadmill.getDistance());
            return true;
        } else {
            System.out.printf("%s не смог преодолеть расттояние в %d метра(ов) и выбывает\n",this, treadmill.getDistance());
            return false;
        }
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.getHeight() <= jumpLimit) {
            System.out.printf("%s преодолел препятствие высотой %.1f метра(ов)\n",this, wall.getHeight());
            return true;
        } else {
            System.out.printf("%s не смог преодолеть препятствие высотой %.1f метра(ов) и выбывает\n",this, wall.getHeight());
            return false;
        }
    }
    @Override
    public String toString() {
        return  type +" "+ name;
    }
}
