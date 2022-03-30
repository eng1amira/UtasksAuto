package stepDefinitions;

import base.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.SignInPage;
import pages.SignUpPage;
import pages.UTaskHomePage;

public class UTaskStepDefinitions extends TestBase {

    SignUpPage signUpPage;
    SignInPage signInPage;
    UTaskHomePage homepage;

    @When("^user clicks on Sign up link$")
    public void user_clicks_on_sign_up_link() {
        signInPage = new SignInPage(driver);
        signInPage.signUp();

    }


    @Then("^user fills mandatory fields as (.+), (.+),(.+),and (.+)$")
    public void user_fills_mandatory_fields_as_and(String username, String email, String password, String passwordconfirmation) {
        signUpPage = new SignUpPage(driver);
        signUpPage.fillInSignUpInfo(username, email, password, passwordconfirmation);
    }

    @When("^user redirected to login$")
    public void user_redirected_to_login() {
        signInPage = new SignInPage(driver);
    }


    @Then("^User click on add new project with (.+) , add it, and selects it$")
    public void user_click_on_add_new_project_with_add_it_and_selects_it(String projectname) {

        homepage.addProject(projectname);
    }

    @Then("^user add new task with (.+) ,select (.+) from drop down menu ,and add Task$")
    public void user_add_new_task_with_select_from_drop_down_menu_and_add_task(String taskname, String duedate) {
        homepage.addTask(taskname, duedate);
    }

    @Then("^User selects an existing (.+)$")
    public void user_selects_an_existing(String projectname) {

        homepage.selectProject(projectname);

    }

    @When("^user redirected to home page$")
    public void user_redirected_to_home_page() {
        homepage = new UTaskHomePage(driver);
    }

    @Then("^fill in (.+) and (.+)$")
    public void fill_in_and(String email, String password) {
        signInPage.fillSignIn(email, password);
    }

    @Then("^(.+)message appeared$")
    public void errorMessageAppeared(String errorMessage) {
        Assert.assertEquals(signUpPage.GetErrorMessage(),errorMessage);
        System.out.println(signUpPage.GetErrorMessage());
        System.out.println("pass");
    }
}
