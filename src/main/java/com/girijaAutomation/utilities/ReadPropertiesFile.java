package com.girijaAutomation.utilities;

import com.girijaAutomation.Enum.ConfigProperties;
import com.girijaAutomation.Exceptions.PropertyFileUsageException;
import org.girijaAutomation.frameworkConstants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ReadPropertiesFile {
    private static Properties p= new Properties();
    private static final Map<String,String> CONFIGMAP= new HashMap<>();

    private ReadPropertiesFile(){

    }
    static{
        try(FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath())){
            p.load(fis);
            for(Object key:p.keySet()){
                CONFIGMAP.put(String.valueOf(key),String.valueOf(p.get(key)).trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
           // throw new InvalidPathForPropertyFileException("Please check the path of config file");
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static String get(ConfigProperties key){
        if(Objects.isNull(key)|| Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            throw new PropertyFileUsageException(" property name " + key + "is not found. pls check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

    public static String getValue(String key){
        String value="";
        value= p.getProperty(key);
        if(Objects.isNull(value)|| Objects.isNull(key))
        {
            throw new PropertyFileUsageException(" property name " + key + "is not found. pls check config.properties");
        }
        return value;
    }
}
