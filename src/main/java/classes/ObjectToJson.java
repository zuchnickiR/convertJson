package classes;
/*
https://www.javatpoint.com/convert-java-object-to-json
https://www.tabnine.com/blog/how-to-convert-a-java-object-into-a-json-string/
https://devqa.io/convert-java-to-json/
Create an universal java mapper for json string   https://stackoverflow.com/questions/50163451/create-an-universal-java-mapper-for-json-string

 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

public class ObjectToJson {


    // Person person = new Person("Ala", 20);
//FRAZY PODCZAS WYSZUKIWANIA TO:

// a) Mapping Java Obiect to JSON obiect

// b) Convert Java Obiect to JSON

// https://www.youtube.com/watch?v=QezmbE_RXpE&ab_channel=Randomcode
/*
1. Dodaj dependencję do Mavena w pom.xml, by to zrobić wpisuje w mvnrepository: json simple

<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>

2. Po wklejeniu tej dependencji, w pom.xml będę miał "czerwone litery", które oznaczają że nie mam zassanej biblioteki:
json-simple, więc w Mavenie po prostu robię przeładowanie projektu: ReloudProject i zasysam biblioteki, które wskazałem w depencencji
poprzez wklejenie ich z mvn repository. Dzięki temu będę mógł tworzyć Obiekty Json i Arrays JSON


3. Tworzę teraz metodę, która stworzy mi Obiekt JSON:
metoda zwróci JSONObiect, który muszę zaimportować z paczki: org.json.simple

W ciele metody:
a) tworzę obiekt typu JSON:
b) dodaje do tego obiektu klucz i wartość
 */
    PathsClasses pathsClasses = new PathsClasses();

    //do tworzenia daty i czasu
    public ObjectToJson() {
    }

    public static String getCurrentDate() {
        LocalDate myObj = LocalDate.now();
        String dataString = myObj.toString();
        return dataString;
    }

    public static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_TIME;
        String timeOK = now.truncatedTo(ChronoUnit.SECONDS).format(dtf);
        return timeOK;
    }


    public void createJsonFromPerson(Person per) {

        String projectDirectory = pathsClasses.getProjectDirectory();

        JSONObject jsonObject = new JSONObject();

        //nazwa dla Zamówienia
        String nazwaZamowienia = "zamowienie " + getCurrentTime();

        //nazwa dla obiektu
        String typeName = jsonObject.getClass().getSimpleName();
        System.out.println("Type : " + typeName);

        System.out.println("--------------------------------\n" +
                "Do you want to save file?\n" +
                "Name: " + nazwaZamowienia +"\n" +
                "Type: " + typeName +"\n" +
                "--------------------------------\n" +
                "a) If yes enter 'y', then press enter\n" +
                "b) If no enter any keyboard key, then press enter");

        Scanner scanner = new Scanner(System.in);
        String resultYn = scanner.nextLine();

        if(resultYn.equals("Y") || resultYn.equals("y")) {

            jsonObject.put("name", per.getName());  //Uwaga: klucze  MUSZĄ mieć taka samą nazwę co pola w Klasie Person, inaczej powstanie błąd!
            jsonObject.put("age", per.getAge());    //Uwaga: klucze  MUSZĄ mieć taka samą nazwę co pola w Klasie Person, inaczej powstanie błąd!
            try {
                FileWriter fileWriter = new FileWriter(projectDirectory + nazwaZamowienia + ".json");
                fileWriter.write(jsonObject.toString());
                fileWriter.flush();
                fileWriter.close();

                System.out.println("File: '" + nazwaZamowienia + "' was successfully saved!\n" +
                        "in path: " + projectDirectory);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            System.out.println("Saving file aborted.");
        }
    }










//DOBRA METODA ALE NA JAWNEJ KLASIE
    public void createJsonFromObjectUsingObjectMapper(Person person) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(
                    new FileWriter(getCurrentDate() + " " + getCurrentTime() + " .json"), person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //https://stackoverflow.com/questions/15786129/converting-java-objects-to-json-with-jackson
    //DOBRA METODA I PRZESYŁAMY DO NIEJ JAKI OBIEKT CHCEMY
    public void createJsonFromObjectUsingObjectMapper111(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String valueAsString = objectMapper.writeValueAsString(object);
            objectMapper.writeValue(
                    new FileWriter(getCurrentDate() + " " + getCurrentTime() + " .json"), valueAsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject createJsonUsingGet(Person person) {
        JSONObject jsonPerson = new JSONObject();
        jsonPerson.put("name", person.getName());
        jsonPerson.put("age", person.getAge());
        return jsonPerson;
    }

    public JSONObject createJsonUingObiect(Person person) {
        JSONObject jsonPerson = new JSONObject();
        //tworzę tablicę
        JSONArray tabJsonArray = new JSONArray();
        tabJsonArray.add(person);
        return jsonPerson;
    }


}
