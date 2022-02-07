package Lesson2;

public class Class8 {
    public static void main(String[] args) {
        int[][] a = {{5, 7, 3, 17, 4}, {6, 4, 0, 9, 1}, {2, 0, 8, 5, 3}, {7, 2, 14, 3, 22}, {22, 3, 31, 5, 7}};
        printArr(a);
        for (int i = 0; i < a.length; i++) {
            a[i][i] = 1;
            a[a.length - 1 - i][i] = 1;
        }
        System.out.println();
        printArr(a);
    }
    public static void printArr(int[][] arr) { // вывод двумерного массива на консоль
        for (int[] row : arr) {
            for (int element : row) {
                System.out.printf("%5d", element);
            }
            System.out.println();
        }
    }
}