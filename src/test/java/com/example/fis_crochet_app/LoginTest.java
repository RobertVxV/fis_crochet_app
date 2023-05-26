package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.exceptions.UsernameAlreadyExistsException;
import com.example.fis_crochet_app.model.User;
import com.example.fis_crochet_app.services.DesignFileSystemService;
import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.services.FileSystemService;
import com.example.fis_crochet_app.services.UserService;
import org.h2.store.fs.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoginTest {
    private String username = "robert";
    private String email = "robert@gmail.com";
    private String password = "parola123";

    @BeforeAll
    public static void startUp(){
        File file = FileSystemService.getPathToFile("registration-example.db").toFile();
        file.delete(); //should have a remove user function... would be easier.
        FileSystemService.initDatabase();
        UserService.init();
    }
    @Test
    void addUserGood1() throws UsernameAlreadyExistsException {
       UserService.addUser("robert", "robert@gmail.com", "help123456");
    }
    @Test
    void addUserGood2() throws UsernameAlreadyExistsException {
        UserService.addUser("iulia", "iulia@gmail.com", "anaaremere");
    }
    @Test
    void addUserDuplicate() {
        assertThrows(UsernameAlreadyExistsException.class, () -> UserService.addUser("robert", "robert@gmail.com", "help123456"));
    }
    @Test
    void testGoodCredentials() throws BadCredentials {
        User user = UserService.login("robert", "help123456");
    }
    @Test
    void testBadCredentials() {
        assertThrows(BadCredentials.class, () -> UserService.login("robert", "picasso"));
    }
    @AfterAll
    public static void after(){
        File file = FileSystemService.getPathToFile("registration-example.db").toFile();
        file.delete();
    }
}
