package ru.gb.hm11.lesson11.sample02;

public class Sample02 {

    public static void main(String[] args) {

        Person person1 = new Person("Александр", "10000211");
        Entity entity1 = new Entity("GeekBrains", "32312132");

        DebetAccount<Person> debetAccount = new DebetAccount<>(person1, 150000);
        SpecialAccount<Entity> specialAccount = new SpecialAccount<>(entity1, 5000000);

        Transaction<Account> transaction = new Transaction<>(debetAccount, specialAccount, 100000);
        transaction.execute();


        transaction.execute();
    }

}


class Transaction<T extends Account>{
    private T from;
    private T to;
    private double amount;

    public Transaction(T from, T to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void execute(){
        if (from.getAmount() >= amount){
            System.out.printf("Осуществлен перевод средств между счетами на сумму %f руб.\n", amount);
            System.out.printf("Счет списания #%s: %f руб.\nСчет зачисления #%s: %f руб.\n",
                    from.getData(), from.getAmount(), to.getData(), to.getAmount());
            from.setAmount(from.getAmount() - amount);
            to.setAmount(to.getAmount() + amount);
            System.out.println("Текущее состояние счетов:");

            System.out.println(from);
            System.out.println(to);
            System.out.println();
        }
        else {
            System.out.println("Операция невозможна, недостаточно средств на счете.\n");
        }
    }

}

/**
 * Стратегия 1
 */
/*class CreditAccount extends Account<Person>{

    public CreditAccount(Person data, double amount) {
        super(data, amount);
    }
}*/

/**
 * Стратегия 2
 * @param <T>
 */
class DebetAccount<T extends PersonalData> extends Account<T>{

    public DebetAccount(T data, double amount) {
        super(data, amount);
    }
}

class SpecialAccount<T extends PersonalData> extends Account<T>{

    public SpecialAccount(T data, double amount) {
        super(data, amount);
    }
}

abstract class Account<T extends PersonalData>{

    private T data;
    private double amount;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account(T data, double amount) {
        this.data = data;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "data=" + data +
                ", amount=" + amount +
                '}';
    }

}

interface PersonalData{
    String getINN();
}

/**
 * Физическое лицо
 */
class Person implements PersonalData{

    private String fio;
    private String inn;

    public Person(String fio, String inn) {
        this.fio = fio;
        this.inn = inn;
    }

    @Override
    public String getINN() {
        return inn;
    }

    @Override
    public String toString() {
        return String.format("%s; %s;", inn, fio);
    }
}

/**
 * Юридическое лицо
 */
class Entity implements PersonalData{

    private String name;
    private String inn;

    public Entity(String name, String inn) {
        this.name = name;
        this.inn = inn;
    }

    @Override
    public String getINN() {
        return inn;
    }

    @Override
    public String toString() {
        return String.format("%s; %s;", inn, name);
    }
}
