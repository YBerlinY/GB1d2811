package lesson7.hw7;

public class Plate {
    private int food = 100;

    public boolean decrease(int appetite) {
        if (food >= appetite) {
            food -= appetite;
            return true;
        } else {
            return false;
        }
    }
    public void addFood(){
        int add=50;
        System.out.printf("В тарелку добавили %d корма\n",add);
        food+=add;
    }
}
