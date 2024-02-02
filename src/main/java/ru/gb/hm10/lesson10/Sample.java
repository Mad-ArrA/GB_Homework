package ru.gb.hm10.lesson10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/***
 * Рейтинг учеников
 */
public class Sample {
    public static void main(String[] args) {

        String[] students = {
                "Григорьев Анатолий 4 5 2",
                "Фокин Глеб 1 5 2",
                "Шестаков Клим 4 3 2",
                "Хохлов Мартин 2 5 2",
                "Шубин Лазарь 4 5 2",
                "Гущина Арьяна 4 3 3",
                "Брагина Виоланта 2 5 2",
                "Афанасьева Екатерина 1 1 2",
                "Рыбаков Снежана 4 2 2",
                "Лазарева Алла 4 3 2",
                "Бирюков Владлен 4 5 2",
                "Копылов Панкратий 4 4 4",
                "Горбунов Рубен 4 5 3",
                "Лыткин Герман 1 5 2",
                "Соколов Орест 1 1 5"
        };

        processStatistics(students);
    }

    public static void processStatistics(String[] students){
        HashMap<Float, ArrayList<Student>> statistic = new HashMap<>();

        for (String s: students) {
            String[] parts = s.split(" "); // разделение строк, разделитель проблем
            int a = Integer.parseInt(parts[2]); // выбор по индексам
            int b = Integer.parseInt(parts[3]);
            int c = Integer.parseInt(parts[4]);
            float r =  (float) (a + b + c) / 3; // подсчитываем средний балл

            if (statistic.containsKey(r)){ //если в коллекции существует ключ со значением r
                ArrayList<Student> lst = statistic.get(r);// получаем элемент коллекции по ключу
                lst.add((new Student(parts[1],parts[0], r)));
            }
            else {
                ArrayList<Student> lst = new ArrayList<>();
                lst.add((new Student(parts[1],parts[0], r))); //добавления в коллекцию имя, фамилия и средний балл
                statistic.put(r, lst); // чтобы добавить в HashMap
            }

        }

        TreeMap<Float, ArrayList<Student>> sortedStatistic = new TreeMap<>(statistic); // сортируем элементы по ключу
        int counter = 1;
        System.out.println("ТОП3 худших средних баллов студентов");
        for (Map.Entry<Float, ArrayList<Student>> item : sortedStatistic.entrySet())
        {
            System.out.printf("\n%d место - средний балл %.2f ", counter, item.getKey());
            for (Student student : item.getValue()){
                System.out.printf("%s %s\n", student.getSurname(), student.getName());
            }
            counter++;
            if (counter > 3){
                break;
            }
        }
    }
}
