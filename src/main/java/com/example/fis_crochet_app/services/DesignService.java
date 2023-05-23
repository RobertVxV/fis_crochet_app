package com.example.fis_crochet_app.services;

import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.exceptions.DesignAlreadyExists;
import com.example.fis_crochet_app.exceptions.UsernameAlreadyExistsException;
import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class DesignService {


        private static ObjectRepository<Design> designRepository;
        private static Design current_design;

        public static void init() {
            Nitrite db = FileSystemService.getDatabase();
            System.out.println(User.class);
            designRepository = db.getRepository(Design.class);

            db.commit();
        }

        public static void addDesign(String Name, String Difficulty, double Price, String Description, boolean Public, boolean IsFree) throws DesignAlreadyExists {
            checkDesignDoesNotAlreadyExist(Name);
            if(IsFree)
                Price = 0;
            designRepository.insert(new Design(Name, Difficulty, Price, Description, Public, IsFree));
        }

        public static Design findDesign(String Name) {
            for (Design design : designRepository.find()) {
                if (Objects.equals(Name, design.getName()))
                    return design;
            }
            return null;
        }

        private static void checkDesignDoesNotAlreadyExist(String Name) throws DesignAlreadyExists {
            for (Design design : designRepository.find()) {
                if (Objects.equals(Name, design.getName()))
                    throw new DesignAlreadyExists(Name);
            }
        }



        public static Design editDesign(String name, String pass) {
            for (Design design : designRepository.find()) {
                if (Objects.equals(name, design.getName())) {
                        current_design = design;
                        return design;

                }
            }
            return null;
        }

        public static Design get_current_design() {
            return current_design;
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


        public static Integer getDesignsCount() {
            int n = 0;
            for (Design d : designRepository.find())
                n++;
            return n;
        }

    }


