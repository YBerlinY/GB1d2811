package lesson7.hw7;

import java.util.ArrayList;

public class MainHw7 {
    /**
     * 1. Расширить задачу про котов и тарелки с едой.
     * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать
     * 15-20).
     * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
     * 4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения
     * логики программы).
     * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
     * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
     */
    public static void main(String[] args) {
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Barsik", 20, "голоден"));
        cats.add(new Cat("Toshka", 35, "голоден"));
        cats.add(new Cat("Ryzik", 15, "голоден"));
        cats.add(new Cat("Belok", 45, "голоден"));
        cats.add(new Cat("Cherchil", 40, "голоден"));
        cats.add(new Cat("Puzan", 30, "голоден"));

        Plate plate = new Plate();

        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).eat(plate)) {
                System.out.printf("Кот %s поел %d корма, и он %s \n", cats.get(i).getName(), cats.get(i).getAppetite(), cats.get(i).getSatiety());
            } else {
                System.out.printf("Кот %s не смог поесть, и он %s \n", cats.get(i).getName(), cats.get(i).getSatiety());
                i--;
                plate.addFood();
            }
        }
    }
}
