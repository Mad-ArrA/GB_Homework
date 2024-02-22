package ru.gb.hm14;

import org.junit.*;
import org.junit.rules.ExpectedException;
import ru.gb.hm14.lesson.Gender;
import ru.gb.hm14.lesson.Homework;
import ru.gb.hm14.lesson.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

    private Person person1;
    private Person person2;
    private Person person3;

    @Before
    public void setup(){
        Person.clear();

        person1 = new Person("Евгений", 35, Gender.Male);
        person2 = new Person("Марина", 34, Gender.Female);
        person3 = new Person("Галина", 22, Gender.Female);
    }

    @Test
    public void getAllUsersTest(){

        /*Person.clear();

        Person person1 = new Person("Евгений", 35, Gender.Male);
        Person person2 = new Person("Марина", 34, Gender.Female);
        Person person3 = new Person("Галина", 22, Gender.Female);*/

        List<Person> actual = Person.getAllUsers();

        List<Person> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person2);
        expected.add(person3);
        Assert.assertEquals(expected, actual);
    }

    @Ignore("Выключенный тест.")
    @Test
    public void getAllUsersV2Test(){

        /*Person.clear();

        Person person1 = new Person("Евгений", 35, Gender.Male);
        Person person2 = new Person("Марина", 34, Gender.Female);
        Person person3 = new Person("Галина", 22, Gender.Female);*/

        List<Person> actual = Person.getAllUsers();

        List<Person> expected = new ArrayList<>();
        expected.add(person1);
        expected.add(person3);
        Assert.assertEquals(expected, actual);
    }

    @Test
     public void getAllUsersByGenderNotNullTest(){
        //Person.clear();
        //Person person2 = new Person("Марина", 34, Gender.Female);

        Assert.assertNotNull(Person.getAllUsers(Gender.Female));
     }

     @Rule
     public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void whenExceptionThrown_getErrorTest(){
        // Мы ожидаем получить исключение следующего типа:
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Произошло исключение");
        Person.getError();
    }



}
