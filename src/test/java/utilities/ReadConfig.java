package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties properties;
    public ReadConfig(){
        File src = new File("./configuration/config.properties");

        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL(){
        return properties.getProperty("baseURL");
    }

    public String getUsername(){
        return properties.getProperty("username");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }
}
