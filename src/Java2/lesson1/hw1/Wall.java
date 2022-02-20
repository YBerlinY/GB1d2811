package Java2.lesson1.hw1;

public class Wall extends Trials {
    private final float height;

    public float getHeight() {
        return height;
    }

    public Wall(float height) {
        this.height = height;
    }

    @Override
    boolean go(Participants participants) {
        return participants.jump(this);
    }
}
