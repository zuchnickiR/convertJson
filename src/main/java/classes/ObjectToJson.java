package classes;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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



//do tworzenia daty i czasu
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

    public ObjectToJson() {
    }


    public void createJsonFromPerson(Person per) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", per.getName()); //Uwaga: klucze  MUSZĄ mieć taka samą nazwę co pola w Klasie Person, inaczej powstanie błąd!
        jsonObject.put("age", per.getAge());
        try {//    /home/rob/Desktop/zamowienie -bedzie zapisywało json na pulpicie
            FileWriter fileWriter = new FileWriter("zamowienie " + getCurrentTime() + ".json");
            fileWriter.write(jsonObject.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createJsonFromObjectUsingObjectMapper(Person person) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(
                   new FileWriter(getCurrentDate() + " " + getCurrentTime() + " .json"), person);
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
