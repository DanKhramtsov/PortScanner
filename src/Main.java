/*
ТЗ: Реализовать java приложение сканер сети, приложение должно на вход получать ip адрес
и проводить сканирование сети, находить активные устройства и получать список доступных портов.
Информацию выводить в консоль и запрашивать у пользователя сохранение в файл формата txt или csv

 1) Получить ip адресс
 2) Просканировать порты
 3) Сохранить инфу в arraylist
 4) Создать папку, если ее нет
 5) Создать файл и записать содержимое arrayList
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        String ip = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите IP адресс для сканирования портов:");

        ip = scanner.nextLine();
        while (ip.isEmpty()) {
            System.out.println("IP адрес не может быть пустым. Введите действительный IP:");
            ip = scanner.nextLine();
        }
        scanner.close();

        NetworkScanner.networkScan(ip);

        SaveToFile.saveFile(scanner);
    }

}
