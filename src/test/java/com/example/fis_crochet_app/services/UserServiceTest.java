package com.example.fis_crochet_app.services;

import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.exceptions.UsernameAlreadyExistsException;
import com.example.fis_crochet_app.model.User;
import org.dizitart.no2.Nitrite;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {
    private static User tempUser;
    public static void clearDatabase()
    {
        for(User u : UserService.getUserRepository().find())
        {
            UserService.removeUser(u);
        }
    }
    @BeforeAll
    public static void startup(){
        FileSystemService.initDatabase();
        UserService.init();
        clearDatabase();
    }
    @Test
    void testGoodRegister1() throws UsernameAlreadyExistsException {
        UserService.addUser("robert", "robert@gmail.com", "parola123");
    }
    @Test
    void testGoodRegister2() throws UsernameAlreadyExistsException {
        UserService.addUser("iulia", "iulia@gmail.com", "parola123");
    }
    @Test
    void testDuplicateRegister() {
        assertThrows(UsernameAlreadyExistsException.class, () -> UserService.addUser("robert", "robert@gmail.com", "parola123"));
    }
    @Test
    void testGoodLogin() throws BadCredentials {
        UserService.login("robert", "parola123");
        UserService.logout();
    }
    @Test
    void testUserGetLoggedIn() throws BadCredentials {
        UserService.login("robert", "parola123");
        assertEquals("robert", UserService.get_logged_in().getUsername());
        assertEquals("robert@gmail.com", UserService.get_logged_in().getEmail());
    }
    @Test
    void testBadCredentials() {
        assertThrows(BadCredentials.class, () -> UserService.login("robert", "picasso"));
    }
    @AfterAll
    public static void after(){
        clearDatabase();
    }
}
