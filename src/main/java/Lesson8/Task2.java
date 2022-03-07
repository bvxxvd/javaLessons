package Lesson8;

public class Task2 {
    public static void main(String[] args) {

        Phonebook phonebook = new Phonebook();

        // с помощью метода add() добавляем записи в телефонный справочник
        phonebook.add("Ковалёв", "2(788)306-27-54");
        phonebook.add("Ларин", "43(055)209-03-15");
        phonebook.add("Ковалёв", "024(77)068-32-64");
        phonebook.add("Макарова", "152(213)435-70-12");
        phonebook.add("Ковалёв", "65(70)936-83-00");

        // с помощью метода get() получаем номер телефона по фамилии
        phonebook.get("Ковалёв"); // под одной фамилией может быть несколько телефонов
        phonebook.get("Макарова"); // или один
    }
}
