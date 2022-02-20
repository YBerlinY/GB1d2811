package Java2.lesson2.hw2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        t1();
        t2();

    }

    private static void t1(){
        Map <String, Integer> map=new HashMap<>();
        String[] str = {"shark", "alligator", "alpaca", "anaconda",
                "shark", "camel", "beaver", "squirrel",
                "badger", "sheep", "antelope", "shark",
                "camel", "sheep", "alpaca", "alpaca"};

        for (int i = 0; i <str.length ; i++) {
            if (map.containsKey(str[i])){
                map.put(str[i],map.get(str[i])+1);
            }else {
                map.put(str[i],1);
            }
        }
        System.out.println(map);

    }
    private static void t2() {
        PhoneNumbers phoneNumbers=new PhoneNumbers();
        phoneNumbers.add("Eremin", "8(926)715-9863");
        phoneNumbers.add("Logunova", "8(916)349-8647");
        phoneNumbers.add("Lapygina", "8(916)964-8596");
        phoneNumbers.add("Lapygina", "8(926)354-9873");
        phoneNumbers.add("Eremin", "8(903)167-9857");
        phoneNumbers.add("Sherbakov", "8(905)349-6189");
        phoneNumbers.add("Eremin", "8(903)467-9825");
        phoneNumbers.add("Sherbakov", "8(965)967-853");

//        phoneNumbers.print();
        System.out.println(phoneNumbers.get("Logunova"));
        System.out.println(phoneNumbers.get("Lapygina"));
        System.out.println(phoneNumbers.get("Eremin"));
    }
}
