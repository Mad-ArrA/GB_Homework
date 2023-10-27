package ru.gb.hm6;

public abstract class Animal{
    private String name;
    private final String type;
    private final int maxRun;
    private final int maxSwim;
    static int counter;

    public Animal(String name, String type, int maxRun, int maxSwim) {
        this.name = name;
        this.type = type;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        counter++;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void run(int dist){
        if (type.equals("Собака")) {
            System.out.printf("%s %s пробежала %d м.\n", type, name, dist);
        }
        else if (dist <= maxRun) {
            System.out.printf("%s %s пробежал %d м.\n", type, name, dist);
        } else System.out.println("не бегает\n");
    }
    public void swim(int dist){
        if (type.equals("Собака")) {
            System.out.printf("%s %s проплыла %d м.\n", type, name, dist);
        }
        else if (dist <= maxSwim) {
            System.out.printf("%s %s проплыл %d м.\n", type, name, dist);
        } else System.out.printf("%s не умеет плавать\n", type);


    }

}
