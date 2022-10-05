package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class SearchStepDefinition {
    HomePage homePage;
    SearchPage searchPage;

    @And("user enter name of item to search for")
    public void userEnterNameOfItemToSearchFor() {
        homePage = new HomePage(driver);
        homePage.search("laptop");
    }

    @And("user clicked on search button")
    public void userClickedOnSearchButton() {
        homePage.clickOnSearchBtn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user should have products contains the searched word")
    public void userShouldHaveProductsContainsTheSearchedWord() {
        searchPage = new SearchPage(driver);
        List<WebElement> searchedItems = searchPage.getSearchedItems();
        Assert.assertEquals(searchedItems.get(0).getText(), "Asus N551JK-XO076H Laptop");
        Assert.assertEquals(searchedItems.get(1).getText(), "Lenovo Thinkpad X1 Carbon Laptop");
        Assert.assertTrue(driver.getCurrentUrl().contains("laptop"));
    }
}
