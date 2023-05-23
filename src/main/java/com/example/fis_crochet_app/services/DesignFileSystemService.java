package com.example.fis_crochet_app.services;

import org.dizitart.no2.Nitrite;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DesignFileSystemService {
    public static String APPLICATION_FOLDER = ".design";
    public static String DESIGN_FOLDER = System.getProperty("user.home");
    public static Path DESIGN_HOME_PATH = Paths.get(DESIGN_FOLDER, APPLICATION_FOLDER);

    private static Nitrite design_database;

    public static void initDesignDatabase(){
        design_database = Nitrite.builder()
                .filePath(getPathToFile("design-example.db").toFile())
                .openOrCreate();
        design_database.commit();

    }
    public static Nitrite getDesignDatabase(){
        return design_database;
    }
    public static Path getPathToFile(String... path) {
        Path p = DESIGN_HOME_PATH.resolve(Paths.get(".", path));
        String s = p.toString();
        s = s.replace("./", "");
//        System.out.println(s);
        p = Paths.get(s);
//        System.out.println(p);
        return p;
    }

    public static Path getApplicationHomeFolder() {
        return Paths.get(DESIGN_FOLDER, APPLICATION_FOLDER);
    }

    private void initDesignDirectory() {
        Path applicationHomePath = getApplicationHomeFolder();
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
}
