package com.example.fis_crochet_app.services;

import org.dizitart.no2.Nitrite;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystemService {
    public static String APPLICATION_FOLDER = ".registration-example";
    public static String USER_FOLDER = System.getProperty("user.home");
    public static Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    private static Nitrite database;

    public static void initDatabase(){
        database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate();
        database.commit();

    }
    public static Nitrite getDatabase(){
        return database;
    }
    public static Path getPathToFile(String... path) {
        Path p = APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
        String s = p.toString();
        s = s.replace("./", "");
//        System.out.println(s);
        p = Paths.get(s);
//        System.out.println(p);
        return p;
    }

    public static Path getApplicationHomeFolder() {
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    private void initDirectory() {
        Path applicationHomePath = getApplicationHomeFolder();
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
}
