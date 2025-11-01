package framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Genrics {

    private static Properties properties;

    // Loads config file (prod/stage/test)
    public static void loadProperties(String env) {
        properties = new Properties();
        try {
            String path = System.getProperty("user.dir") +
                    "/src/main/resources/config." + env + ".properties";
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config file for environment: " + env);
        }
    }

    // Returns value for any key from the file
    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties("prod"); // default environment
        }
        return properties.getProperty(key);
    }
    public static String getValue(String key,String env){
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main/resources/config."+env+".properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
