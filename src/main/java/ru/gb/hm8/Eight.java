package ru.gb.hm8;

import ru.gb.hm8.empolee.Employee;
import ru.gb.hm8.empolee.Freelance;
import ru.gb.hm8.empolee.Worker;

import java.util.Random;

/**
 * Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
 * Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
 * Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать),
 * результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
 * Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
 * * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
 * Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */
public class Eight {
    static Random random = new Random();
    static Run generateCreatures(){
        String[] catNames = new String[] {"Жора", "Борис", "Бегемот"};
        String[] manNames = new String[] {"Аркадий", "Андрей", "Диман"};
        String[] robotNames = new String[] {"Т-1000", "R2D2", "Wall-e"};

        int typeInd = random.nextInt(3);
        int maxRunDistance = random.nextInt(1, 5);
        int maxJumpHeight = random.nextInt(50, 501);
        switch (typeInd){
            case 0:
                return new Cat(catNames[random.nextInt(3)],maxRunDistance , maxJumpHeight);
            case 1:
                return new Robot(robotNames[random.nextInt(3)],maxRunDistance , maxJumpHeight);
            case 2:
                return new Man(manNames[random.nextInt(3)],maxRunDistance , maxJumpHeight);
            default:
                break;
        }
        return null;
    }
    public static void main(String[] args) {
        Run[] creatures = new Run[3];
        for (int i = 0; i < creatures.length; i++) {
            creatures[i] = generateCreatures();
        }
        for (Run create: creatures) {
            System.out.println(create);
        }
    }
}
