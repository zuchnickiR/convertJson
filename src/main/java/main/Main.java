package main;

import classes.JsonToObiect;
import classes.ObjectToJson;
import classes.Person;
import classes.TworzenieKatalogu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {



//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("t1.txt"));
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//            //zapis obiektu do pliku
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ObjectToJson objectToJson = new ObjectToJson();
        Person personAda = new Person("Ada", 28);

        objectToJson.createJsonFromPerson(personAda);
      //  objectToJson.createJsonFromObjectUsingObjectMapper(personAda);






//        JsonToObiect jsonToObiect = new JsonToObiect();
//
//
//        Person person = jsonToObiect.convertJSONFileToObiectUsingFile();
//        System.out.println("wydruk z metody: 'convertJSONFileToObiectUsingFile' " + person.getAge());
//
//        Person person1 = jsonToObiect.jSonToObiectUsingFileReader();
//        System.out.println("wydruk z metody: 'convertJSONFileToObiectUsingFile' " + person1.getAge());
//
//        Person person2 = jsonToObiect.jsonToObiectInputStream();
//        System.out.println("Wydruk z metody: 'jsonToObiectInputStream'" + person.getAge());
//



//        JsonToObiect jsonToObiect = new JsonToObiect();
//
//        Person person1 = jsonToObiect.readObjectFromJsonFile();
//        String name = person1.getName();

//        Person person2 = jsonToObiect.jsonToObiectInputStream();
//        String name1 = person2.getName();


    }
}
