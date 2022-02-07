package Lesson2;

import java.util.Arrays;

public class Class9 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArr(6, 10)));
    }

    public static int[] createArr(int len, int initialValue) {
        int[] a = new int[len];
        for (int i = 0; i < a.length; i++) {
            a[i] = initialValue;
        }
        return a;
    }
}


