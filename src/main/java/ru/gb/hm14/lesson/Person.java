package ru.gb.hm14.lesson;

import java.util.*;

public class Person {

    private static int counter = 0;
    private static Map<Integer, Person> allPersons = new HashMap<>();

    private int id;
    private String name;
    private int age;
    private Gender gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Person(String name, int age, Gender gender) {
        if (allPersons == null){
            allPersons = new HashMap<>();
        }

        this.name = name;
        this.age = age;
        this.gender = gender;

        if (!hasPerson()){
            counter++;
            this.id = counter;
            allPersons.put(id, this);
        }

    }

    public static void clear(){
        if (allPersons != null)
            allPersons.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, gender);
    }

    private boolean hasPerson(){
        for (Person user : allPersons.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    // Формировать список всех пользователей
    public static List<Person> getAllUsers(){
        return new ArrayList<>(allPersons.values());
    }

    public static void exceptionSample(){
        throw new RuntimeException("MyExpection");
    }

    public static int getError(){
        throw new RuntimeException("Произошло исключение");
    }

    // Формировать список пользователей по полу(MALE/FEMALE)
    public static List<Person> getAllUsers(Gender gender){
        List<Person> listAllUsers = new ArrayList<>();
        for (Person person : allPersons.values()){
            if (person.getGender() == gender){
                listAllUsers.add(person);
            }
        }
        return listAllUsers;
    }

    // Общее кол-во пользователей
    public static int getHowManyUsers(){
        return allPersons.size();
    }

    // Кол-во пользователей по полу
    public static int getHowManyUsers(Gender gender){
        return getAllUsers(gender).size();
    }

    // Сумма лет всех пользователей
    public static int getAllAgeUsers(){
        int countAge = 0;
        for (Person user : allPersons.values()){
            countAge += user.getAge();
        }
        return countAge;
    }

    // Сумма лет всех пользователей по полу
    public static int getAllAgeUsers(Gender gender){
        int countAge = 0;
        for (Person person : getAllUsers(gender)){
            countAge += person.getAge();
        }
        return countAge;
    }

    // Посчитать средний возраст людей
    public static int getAverageAgeOfAllUsers(){
        return getAllAgeUsers() / getHowManyUsers();
    }

    // Посчитать средний возраст людей по полу
    public static int getAverageAgeOfAllUsers(Gender gender){
        return getAllAgeUsers(gender) / getHowManyUsers(gender);
    }

}