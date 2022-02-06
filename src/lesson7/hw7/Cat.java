package lesson7.hw7;

public class Cat {
    private final String name;
    private final int appetite;
    private String satiety;

    public Cat(String name, int appetite, String satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }
    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getSatiety() {
        return satiety;
    }

    public boolean eat(Plate plate) {
        if (plate.decrease(appetite)) {
            satiety = "сыт";
            return true;
        } else return false;
    }
}
