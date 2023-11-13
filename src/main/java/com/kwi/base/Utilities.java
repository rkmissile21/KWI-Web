package com.kwi.base;

import java.io.*;
import java.util.Properties;

/**
 * Utilities class provides common utility methods for reading properties and text files.
 */
public class Utilities {

    /**
     * Gets the value of a property from the config.properties file.
     *
     * @param key The key for the property.
     * @return The value of the property.
     */
    public static String getPropertyFromConfig(String key) {
        Properties properties = new Properties();
        String filePath = "src/test/resources/config.properties";
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String value = properties.getProperty(key);
        return value;
    }

    /**
     * Reads the content of a text file.
     *
     * @param filePath The path of the text file.
     * @return The content of the text file.
     */
    public static String readTextFile(String filePath) {
        String container;
        String finalText = "";
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((container = bufferedReader.readLine()) != null) {
                finalText = finalText + '\n' + container;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalText;
    }
}
