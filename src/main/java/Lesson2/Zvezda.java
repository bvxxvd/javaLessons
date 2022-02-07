package Lesson2;

public class Zvezda {
    public static void main(String[] args) {
        System.out.println(isVisokosnyi(1900));
    }

    public static boolean isVisokosnyi(int year) {
        if (year <= 1583) { // первый високосный год - 1584, отсекаем ранние
            return false;
        } else if (year % 4 != 0) { // отсекаем года, которые делятся на 4 с остатком
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) { // отсекаем года, которые кратны 100, но не кратны 400
            return false;
        } else {
            return true;
        }
    }
}
