package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;
import pages.PasswordRecoveryPage;

import static stepDefinitions.Hooks.driver;

public class PasswordRecoveryStepDefinition {
    LoginPage loginPage;
    PasswordRecoveryPage passwordRecoveryPage;

    @And("user clicked on forgot password")
    public void userClickedOnForgotPassword() {
        loginPage = new LoginPage(driver);
        loginPage.clickForgetPassword();
    }

    @And("user entered email for reset password")
    public void userEnteredEmailForResetPassword() {
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.enterEmail("Ahmed@service.com");
    }

    @And("user clicked on recover button")
    public void userClickedOnRecoverButton() {
        passwordRecoveryPage.clickOnRecoverBtn();
    }

    @Then("user should have a success message for recover")
    public void userShouldHaveASuccessMessageForRecover() {
        String resetMessage = driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]")).getText();
        Assert.assertEquals(resetMessage, "Email with instructions has been sent to you.");
    }
}
