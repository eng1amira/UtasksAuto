package base;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.BrowserFactory;
import utils.ReadPropertiesFile;


public class TestBase {

    protected static WebDriver driver;
    public static ReadPropertiesFile configDataProperty;


    @BeforeClass
    public void openBrowser() throws IOException {

        configDataProperty = new ReadPropertiesFile("./src/test/resources/config/config.properties");
        String browserType = configDataProperty.getProperty("browser.type");
        String url = configDataProperty.getProperty("web.url");
        driver = BrowserFactory.getinstance().initializeBrowser(browserType);
        driver.get(url);
    }

    @AfterClass
    public void closeBrowser() {

        driver.close();
        driver.quit();

    }


}
