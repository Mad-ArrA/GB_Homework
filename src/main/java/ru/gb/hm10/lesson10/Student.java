package ru.gb.hm10.lesson10;

public class Student {
    private String name;
    private String surname;
    private float rating;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getRating() {
        return rating;
    }

    public Student(String name, String surname, float rating) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
    }
}
