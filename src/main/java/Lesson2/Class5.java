package Lesson2;

import java.util.Arrays;

public class Class5 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 0, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
