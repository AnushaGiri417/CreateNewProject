package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigsReader {
    public static Properties prop;

    public static void readProperties(String path){
        try {
            FileInputStream fis = new FileInputStream( path );
            prop= new Properties();
            prop.load( fis );
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getPropertyValue(String key){
     return prop.getProperty( key );



    }
}
