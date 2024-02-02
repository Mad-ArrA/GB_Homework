package ru.gb.hm8.empolee;

public class Freelance extends Employee{
    public Freelance(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculatorSalary() {
        return 20.8 * 8 * salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Сред.мес. зп: %.2f (руб.); Почасавая ставка: %.2f (руб.)", name,surname, calculatorSalary(), salary);
    }
}
