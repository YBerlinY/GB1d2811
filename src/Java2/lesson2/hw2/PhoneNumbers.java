package Java2.lesson2.hw2;

import java.util.HashMap;

class PhoneNumbers {
    HashMap<String,String> numbers = new HashMap();

    public void add(String surname, String phone) {
        if (numbers.containsKey(surname)) {
            numbers.put(surname, numbers.get(surname) + " " + phone);
        } else {
            numbers.put(surname, phone);
        }
    }

    public void print() {
    System.out.printf("%s \n", numbers.entrySet());
    }

    public String get(String surname) {
    return numbers.get(surname);
    }
}

