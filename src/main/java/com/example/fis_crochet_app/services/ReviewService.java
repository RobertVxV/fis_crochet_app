package com.example.fis_crochet_app.services;


import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.exceptions.UsernameAlreadyExistsException;
import com.example.fis_crochet_app.model.Review;
import com.example.fis_crochet_app.model.User;
import com.example.fis_crochet_app.model.Voucher;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReviewService {

    private static ObjectRepository<Review> reviewRepository;

    public static void init() {
        Nitrite db = FileSystemService.getDatabase();
//        System.out.println(Review.class);
        reviewRepository = db.getRepository(Review.class);

        db.commit();
    }

    public static void addReview(String user, String design, String review){
        reviewRepository.insert(new Review(user, design, review));
    }


    public static Review findReview(String user, String design) {
        for (Review r : reviewRepository.find()) {
            if (user.equals(r.getUser()) && design.equals(r.getDesign()))
                return r;
        }
        return null;
    }
    public static ArrayList<Review> findReview(String design) {
        ArrayList<Review> arr = new ArrayList<>();
        for (Review r : reviewRepository.find()) {
            if (design.equals(r.getDesign()))
                arr.add(r);
        }
        return arr;
    }
}
