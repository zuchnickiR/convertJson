package classes;

import java.io.File;
import java.util.Scanner;

public class TworzenieKatalogu {

    public void makeDirectory() {
        System.out.println("Kreator tworzenia katalogu\nPodaj nazwę dla katalogu, który chcesz utworzyć:");
        Scanner scanner = new Scanner(System.in);
        String nazwa = scanner.nextLine();

        File directory = new File("/home/rob/Desktop/" + nazwa);
        if(!directory.exists()) {
            directory.mkdir();
        } else {
            System.out.println("Katalog o nazwie: " + directory.getName() + "już instnieje w :\n" +
                    directory.getAbsolutePath());
        }

    }
private String nazwaKatalogu;
    public void makeDirectoryWithLoop() {

        boolean loopCon = true;

        do {
            System.out.println("Kreator tworzenia katalogu\nPodaj nazwę dla katalogu, który chcesz utworzyć:");
            Scanner scanner = new Scanner(System.in);
            String nazwa = scanner.nextLine();
            File directory = new File("/home/rob/Desktop/" + nazwa);
            String wyciagnietaNazwaKatalogu = directory.getName().toString();
            nazwaKatalogu = wyciagnietaNazwaKatalogu;

            if(!directory.exists()) {
                directory.mkdir();
                loopCon = false;
            } else {
                System.out.println("Katalog o nazwie: " + directory.getName() + "już instnieje w :\n" +
                        directory.getAbsolutePath());
                loopCon = true;
            }

        } while (loopCon);

        System.out.println("Utworzyłeś nowy katalog o nazwie: " + nazwaKatalogu);
    }

}
