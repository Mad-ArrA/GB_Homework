package ru.gb.hm8.empolee;

import java.util.Comparator;

public  class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.calculatorSalary(), o2.calculatorSalary());
    }
}
