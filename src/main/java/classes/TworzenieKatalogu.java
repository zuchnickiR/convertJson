package classes;

import java.io.File;
import java.util.Scanner;

public class TworzenieKatalogu {

    private String nazwaKatalogu;
    private PathsClasses pathsClasses = new PathsClasses();

    public void makeDirectory() {
        String projectDirectory = pathsClasses.getProjectDirectory();
        System.out.println("Kreator tworzenia katalogu\nPodaj nazwę dla katalogu, który chcesz utworzyć:");
        Scanner scanner = new Scanner(System.in);
        String nazwa = scanner.nextLine();

        File directory = new File(projectDirectory + nazwa);
        if(!directory.exists()) {
            directory.mkdir();
        } else {
            System.out.println("Katalog o nazwie: " + directory.getName() + "już instnieje w :\n" +
                    directory.getAbsolutePath());
        }
    }

    public void makeDirectoryWithLoop() {
        boolean loopCon = true;
        do {
            String projectDirectory = pathsClasses.getProjectDirectory();
            System.out.println("Kreator tworzenia katalogu\nPodaj nazwę dla katalogu, który chcesz utworzyć:");
            Scanner scanner = new Scanner(System.in);
            String nazwa = scanner.nextLine();
            File directory = new File(projectDirectory + nazwa);
            String wyciagnietaNazwaKatalogu = directory.getName().toString(); //wyciąga nazwę katalogu
            nazwaKatalogu = wyciagnietaNazwaKatalogu;
            if(!directory.exists()) {
                directory.mkdir();
                loopCon = false;
            } else {
                System.out.println("Katalog o nazwie: " + wyciagnietaNazwaKatalogu + "już instnieje w :\n" +
                        directory.getAbsolutePath()); //wyciąga ścieżkę do katalogu
                loopCon = true;
            }
        } while (loopCon);
        System.out.println("Utworzyłeś nowy katalog o nazwie: " + nazwaKatalogu);
    }
}
