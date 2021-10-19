package mainTestowy;

import classes.*;

public class MainTest {

    public static void main(String[] args) {

        Person person = new Person("Aleksander", 36);
        Car car = new Car(200,10000,3,"BMW");

        ObjectToJson objectToJson = new ObjectToJson();

        objectToJson.createJsonFromObjectUsingObjectMapper111(car);

      //  objectToJson.createJsonFromPerson(person);
    }





}
