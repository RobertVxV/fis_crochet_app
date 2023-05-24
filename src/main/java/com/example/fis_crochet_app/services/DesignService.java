package com.example.fis_crochet_app.services;

import com.example.fis_crochet_app.exceptions.DesignAlreadyExists;
import com.example.fis_crochet_app.model.Design;
import com.example.fis_crochet_app.model.Stitch;
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
        private static Design current_design = null;

        public static void init() {
            Nitrite db = DesignFileSystemService.getDesignDatabase();
            System.out.println(Design.class);
            designRepository = db.getRepository(Design.class);

            db.commit();
        }

        public static void addDesign(String Name, String Difficulty, double Price, String Description, boolean Public, boolean IsFree) throws DesignAlreadyExists {
            checkDesignDoesNotAlreadyExist(Name);
            if(IsFree)
                Price = 0;
            Design newDesign = new Design(Name, Difficulty, Price, Description, Public, IsFree);
            designRepository.insert(newDesign);
            current_design = newDesign;

        }

        public static Design findDesign(String Name) {
            for (Design design : designRepository.find()) {
                if (Objects.equals(Name, design.getName()))
                    return design;
            }
            return null;
        }
    public static void addStitchToDesign(Stitch s) {
            current_design.addStitch(s);
        }
    public static String getDesignDifficulty() {
        return current_design.getDifficulty();
    }
    public static String getDesignDescription() {
        return current_design.getDescription();
    }
    public static Double getDesignPrice() {
        return current_design.getPrice();
    }
    public static String getDesignName() {
        return current_design.getName();
    }

    public static boolean getDesignFree() {
        return current_design.isFree();
    }

    public static boolean getDesignPublic() {
        return current_design.isPublic();
    }


        private static void checkDesignDoesNotAlreadyExist(String Name) throws DesignAlreadyExists {
            for (Design design : designRepository.find()) {
                if (Objects.equals(Name, design.getName()))
                    throw new DesignAlreadyExists(Name);
            }
        }



    public static void editDesign(String Name, String Difficulty, double Price, String Description, boolean Public, boolean IsFree) throws DesignAlreadyExists {
        Design existingDesign = findDesign(Name);
        if (existingDesign != null && !existingDesign.equals(current_design)) {
            throw new DesignAlreadyExists(Name);
        }
        if (IsFree) {
            Price = 0;
        }
        current_design.setName(Name);
        current_design.setDifficulty(Difficulty);
        current_design.setPrice(Price);
        current_design.setDescription(Description);
        current_design.setPublic(Public);
        current_design.setFree(IsFree);
        designRepository.update(current_design);
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


