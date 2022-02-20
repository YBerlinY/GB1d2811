package Java2.lesson1.hw1;

import java.util.ArrayList;
import java.util.LinkedList;

public class App {
    static int rDist = 1;
    static float jDist = 0.1f;

    public static void main(String[] args) {
        LinkedList<Participants> participants = new LinkedList<>();
        participants.add(new Human(Type.HUMAN, "Piter", 1000, 1.7f));
        participants.add(new Cat(Type.CAT, "Barsic", 537, 2.3f));
        participants.add(new Human(Type.HUMAN, "Sara", 470, 1.3f));
        participants.add(new Cat(Type.CAT, "Tishka", 145, 2.5f));
        participants.add(new Robot(Type.ROBOT, "R2D2", 800, 1.4f));
        participants.add(new Cat(Type.CAT, "Mihey", 255, 2.8f));
        participants.add(new Robot(Type.ROBOT, "LorTi5", 250, 1.2f));
        participants.add(new Robot(Type.ROBOT, "Villii", 1100, 1.1f));

        ArrayList<Trials> trials = new ArrayList<>();
        trials.add(new Treadmill(rDist));
        trials.add(new Wall(jDist));

        round(trials, participants);

        System.out.println();
        if (participants.size()==1) {
            System.out.printf("Победитель соревнований: %S\n", participants);
        }else {
            System.out.println("Победителей нет");
        }
    }

    static void whoStays(ArrayList<Trials> trials, LinkedList<Participants> participants) {
        for (int i = 0; i < trials.size(); i++) {
            for (int j = 0; j < participants.size(); j++) {
                if (!trials.get(i).go(participants.get(j))) {
                    participants.remove(j);
                    j--;
                }
            }
        }
    }

    static void round(ArrayList<Trials> trials, LinkedList<Participants> participants) {
        for (int n = 1; participants.size() > 1; n++) {
            System.out.println();
            System.out.printf("Раунд %d\n", n);
            System.out.println();

            whoStays(trials, participants);

            rDist += 50 * n;
            jDist += 0.2 * n;
            trials.set(0, new Treadmill(rDist));
            trials.set(1, new Wall(jDist));
        }
    }
}
