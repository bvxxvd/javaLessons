package Lesson7;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Save {

    private final File file;

    // Конструктор класса
    public Save(String fileName) {
        this.file = new File(fileName);
    }

    // запись в файл
    public void save(AppData appData) {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < appData.getHeader().length; i++) {
                out.write((appData.getHeader()[i]).getBytes(StandardCharsets.UTF_8));
                if (i < appData.getHeader().length - 1) out.write((";").getBytes(StandardCharsets.UTF_8));
            }

            out.write("\n".getBytes(StandardCharsets.UTF_8));

            for (int i = 0; i < appData.getData().length; i++) {
                for (int j = 0; j < appData.getData()[i].length; j++) {
                    out.write((Integer.toString(appData.getData()[i][j])).getBytes(StandardCharsets.UTF_8));
                    if (j < appData.getData()[i].length - 1) out.write((";").getBytes(StandardCharsets.UTF_8));
                }
                if (i < appData.getData().length - 1) out.write("\n".getBytes(StandardCharsets.UTF_8));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
