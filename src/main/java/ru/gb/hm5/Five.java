package ru.gb.hm5;

/**
 * Создать класс ""Сотрудник"" с полями: ФИО, должность, email, телефон, зарплата, возраст.
 * Конструктор класса должен заполнять эти поля при создании объекта.
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
 * Создать массив из 5 сотрудников. Пример: Person[] persArray = new Person[5]; // Вначале объявляем массив объектов persArray[0] = new Person(""Ivanov Ivan"", ""Engineer"", ""ivivan@mailbox.com"", ""892312312"", 30000, 30); // потом для каждой ячейки массива задаем объект persArray[1] = new Person(...); ... persArray[4] = new Person(...);
 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
public class Five {

    public static void main(String[] args) {

        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Джотаро Джо Сергеевич", "Боец", "joe@mail.ru", "89325845532", 100000, 32);
        employee[1] = new Employee("Зубенко Михаил Петрович", "Мафиози", "opasniy@gmail.com", "+79175647777", 500000, 45);
        employee[2] = new Employee("Бенедиктов Иван Фёдорович", "Менеджер", "reshala@yandex.ru", "89546732853", 150000, 59);
        employee[3] = new Employee("Ханма Баки Игоревич", "Вышибала", "dubolom192@gmail.com", "89574328543", 70000, 28);
        employee[4] = new Employee("Змеев Илья Альбертович", "Наёмник", "zmeyBoy1@mail.ru", "+79348436432", 95000, 41);
        Person(employee);
    }

    static void Person(Employee[] employee){
        for (int i = 0; i < employee.length; i++){
            if (employee[i].getAge() > 40){
                employee[i].displayInfo();
            }
        }
    }
}
