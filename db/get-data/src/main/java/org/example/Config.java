package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static final File file = new File("src/main/java/org/example/data.properties");

    public static String getUrl() {
        String url = "";

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            url = properties.getProperty("url");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return url;
    }

    public static String getUsername() {
        String username = "";

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            username = properties.getProperty("username");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return username;
    }

    public static String getPassword() {
        String password = "";

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(file));
            password = properties.getProperty("password");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return password;
    }
}