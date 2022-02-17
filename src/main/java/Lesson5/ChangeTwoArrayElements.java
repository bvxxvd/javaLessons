package Lesson5;

import java.util.Arrays;

public class ChangeTwoArrayElements {
    public static void main(String[] args) {

        Integer[] a1 = {-473, 167, 912, -700, -433, 705};
        String[] a2 = {"hip hop", "jazz", "folk", "pop", "rock", "reggae"};

        System.out.println(Arrays.toString(a1));
        changeElements(a1, 0, 5);
        System.out.println(Arrays.toString(a1));

        System.out.println(Arrays.toString(a2));
        changeElements(a2, 3, 2);
        System.out.println(Arrays.toString(a2));
    }

    private static <T> void changeElements(T[] a, int el1, int el2) {
        T temp = a[el1];
        a[el1] = a[el2];
        a[el2] = temp;
    }
}
