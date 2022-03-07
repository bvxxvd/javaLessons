package Lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Phonebook { // класс телефонный справочник хранит в себе список фамилий и телефонных номеров
    private final Map<String, ArrayList<String>> myMap;

    public Phonebook() {
        this.myMap = new TreeMap<>();
    }

    public void add(String surname, String telephoneNumber) {
        myMap.put(surname, myMap.getOrDefault(surname, new ArrayList<>()));
        myMap.get(surname).add(telephoneNumber);
    }

    public void get(String surname) {
        List<String> telephoneNumber = myMap.get(surname);
        System.out.printf("%s %s%n", surname, telephoneNumber == null ? "- в списке нет такой записи" : telephoneNumber);
    }
}
