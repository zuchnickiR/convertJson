package classes;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JsonToObiect {

    // Mapping JSON to Java Obiect
//jest to deserializacja danych z JSON do Java Obiect
    //Convert JSON Into Java Object
    //Read Object From JSON File   http://tutorials.jenkov.com/java-json/jackson-objectmapper.html#how-jackson-objectmapper-matches-json-fields-to-java-fields


    public Person convertJSONFileToObiectUsingFile() {

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("/home/rob/Desktop/taskRZ/zamowienie 16:58:25.json");

        try {
            // file to źródło, a Person.class to typ wartości
            Person person = objectMapper.readValue(file, Person.class);
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person jSonToObiectUsingFileReader() {

        ObjectMapper objectMapper = new ObjectMapper();
        try{
            FileReader fileReader = new FileReader("/home/rob/Desktop/taskRZ/zamowienie 16:58:25.json");
            Person person = objectMapper.readValue(fileReader, Person.class);
            return person;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }



        public Person jsonToObiectInputStream() {
        // coś nie działa !!!!!!!!!!!!!!!//
        // InputStream jsonFilePath = Person.class.getResourceAsStream("zamowienie 16:58:25.json");



            try {
                InputStream inputStream = new FileInputStream(new File("zamowienie 16:58:25.json"));
                Person person = new ObjectMapper().readValue(inputStream, Person.class);
                return person;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }



//muszę dodać dependencję do pom.xml ObjectMapper, robię to poprzez najechanie na czerwono wyświetlony ObjectMapper() poczekaniu
//na czerwona żarówkę i wybraniu: Add Maven Dependency 


}
