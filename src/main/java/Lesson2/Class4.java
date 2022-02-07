package Lesson2;

public class Class4 {
    public static void main(String[] args) {
            printWordNTimes("ooooh my", 5);
    }

    public static void printWordNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }
}