package mainTestowy;

import classes.JsonToObiect;
import classes.PathsClasses;
import classes.Person;
import classes.TworzenieKatalogu;

public class MainTest {

    public static void main(String[] args) {

        JsonToObiect jsonToObiect = new JsonToObiect();
        Person person = jsonToObiect.convertJSONFileToObiectUsingFile();

        int age = person.getAge();

        System.out.println(age);


        //  zamowienie 14:43:43.json

    }





}
