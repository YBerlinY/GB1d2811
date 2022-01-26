package lesson6.hw6;

import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {

         ArrayList<Animals> animals=new ArrayList<>();
         animals.add(new Cat("cat1",250,0));
         animals.add(new Dog("dog1",330,100));
         animals.add(new Cat("cat2",500,50));
         animals.add(new Cat("cat3",450,30));
         animals.add(new Dog("dog2",100,150));
         animals.add(new Dog("dog3",300,150));

         Animals.anim();
         Cat.c();
         Dog.d();

      for (int i = 0; animals.size()>1; i++) {
         for (int j = 0; j <animals.size(); j++) {
            if (animals.get(j).run(150 + 25 * i) &&
                    animals.get(j).swim(20 + 10 * i)) {
            } else {
               animals.remove(j);
               j--;
            }
         }
      }
      System.out.println("Победитель: "+ animals);
   }

}
