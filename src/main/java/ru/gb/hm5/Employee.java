package ru.gb.hm5;

public class Employee {

    private String FIO;
    private String Post;
    private String Email;
    private String Phone;
    private double Salary;
    private int Age;
    private final int id;
    private static int count;


    public Employee(String FIO, String Post, String Email, String Phone, double Salary, int Age){
        setFIO(FIO);
        setPost(Post);
        setEmail(Email);
        setPhone(Phone);
        setSalary(Salary);
        setAge(Age);
    }

    {
        FIO = "Undefined";
        Post = "Undefined";
        Email = "Undefined";
        Phone = "Undefined";
        Salary = 0d;
        Age = 0;
        id = ++count;
    }
    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    void displayInfo(){
        System.out.printf("ID: %d\t ФИО: %s\t, Должность: %s\t, Email: %s\t, Телефон: %s\t, Зарплата: %.2f\t, Возраст: %d\t \n", id ,FIO, Post, Email, Phone, Salary, Age);
    }

}
