package ru.gb.hm8.empolee;

public abstract class Employee implements Comparable<Employee>{
    protected String name;
    protected String surname;
    protected double salary;


    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract double calculatorSalary();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculatorSalary(), o.calculatorSalary());
    }
}
