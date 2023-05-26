package com.example.fis_crochet_app.services;


import com.example.fis_crochet_app.exceptions.BadCredentials;
import com.example.fis_crochet_app.exceptions.UsernameAlreadyExistsException;
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

public class VoucherService {

    private static ObjectRepository<Voucher> voucherRepository;

    public static void init() {
        Nitrite db = FileSystemService.getDatabase();
        System.out.println(Voucher.class);
        voucherRepository = db.getRepository(Voucher.class);

        db.commit();
    }

    public static void addVoucher(String cod, int valoare){
        voucherRepository.insert(new Voucher(cod, valoare));
    }

    public static void deleteVoucher(String cod){
        Voucher v = findVoucher(cod);
        voucherRepository.remove(v);
    }


    public static Voucher findVoucher(String cod) {
        for (Voucher voucher : voucherRepository.find()) {
            if (cod.equals(voucher.getCod()))
                return voucher;
        }
        return null;
    }
}
