package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import static stepDefinitions.Hooks.driver;

public class LoginStepDefinition {
    HomePage homePage;
    LoginPage loginPage;

    @And("user clicked on login link")
    public void userClickedOnLoginLink() {
        homePage = new HomePage(driver);
        homePage.loginClick();
    }

    @And("user entered email for login")
    public void userEnteredEmailForLogin() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("Ahmed@service.com");
    }

    @And("user entered password for login")
    public void userEnteredPasswordForLogin() {
        loginPage.enterPassword("P@ssWord");
    }

    @And("user clicked on login button")
    public void userClickedOnLoginButton() {
        loginPage.clickLogIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("user should have a success message for login")
    public void userShouldHaveASuccessMessageForLogin() {

        Assert.assertTrue(driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class=\"ico-account\"]")).getText(), "My account");
    }
}
