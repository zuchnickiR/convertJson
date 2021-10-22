package classes;



import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

public class JsonToObiect {

    PathsClasses pathsClasses = new PathsClasses();

    // Mapping JSON to Java Obiect
    //jest to deserializacja danych z JSON do Java Obiect
    //Convert JSON Into Java Object
    //Read Object From JSON File   http://tutorials.jenkov.com/java-json/jackson-objectmapper.html#how-jackson-objectmapper-matches-json-fields-to-java-fields


    //METODA 1 DOBRA  - UŻYWAMY TU ObjectMapper CZYLI Jackson API
    public Person convertJSONFileToObiectUsingFile() {
        System.out.println("Prosze wpisz nazwę pliku o rozszeżeniu JSON, który chcesz skonwertować do postaci Obiektu Java");
        Scanner scanner = new Scanner(System.in);
        String nazwa = scanner.nextLine();
        String projectDirectory = pathsClasses.getProjectDirectory();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(projectDirectory +nazwa);
        try {
            // file to źródło, a Person.class to typ wartości
            Person person = objectMapper.readValue(file, Person.class);
            return person;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    //METODA 2 DOBRA
    public Person jSonToObiectUsingFileReader() {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            FileReader fileReader = new FileReader("/home/rob/Desktop/taskRZ/zamowienie 16:58:30.json");
            Person person = objectMapper.readValue(fileReader, Person.class);
            return person;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

//DOBRA DZIAŁAJĄCA METODA!!!
    public <I> I jSonToObiectUsingFileReader111(Class<I> cls) {

//        System.out.println("Prosze wpisz nazwę pliku o rozszeżeniu JSON, który chcesz skonwertować do postaci Obiektu Java");
//        Scanner scanner = new Scanner(System.in);
//        String nazwa = scanner.nextLine();

        I result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            FileReader fileReader = new FileReader("/home/rob/Desktop/taskRZ/zamowienie 16:58:30.json");

       //     Person person = objectMapper.readValue(fileReader, Person.class);
              result = objectMapper.readValue(fileReader, cls);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    //**
    //NA POTRZEBY TESTOWANIA, METODA, PRZYJMUJE NAZWĘ SZUKANEGO PLIKU DO SWOJEJ SYGNATURY
    public <I> I converteJsonFileToDomainObiect001(Class<I> cls, String nazwa) {
        System.out.println("Prosze wpisz nazwę pliku o rozszeżeniu JSON, który chcesz skonwertować do postaci Obiektu Java");
        String projectDirectory = pathsClasses.getProjectDirectory();
//        Scanner scanner = new Scanner(System.in);
//        String nazwa = scanner.nextLine();
        I result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(projectDirectory + nazwa + ".json");
        try {
            result = objectMapper.readValue(file,cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    //***

///home/rob/Desktop/taskRZ/zamowienie 14:43:43.json

//muszę dodać dependencję do pom.xml ObjectMapper, robię to poprzez najechanie na czerwono wyświetlony ObjectMapper() poczekaniu
//na czerwona żarówkę i wybraniu: Add Maven Dependency 


}
