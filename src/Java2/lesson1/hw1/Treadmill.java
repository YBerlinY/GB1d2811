package Java2.lesson1.hw1;

public class Treadmill extends Trials {
    private final int distance;

    public int getDistance() {
        return distance;
    }

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
     boolean go(Participants participants) {
      return participants.run(this);
    }
}
