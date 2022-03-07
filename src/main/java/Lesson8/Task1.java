package Lesson8;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        // создаём массив слов, который содержит повторяющиеся слова
        String[] a = {"Арбуз", "Брусника", "Вишня", "Годжи", "Дереза", "Арбуз", "Брусника", "Вишня",
                "Годжи", "Арбуз", "Брусника", "Вишня", "Арбуз", "Брусника", "Арбуз"};
        System.out.println("Массив с повторяющимися словами: " + Arrays.toString(a));

        // выводим список уникальных слов массива
        Set<String> mySet = new TreeSet<>(Arrays.asList(a));
        System.out.println("Список уникальных слов массива: " + mySet);

        // считаем, сколько раз встречается каждое слово в массиве
        Map<String, Integer> myMap = new TreeMap<>();
        for (String word : a) {
            myMap.put(word, myMap.getOrDefault(word, 0) + 1);
        }
        System.out.println("Посчитаем, сколько раз встречается каждое слово в массиве: " + myMap);
    }
}
