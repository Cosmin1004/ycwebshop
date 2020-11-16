package com.youngculture.utils;

import com.youngculture.model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FileWriterUtil {

    private static final SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static void writeProductToFile(Product product) throws IOException {
        FileWriter fileWriter = null;
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            File file = new File(
                    System.getProperty("user.home") + "//Desktop//cart.txt");

            if ( ! file.exists()) {
                file.createNewFile();
            }

            fileWriter = new FileWriter(file, true);
            fileWriter.write(simpleDateFormat.format(timestamp) + ": "
                    + "\tProduct \"" + product.getName()
                    + "\" was added to the cart.\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

}
