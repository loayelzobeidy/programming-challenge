package de.exxcellent.challenge.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private String appPath;
    private Properties pathConfig = new Properties();;
    private static Configuration instance;
    private Configuration(String appPath) throws IOException {

        this.appPath = appPath;
        populateWithConfig(this.appPath,pathConfig);


    }
    public static void init(String appPath)  throws IOException {
        if(instance==null)
        instance = new Configuration(appPath);

    }
    public String getappConfigProp(String key) {
        return pathConfig.getProperty(key);
    }

    private static void populateWithConfig(String configFilePath, Properties properties) throws IOException {
        FileInputStream inputStream = new FileInputStream(configFilePath);
        System.out.println(inputStream+" "+properties);
        properties.load(inputStream);
        inputStream.close();
    }
    public static Configuration getInstance() {
        return instance;
    }

}
