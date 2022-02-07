package Lesson2;

import java.util.Arrays;

public class TriZvezdy {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(a));
        move(a, 4);
        System.out.println(Arrays.toString(a));
        move(a, -2);
        System.out.println(Arrays.toString(a));
    }

    public static void move(int[] array, int n) {
        int size = array.length;
        if (n > 0) { // сдвиг вправо
            for (int i = 0; i < n; i++) {
                int temp = array[size - 1]; //сохраняем последний элемент
                for (int j = size - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;// вставляем сохранённый элемент в начало массива
            }
        } else { // сдвиг влево
            for (int i = 0; i < -n; i++) {
                int temp = array[0]; //сохраняем первый элемент
                for (int j = 0; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = temp; //вставляем сохранённый элемент в конец массива
            }
        }
    }
}