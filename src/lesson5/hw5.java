package lesson5;

import java.util.ArrayList;

public class hw5 {
    public static void main(String[] args) {
        ArrayList<Employee> employers = new ArrayList<>();
        employers.add(new Employee("Suslov Artem", "manager", "89256843625@mail.ru", "89244569325", 75000, 46));
        employers.add(new Employee("Blinkov Rustam", "manager", "89256843625@mail.ru", "89244569325", 80000, 35));
        employers.add(new Employee("Avdeeva Anna", "manager", "89256843625@mail.ru", "89244569325", 95000, 55));
        employers.add(new Employee("Kumov Anton", "manager", "89256843625@mail.ru", "89244569325", 65000, 25));
        employers.add(new Employee("Berengov Vital", "manager", "89256843625@mail.ru", "89244569325", 45000, 23));
        for (int i = 0; i < employers.size(); i++) {
            if (employers.get(i).getAge()>40){
                System.out.println(employers.get(i));
            }
        }
    }
}
