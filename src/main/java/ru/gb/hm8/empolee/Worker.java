package ru.gb.hm8.empolee;

import java.util.Random;

public class Worker extends Employee{


    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculatorSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Сред.мес. зп: %.2f (руб.);", name,surname, calculatorSalary());
    }
}
