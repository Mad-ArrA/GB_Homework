package ru.gb.hm8.empolee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static Employee generateEmployee(){
        String[] names = new String[] {"Анатолий", "Аркадий", "Андрей", "Василий"};
        String[] surnames = new String[] {"Мадонов", "Хачманукьян", "Бутузов", "Алибабаевич"};

        int typeIndex = random.nextInt(2);
        int salary = random.nextInt(200, 501);
        int salaryIndex = random.nextInt(100, 160);
        switch (typeIndex){
            case 0:
                return new Freelance(names[random.nextInt(4)], surnames[random.nextInt(4)], salary);
            case 1:
                return new Worker(names[random.nextInt(4)], surnames[random.nextInt(4)], salary * salaryIndex);
            default:
                break;
        }
        return null;
    }
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }

        Arrays.sort(employees);

        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }
}
