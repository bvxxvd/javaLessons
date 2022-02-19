package Lesson6;

public class ConvertAndSum {
    public static void main(String[] args) {
        String[][] correctSizeArray = {{"88", "11", "41", "91"}, {"90", "29", "32", "61"}, {"14", "52", "80", "71"}, {"96", "79", "68", "97"}};
        String[][] wrongSizeArray = {{"88", "11", "41", "91"}, {"90", "29", "32", "61"}, {"14", "52", "80", "71"}, {"96", "79", "68", "97", "12345"}};
        String[][] wrongDataArray = {{"88", "11", "41", "91"}, {"90", "29", "32", "61"}, {"14", "52", "80", "71"}, {"96", "79", "68", "Bye"}};

        try {
            System.out.print("Массив правильного размера. ");
            System.out.println("Сумма элементов массива — " + convertAndSum(correctSizeArray) + ".\n");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Массив неверного размера. ");
            System.out.println("Сумма элементов массива — " + convertAndSum(wrongSizeArray) + ".\n");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print("Массив с неверными данными. ");
            System.out.println("Сумма элементов массива — " + convertAndSum(wrongDataArray) + ".\n");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    static int convertAndSum(String[][] stringArray) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (stringArray.length != 4) throw new MyArraySizeException(); // если количество строк в массиве не равно 4
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != 4)
                throw new MyArraySizeException(); // если количество столбцов в массиве не равно 4
            for (int j = 0; j < stringArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j); // если преобразование не удалось
                }
            }
        }

        return sum;
    }
}

class CustomException extends Exception {
    CustomException(String message) {
        super(message);
    }
}

class MyArraySizeException extends CustomException {
    MyArraySizeException() {
        super("Массив должен быть размером 4х4.\n");
    }
}

class MyArrayDataException extends CustomException {
    MyArrayDataException(int row, int col) {
        super(String.format("В ячейке [%d, %d] лежат неверные данные.\n", row, col));
    }
}
