package com.example.fis_crochet_app.services;


import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.exceptions.UsernameAlreadyExistsException;
import com.example.fis_crochet_app.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserService {

    private static ObjectRepository<User> userRepository;
    private static User logged_in = null;

    public static void init() {
        Nitrite db = FileSystemService.getDatabase();
        System.out.println(User.class);
        userRepository = db.getRepository(User.class);

        db.commit();
    }

    public static void addUser(String username, String email, String password) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, email, encodePassword(username, password)));
    }

    public static User findUser(String email) {
        for (User user : userRepository.find()) {
            if (Objects.equals(email, user.getEmail()))
                return user;
        }
        return null;
    }

    private static void checkUserDoesNotAlreadyExist(String email) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(email, user.getEmail()))
                throw new UsernameAlreadyExistsException(email);
        }
    }

    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }


    public static User login(String username, String pass) throws BadCredentials {
        String encoded = encodePassword(username, pass);
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getEmail())) {
                if (Objects.equals(encoded, user.getPassword())) {
                    logged_in = user;
                    return user;
                } else {
                    throw new BadCredentials();
                }
            }
        }
        throw new BadCredentials();
    }

    public static User get_logged_in() {
        return logged_in;
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


    public static Integer getUsersCount() {
        int n = 0;
        for (User u : userRepository.find())
            n++;
        return n;
    }

}
