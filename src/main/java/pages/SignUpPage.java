package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class SignUpPage extends PageBase {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }


    By input_userName = By.xpath("//div[@id=\"userName\"]//input");
    By input_jobTitle = By.xpath("//div[@id=\"jobTitle\"]//input");
    By input_companyName = By.xpath("//div[@id=\"companyName\"]//input");
    By input_email = By.xpath("//div[@id=\"email\"]//input");
    By input_password = By.xpath("//div[@id=\"password\"]//input");
    By input_passwordConfirm = By.xpath("//div[@id=\"password-confirm\"]//input");
    By btn_submit = By.xpath("//button[@type=\"submit\"]");
    By errorMessage = By.xpath("//div[contains(text(),'Failed to create an account')]");


    public void fillInSignUpInfo(String userName, String email, String password, String passwordConfirmation) {

        setElement(driver, input_userName, userName);
        setElement(driver, input_email, email);
        setElement(driver, input_password, password);
        setElement(driver, input_passwordConfirm, passwordConfirmation);
        clickElement(driver, btn_submit);
        sleep(6000);

    }

    public String GetErrorMessage() {

        return driver.findElement(errorMessage).getText();

    }
}
