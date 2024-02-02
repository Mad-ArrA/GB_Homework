package ru.gb.hm11.lesson11;


public class Sample01 {

    public static void main(String[] args) {

        SimpleAccount simpleAccount1 = new SimpleAccount(new IdentifierA(), 6500);
        System.out.println(simpleAccount1);

        SimpleAccount simpleAccount2 = new SimpleAccount(new IdentifierB(), 7520);
        System.out.println(simpleAccount2);

        //IdentifierA id2 = (IdentifierA)simpleAccount2.getId();

        Account1<IdentifierA> account1 = new Account1<>(new IdentifierA(), 6500);
        IdentifierA id1 = account1.getId();

        Printer printer = new Printer();
        String[] people = {"Станислав", "Андрей", "Мария"};
        Integer[] numbers = {22, 3, 12, 1, 5, -9};

        printer.print(people);
        printer.print(numbers);

        DepositAccount<IdentifierA, String> depositAccount =
                new DepositAccount<>(new IdentifierA(), "1100000000123", 6500);
        System.out.println(depositAccount);

        Account1<Integer> account2 = new Account1<>(12321, 6500);



    }

}

class DepositAccount<T, N>{
    private T id;
    private N no;
    private double amount;

    public T getId() {
        return id;
    }

    public N getNo() {
        return no;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public DepositAccount(T id, N no, double amount) {
        this.id = id;
        this.no = no;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "id=" + id +
                ", no=" + no +
                ", amount=" + amount +
                '}';
    }
}

class Printer{


    public <T> void print(T[] items){
        for (T item : items){
            System.out.print(item + " ");
        }
        System.out.println();
    }

}

class CreditAccount<T> implements Accountable<T>{

    private T id;
    private double amount;

    @Override
    public T getId() {
        return id;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public CreditAccount(T id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}

class SpecialAccount1 implements Accountable<IdentifierA>{

    private IdentifierA id;
    private double amount;


    @Override
    public IdentifierA getId() {
        return id;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public SpecialAccount1(IdentifierA id, double amount) {
        this.id = id;
        this.amount = amount;
    }
}

interface Accountable<T>{
    T getId();

    double getAmount();
    void setAmount(double amount);
}

class Account1<T>{

    private T id;
    private double amount;

    public T getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Account1(T id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Сумма средств на счете #%s : %.2f руб.", id, amount);
    }

}

class IdentifierA{

    @Override
    public String toString() {
        return "IdentifierA";
    }
}

class IdentifierB{
    @Override
    public String toString() {
        return "IdentifierB";
    }
}

class SimpleAccount{
    private Object id;
    private double amount;

    public Object getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public SimpleAccount(Object id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Сумма средств на счете #%s : %.2f руб.", id, amount);
    }
}
