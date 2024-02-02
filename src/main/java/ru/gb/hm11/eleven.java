package ru.gb.hm11;


import java.util.ArrayList;

/**
 * 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * 3. Задача: a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 * b. Класс Box, в который можно складывать фрукты.
 * Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c.Для хранения фруктов внутри коробки можно использовать ArrayList;
 * d. Сделать метод getWeight(),который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * e.Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
 * true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
 * f.Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
 * нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
 * а в другую перекидываются объекты, которые были в первой;
 * g. Не забываем про метод добавления фрукта в коробку.
 */
public class eleven {
    public static void main(String[] args) {

        System.out.println("Задание 3. Задача с фруктами.");
        //Так как все яблоки и апельсины одинаковые, не вижу смысла создавать много объектов.
        Fruit apple = new Apple();
        Orange orange = new Orange();
        System.out.println("\nСОЗДАНИЕ------------------->");
        System.out.println(" >>Создадим коробку:");
        Box<Fruit> box1 = new Box<>();
        box1.info();
        System.out.println(" >>Вес новой коробки: " + box1.getWeight());
        System.out.println("\nДОБАВЛЕНИЕ------------------->\n >>Добавим в коробку яблок: ");
        box1.addFruit(apple,4);
        box1.info();
        System.out.printf(" >>Вес коробки с типом фруктов %s: %.1f", box1.getFruitType(), box1.getWeight());
        System.out.println("\n >>Добавим ещё яблок:");
        box1.addFruit(apple,2);
        box1.info();
        System.out.println(" >>Вес коробки: " + box1.getWeight());
        System.out.println(" >>А теперь попробуем добавить апельсины:");
        box1.addFruit(orange,5);
        System.out.println("\nСРАВНЕНИЕ------------------->");
        System.out.println(" >>Возьмём две коробки: 1 - с яблоками, 2 - с апельсинами и сравним их: ");
        box1.info();
        System.out.println(" >>Вес коробки с яблоками: " + box1.getWeight());
        Box<Fruit> box2 = new Box<>();
        box2.addFruit(orange, 4);
        box2.info();
        System.out.println(" >>Вес коробки с апельсинами: " + box2.getWeight());
        System.out.println(" >>Результат сравнения: " + box2.compare(box1));
        System.out.println("\nПЕРЕМЕЩЕНИЕ------------------->");
        System.out.println(" >>Перекладываем фрукты из box1 в box3 хранящими яблоки: ");
        Box<Fruit> box3 = new Box<>();
        box3.addFruit(apple, 4);
        box1.info();
        box3.info();
        box1.pour("to", box3);
        System.out.println(">Теперь box1:");
        box1.info();
        System.out.println(">А box3:");
        box3.info();
        System.out.println(" >>И обратно из box3 в box1:");
        box1.pour("from", box3);
        System.out.println(">Теперь box1:");
        box1.info();
        System.out.println(">А box3:");
        box3.info();
        System.out.println(" >>Попробуем переместить фрукты из коробки box2 в box1");
        box2.pour("to", box1);
        System.out.println("\n\nПОЧЕМУ В \"BOX\" СРАЗУ НЕ ОБЪЯВЛЯЕТСЯ ТИП------------------->");
        System.out.println(" >>Так как коробка box3 после всех манипуляций опустела, можно её заполнить");
        box3.info();
        System.out.println(" >>Добавим в неё 5 апельсинов:");
        box3.addFruit(orange,5);
        box3.info();

    }

}
abstract class Fruit {
    private String fruitName;
    private double fruitWeight;

    public String getFruitName() {
        return fruitName;
    }

    public double getFruitWeight() {
        return fruitWeight;
    }

    public Fruit(String fruitName, double fruitWeight) {
        this.fruitName = fruitName;
        this.fruitWeight = fruitWeight;
    }
}

class Apple extends Fruit {

    public Apple() {
        super("Яблоко", 1.0f);
    }

    @Override
    public String toString() {
        return super.getFruitName();
    }
}

class Orange extends Fruit {

