package Lesson7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Load {

    private final File file;

    public Load(String fileName) {

        this.file = new File(fileName);
    }

    // считаем строки
    public int countRows() {

        int rows = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = in.readLine(); // читаем первую строку файла
            while ((result = in.readLine()) != null) { // читаем остальные строки, после первой
                rows++; // считаем количество строк
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // считаем столбцы
    public int countCols() {

        ArrayList<String> headerList;

        int cols = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = in.readLine();
            headerList = new ArrayList<>(Arrays.stream(result.split(";")).toList());
            cols = headerList.size();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return cols;
    }

    // массив заголовка
    public String[] header() {

        ArrayList<String> headerList;

        String[] header = new String[countCols()];

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = in.readLine();
            headerList = new ArrayList<>(Arrays.stream(result.split(";")).toList());

            // Инициализируем массив заголовка
            for (String s : headerList) {
                header[headerList.indexOf(s)] = s;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return header;
    }

    // массив с данными
    public int[][] data() {

        int[][] data = new int[countRows()][countCols()];

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = in.readLine();

            while ((result = in.readLine()) != null) {
                for (int i = 0; i < countRows(); i++) {
                    String[] tmp = result.split(";"); // временный массив
                    for (int j = 0; j < countCols(); j++) {
                        data[i][j] = Integer.parseInt(tmp[j]);
                    }
                    result = in.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public void load(AppData appData) {
        appData.setHeader(header());
        appData.setData(data());
    }
}
