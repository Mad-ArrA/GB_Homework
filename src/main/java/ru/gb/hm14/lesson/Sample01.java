package ru.gb.hm14.lesson;

public class Sample01 {

    public static void main(String[] args) {
        new Person("Евгений", 35, Gender.Male);
        new Person("Марина", 34, Gender.Female);
        new Person("Галина", 22, Gender.Female);


        System.out.println("Все пользователи:");
        Person.getAllUsers().forEach(System.out::println);
        System.out.println("Все пользователи: MALE");
        Person.getAllUsers(Gender.Male).forEach(System.out::println);
        System.out.println("Все пользователи: FEMALE");
        Person.getAllUsers(Gender.Female).forEach(System.out::println);
        System.out.println("================================================");
        System.out.println("       всех пользователей: " + Person.getHowManyUsers());
        System.out.println("  всех пользователей MALE: " + Person.getHowManyUsers(Gender.Male));
        System.out.println("всех пользователей FEMALE: " + Person.getHowManyUsers(Gender.Female));
        System.out.println("================================================");
        System.out.println("       общий возраст всех пользователей: " + Person.getAllAgeUsers());
        System.out.println("  общий возраст всех пользователей MALE: " + Person.getAllAgeUsers(Gender.Male));
        System.out.println("общий возраст всех пользователей FEMALE: " + Person.getAllAgeUsers(Gender.Female));
        System.out.println("================================================");
        System.out.println("       средний возраст всех пользователей: " + Person.getAverageAgeOfAllUsers());
        System.out.println("  средний возраст всех пользователей MALE: " + Person.getAverageAgeOfAllUsers(Gender.Male));
        System.out.println("средний возраст всех пользователей FEMALE: " + Person.getAverageAgeOfAllUsers(Gender.Female));
        System.out.println("================================================");
    }

}
