package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.RegistrationPage;

import static stepDefinitions.Hooks.driver;

public class RegistrationStepDefinition {

    HomePage homePage;
    RegistrationPage registrationPage;

    @And("user clicked on register link")
    public void clickOnRegisterButton() {
        homePage = new HomePage(driver);
        homePage.registerClick();
    }

    @When("user selected gender")
    public void selectGender(){
        registrationPage = new RegistrationPage(driver);
        registrationPage.setGender("male");
    }

    @And("user entered first name")
    public void enterFirstName(){
        registrationPage.setFirstName("Ahmed");
    }
    @And("user entered last name")
    public void enterLastName(){
        registrationPage.setLastName("Raafat");
    }

    @And("user selected birth of date")
    public void enterBirthOfDate(){
        registrationPage.setDayOfBirth(1);
        registrationPage.setMonthOfBirth("January");
        registrationPage.setYearOfBirth(1990);
    }

    @And("user entered email for registration")
    public void enterEmail(){
        registrationPage.setEmail("Ahmed@service.com");
    }
    @And("user entered company name")
    public void enterCompanyName(){
        registrationPage.setCompanyName("Alex");
    }
    @And("user entered password for registration")
    public void enterPassword(){
        registrationPage.setPassword("P@ssWord");
    }
    @And("user confirmed password for registration")
    public void confirmPassword(){
        registrationPage.confirmPassword("P@ssWord");
    }

    @And("user clicked on register button")
    public void userClickedOnRegisterButton() {
        registrationPage.clickRegisterButton();
    }


    @Then("user should have a success message for registration")
    public void userShouldHaveASuccessMessageForRegistration() {
        WebElement registerTitle = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(registerTitle.getText(), "Register");

        String registerMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals(registerMessage, "Your registration completed");
    }
}
