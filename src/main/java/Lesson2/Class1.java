package Lesson2;

public class Class1 {
    public static void main(String[] args) {
        System.out.println(within10and20(0, -7));
    }

    public static boolean within10and20(int x1, int x2) {
        return 10 <= x1 + x2 && x1 + x2 <= 20;
    }
}