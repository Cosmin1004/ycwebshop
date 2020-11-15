package com.youngculture.utils;

import com.youngculture.model.Product;

import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FileWriterUtil {

    private static final SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");

    public static void writeProductToFile(Product product) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            File file = new File(
                    System.getProperty("user.home") + "//Desktop//cart.txt");

            if ( ! file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            fw.write(simpleDateFormat.format(timestamp) + ": "
                    + "\tProduct \"" + product.getName()
                    + "\" was added to the cart.\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
