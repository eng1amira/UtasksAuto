package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.BrowserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertiesFile {

    protected Properties properties = null;
    protected FileInputStream LoadFile = null;

    public  ReadPropertiesFile(String path) throws IOException {
        properties = new Properties();
        LoadFile = new FileInputStream(path);
        properties.load(LoadFile);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }


}
