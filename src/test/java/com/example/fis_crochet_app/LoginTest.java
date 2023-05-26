package com.example.fis_crochet_app;

import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.model.User;
import com.example.fis_crochet_app.services.DesignFileSystemService;
import com.example.fis_crochet_app.services.DesignService;
import com.example.fis_crochet_app.services.FileSystemService;
import com.example.fis_crochet_app.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class first_test {
    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
    private void initDesignDirectory() {
        Path designHomePath = DesignFileSystemService.DESIGN_HOME_PATH;
        if (!Files.exists(designHomePath))
            designHomePath.toFile().mkdirs();
    }
    @BeforeAll
    public void init(){
        initDirectory();
        initDesignDirectory();
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
