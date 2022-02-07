package Lesson2;

public class Class2 {
    public static void main(String[] args) {
        isPositiveOrNegative(-1);
    }

    public static void isPositiveOrNegative(int y) {
        if (y >= 0) {
            System.out.println("Число " + y + " — положительное");
        } else {
            System.out.println("Число " + y + " — отрицательное");
        }
    }
}