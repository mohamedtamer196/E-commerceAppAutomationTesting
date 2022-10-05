package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;

import static stepDefinitions.Hooks.driver;

public class SelectDifferentCategories {
    HomePage homePage;

    @And("user hover on electronic category")
    public void userHoverOnElectronicCategory() {
        homePage = new HomePage(driver);
        homePage.hoverOnElectronicsCat();
    }

    @And("user click on cellPhone category")
    public void userClickOnCellPhoneCategory() {
        homePage.clickOnCellPhoneCat();
    }

    @Then("cell phones page should appear to the user")
    public void cellPhonesAppear() {
        String expectedUrl = "https://demo.nopcommerce.com/cell-phones";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
