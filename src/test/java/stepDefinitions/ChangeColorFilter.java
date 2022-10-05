package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.ShoesPage;

import static stepDefinitions.Hooks.driver;

public class ChangeColorFilter {
    HomePage homePage;
    ShoesPage shoesPage;

    @And("user hover on apparel category")
    public void userHoverOnAppearlCategory() {
        homePage = new HomePage(driver);
        homePage.hoverOnapparelCat();
    }

    @And("user click on shoes category")
    public void userClickOnShoesCategory() {
        homePage.clickOnShoesCat();
    }

    @And("user change color to red")
    public void userChangeColorToRed() {
        shoesPage = new ShoesPage(driver);
        shoesPage.selectRedColor();
    }

    @Then("shoes with red color only should appear to the user")
    public void shoesWithRedColorOnlyShouldAppearToTheUser() {
        Assert.assertTrue(shoesPage.isRedColorSelected());
    }
}
