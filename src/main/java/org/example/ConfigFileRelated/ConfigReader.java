package org.example.ConfigFileRelated;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    private static final String CONFIG_FOLDER_PATH = "./src/configFile";
    private static final String CONFIG_FILE_PATH = CONFIG_FOLDER_PATH + "/config.txt";
    // C:\Users\nilup\Desktop\cloned springboot\SpringBoot-with-static-html-pages-template\testSpringbootBackend\src\main\java\org\example\ConfigFileRelated
    public static Config readConfig() {
        File configFileFolder = new File(CONFIG_FOLDER_PATH);
        if (!configFileFolder.exists()) {
            configFileFolder.mkdir();
            createConfigFile();
        } else {
            File configFile = new File(CONFIG_FILE_PATH);
            if (!configFile.exists()) {
                createConfigFile();
            }
        }

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Config config = new Config();
        config.setAccessKey(removeQuotes(properties.getProperty("accessKey")));
        config.setSecretKey(removeQuotes(properties.getProperty("secretKey")));
        config.setDatabase(removeQuotes(properties.getProperty("database")));
        // config.setTableName(removeQuotes(properties.getProperty("tableName")));
        config.setOutputLocation(removeQuotes(properties.getProperty("outputLocation")));

        return config;
    }

    private static void createConfigFile() {
        Properties properties = new Properties();
        properties.setProperty("accessKey", "<accessKey>");
        properties.setProperty("secretKey", "<secretKey>");
        properties.setProperty("database", "<database>");
        // properties.setProperty("tableName", "<tableName>");
        properties.setProperty("outputLocation", "<outputLocation(s3 location)>");

        try (OutputStream output = new FileOutputStream(CONFIG_FILE_PATH)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String removeQuotes(String value) {
        return value.replace("\"", "");
    }
}

