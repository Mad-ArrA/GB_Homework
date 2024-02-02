package ru.gb.hm10;
import java.util.*;

public class Task2 {
    static Scanner scanner = new Scanner(System.in);
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String name, String phone) {
        // Если фамилия уже есть в телефонном справочнике, добавляем новый номер к существующей записи
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        }
        else {
            // Если фамилии нет в телефонном справочнике, создаем новую запись
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phoneBook.put(name, phones);

        }
    }

    public List<String> get(String name) {
        // Если фамилия есть в телефонном справочнике, возвращаем список номеров
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        } else {
            // Если фамилии нет в телефонном справочнике, возвращаем пустой список
            return new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        Task2 phoneBook = new Task2();
        phoneBook.add("Иванов", "123-456-7890");
        phoneBook.add("Иванов", "234-567-8900");
        phoneBook.add("Петров", "345-678-9000");

        String text = scanner.nextLine();
        // Выводим список номеров телефона по фамилии
        List<String> phones = phoneBook.get(text);
        if (phones == null) {
            // Если фамилии нет в телефонном справочнике, то выводим другое значение
            System.out.println("Такого имени нет в телефонном справочнике");
        } else {
            System.out.printf("Номера телефона %s: %s", text, phones);
        }


    }
}
