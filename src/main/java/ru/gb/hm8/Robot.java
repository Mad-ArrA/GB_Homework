package ru.gb.hm8;

public class Robot implements Run{

    private  String name;
    private String type;
    private  int maxRunDistance;
    private  int maxJumpHeight;

    public Robot(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.type = "Робот";
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            System.out.println(name + " успешно пробежал " + distance + " метров");
        } else {
            System.out.println(name + " не смог пробежать " + distance + " метров");
        }

    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(name + " успешно перепрыгнул " + height + " метров");
        } else {
            System.out.println(name + " не смог перепрыгнуть " + height + " метров");
        }
    }
    @Override
    public String toString() {
        return String.format("%s %s", getType(), getName() );
    }
}
