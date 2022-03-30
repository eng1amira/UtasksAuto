package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class SignInPage extends PageBase {

    public SignInPage(WebDriver driver) {
        super(driver);

    }

    By link_signUp = By.xpath("//a[text()=\"Sign Up\"]");
    By input_email = By.xpath("//div[@id=\"email\"]//input");
    By input_password = By.xpath("//div[@id=\"password\"]//input");
    By btn_submit = By.xpath("//button[@type=\"submit\"]");

    public void signUp() {
        clickElement(driver, link_signUp);
    }

    public void fillSignIn(String email, String password) {

        driver.findElement(input_email).sendKeys(email);
        driver.findElement(input_password).sendKeys(password);
        driver.findElement(btn_submit).click();


    }

}
