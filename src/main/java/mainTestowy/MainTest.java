package mainTestowy;

import classes.*;

public class MainTest {

    public static void main(String[] args) {

        Person person = new Person("Aleksander", 36);
        ObjectToJson objectToJson = new ObjectToJson();

        objectToJson.createJsonFromObjectUsingObjectMapper111(person);

      //  objectToJson.createJsonFromPerson(person);
    }





}
