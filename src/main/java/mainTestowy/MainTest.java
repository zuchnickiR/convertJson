package mainTestowy;

import classes.*;

public class MainTest {

    public static void main(String[] args) {

        Person person = new Person("Aleksander", 36);
        Car car = new Car(200,10000,3,"BMW");


//        JsonToObiect jsonToObiect = new JsonToObiect();
//        Person person1 = jsonToObiect.jSonToObiectUsingFileReader111(Person.class);
//
//        System.out.println(person1.getAge());

JsonToObiect jsonToObiect = new JsonToObiect();
        Person person1 = jsonToObiect.converteJsonFileToDomainObiect001(Person.class, "zamowienie 16:58:30");
        String name = person1.getName();
        System.out.println("imie: " + name);

    }





}
