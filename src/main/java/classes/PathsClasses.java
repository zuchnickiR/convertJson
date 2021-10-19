package classes;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class PathsClasses {

    private String desktop = "/Desktop/";


    public String getProjectDirectory() {
        // Zwróci: /home/rob/Desktop/taskRZ
        // wyciaga sciezke do folderu, w którym jest projekt
        String property = System.getProperty("user.dir");
        return property + "/";
    }

    public String getDesktopPath() {
        // zwróci: /home/rob/Desktop/
        FileSystemView filesys = FileSystemView.getFileSystemView();
        File homeDirectory = filesys.getHomeDirectory();
        String s = homeDirectory.toString();
        return s + desktop;
    }
}