    public Orange() {
        super("Апельсин", 1.5f);
    }
    @Override
    public String toString() {
        return super.getFruitName();
    }
}

/**
 * Так как коробки сортируются по типу фрукта внутри, то при объявлении нового объекта коробки - указанный тип и будет
 * типом этой коробки.
 *
 * @param <T> Универсальная переменная, ограниченная абстрактным классом Fruit(т.е. добавлять мы сможем только его наследников)
 */
class Box<T extends Fruit> {
    private String fruitType; //Тип фрукта(идентифицируется только после добавления в коробку фруктов какого либо типа)
    private ArrayList<T> fruitBox = new ArrayList<>(); //Сама коробка в виде ArrayList
    public ArrayList<T> getFruitBox() {
        return fruitBox;
    }

    /**
     * @return возвращает тип фрукта, хранящегося в коробке
     */
    public String getFruitType() {
        return fruitType;
    }

    /**
     * Сделал метод добавления таким, т.к. очень не нравилось, что если в конструкторе коробки указать тип, то она будет
     * содержать только этот тип, даже если коробка пустая. Поэтому идентифицировать тип мы будем только в случае, если
     * в коробке что-то лежит. Иначе она будет пустая и можно будет положить туда любой из фруктов.
     *
     * @param fruit  объект фрукта, который мы кладём в коробку
     * @param number все фрукты одного типа одинаковые, то почему бы сразу не указать, сколько фруктов одного типа
     *               мы хотим добавить в коробку
     */
    public void addFruit(T fruit, int number) {
        boolean condition = true;
        if (!fruitBox.isEmpty())
            if (!(fruit.equals(fruitBox.get(0))))
                condition = false;
        if (condition) {
            fruitType = fruit.getFruitName();
            for (int i = 0; i < number; i++) {
                fruitBox.add(fruit);
            }
        } else {
            System.out.printf("Добавить тип \"%s\" не удалось. Это коробка для фруктов типа \"%s\"", fruit.getFruitName(), fruitType);
            System.out.println();
        }
    }

    /**
     * Выводит информацию о коробке.
     */
    public void info() {
        if (fruitBox.isEmpty()) System.out.println("Это пустая коробка, в ней ничего нет.");
        else {
            System.out.printf("Это коробка с типом \"%s\", в ней лежит %d фруктов", fruitType, fruitBox.size());
            System.out.println();
        }
    }

    /**
     * Метод, возвращающий вес коробки на текущий момент
     *
     * @return вес коробки
     */
    public double getWeight() {
        return fruitBox.isEmpty() ? 0 : fruitBox.size() * fruitBox.get(0).getFruitWeight();
    }

    /**
     * Сравнение двух коробок
     *
     * @param anotherBox передаваемая коробка, в сравнение с текущей
     * @return true - если равны, false - если не равны
     */
    public boolean compare(Box<T> anotherBox) {
        return this.getWeight() == anotherBox.getWeight();
    }

    /**
     * Метод, чтобы пересыпать все фрукты похожего типа из одной коробки в другую
     * @param toOrFrom "to" - пересыпать из текущей в другую
     *                 "from" - пересыпать из другой в текущую
     * @param anotherBox другая коробка
     */
    public void pour(String toOrFrom, Box<T> anotherBox) {
        if (fruitType.equals(anotherBox.getFruitType())) {
            switch (toOrFrom) {
                case "to":
                    anotherBox.getFruitBox().addAll(fruitBox);
                    fruitBox.clear();
                    break;
                case "from":
                    fruitBox.addAll(anotherBox.getFruitBox());
                    anotherBox.getFruitBox().clear();
                    break;
                default:
                    System.out.println("Ошибка ввода пути передачи. Укажите в качестве первого аргумента \"to\" или \"from\"");
            }
        } else System.out.printf("Пересыпать не удалось.\nКоробка, в которую вы хотите пересыпать фрукты имеет тип" +
                " фруктов \"%s\",\nа ваша коробка содержит тип \"%s\"", fruitType, anotherBox.getFruitType());
    }
}
