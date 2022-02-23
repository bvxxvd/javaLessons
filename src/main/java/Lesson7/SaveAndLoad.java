package Lesson7;

public class SaveAndLoad {

    public static void main(String[] args) {

        // данные
        String[] header1 = new String[]{"Value 1", "Value 2", "Value 3"};
        int[][] data1 = new int[][]{{1000000, 2000000, 1230000}, {3000000, 4000000, 5000000}, {6000000, 7000000, 8000000}};

        String[] header2 = new String[]{"v1", "v2", "v3", "v4"};
        int[][] data2 = new int[][]{{10, 11, 12, 13}, {14, 15, 16, 17}, {18, 19, 20, 21}, {22, 23, 24, 25}};

        // Создаём экземпляры класса AppData
        AppData appData1 = new AppData(header1, data1);
        AppData appData2 = new AppData(header2, data2);
        AppData appData3 = new AppData();

        // Создаём csv файлы и сохраняем в них данные.
        Save file1 = new Save("src/main/java/Lesson7/File1.csv");
        file1.save(appData1);
        Save file2 = new Save("src/main/java/Lesson7/File2.csv");
        file2.save(appData2);

        // файлы для загрузки данных
        Load file3 = new Load("src/main/java/Lesson7/File3.csv");
        Load file4 = new Load("src/main/java/Lesson7/File4.csv");

        // Загружаем данные из файла File3.csv в appData3. Затем сохраним данные из appData3 в файл File5.csv
        file3.load(appData3);
        Save file5 = new Save("src/main/java/Lesson7/File5.csv");
        file5.save(appData3);

        // Выведем в консоль данные из файла File5.csv
        Load printFile5 = new Load("src/main/java/Lesson7/File5.csv");
        printHeader(printFile5.header());
        printData(printFile5.data());

        // Заменим данные в appData3 данными из файла File4.csv. Перезапишем файл File5.csv
        file4.load(appData3);
        file5.save(appData3);

        // Заново выведем в консоль данные из файла File5.csv
        printHeader(printFile5.header());
        printData(printFile5.data());

    }

    //  печать заголовка в консоль
    public static void printHeader(String[] header) {
        System.out.println();
        for (int i = 0; i < header.length; i++) {
            System.out.print(header[i]);
            if (i < header.length - 1) System.out.print(";");
        }
    }

    // печать данных в консоль
    public static void printData(int[][] data) {
        System.out.println();
        for (int[] row : data) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) System.out.print(";");
            }
            System.out.println();
        }
    }
}
