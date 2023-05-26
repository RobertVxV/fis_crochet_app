package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.services.DesignFileSystemService;
import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.services.FileSystemService;
import com.example.fis_crochet_app.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LoginTest {
    @BeforeAll
    public static void startUp(){
        FileSystemService.initDatabase();
        DesignFileSystemService.initDesignDatabase();
        UserService.init();
        DesignService.init();
    }
    @Test
    public void testBadCredentials() {
        assertThrows(BadCredentials.class, () -> UserService.login("mama", "picasso"));
    }
}
