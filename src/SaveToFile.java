import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveToFile {

    public static void saveFile(Scanner scanner) {
        String path;
        String fileFormat;

        System.out.println("Чтобы сохранить информацию в файл, введите 1,\n" +
                "чтобы выйти, нажмите \"Enter\"");

        String answer;
        answer = scanner.nextLine();

        if (answer.equals("1")) {
            System.out.println("Введите путь для сохранения файла:");
            path = scanner.nextLine();
            System.out.println("Выберите формат файла:\n1 - .txt\n2 - .csv");
            fileFormat = scanner.nextLine();
            while (!fileFormat.equals("1") && !fileFormat.equals("2")) {
                System.out.println("Цифры могут быть только 1 или 2. Попробуйте еще раз:");
                fileFormat = scanner.nextLine();
            }
            if (fileFormat.equals("1")) {
                fileFormat = "txt";
            } else if (fileFormat.equals("2")) {
                fileFormat = "csv";
            }

            File file = new File(path);
            if (!file.isDirectory()) file.mkdir();

            String pathAndName = path + "/log." + fileFormat;

            try {
                FileWriter fileWriter = new FileWriter(pathAndName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("IP адресс;открытый порт");
                bufferedWriter.newLine();

                for (String s : Main.arrayList) {
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();

                System.out.println("Файл успешно создан и записан.");
            } catch (IOException e) {
                System.out.println("Ошибка при создании или записи файла: " + e.getMessage());
            }
        }
    }
}