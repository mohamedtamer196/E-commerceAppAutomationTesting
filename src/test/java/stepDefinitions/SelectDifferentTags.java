package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;
import pages.TagsPage;
import static stepDefinitions.Hooks.driver;

public class SelectDifferentTags {
    HomePage homePage;
    TagsPage tagsPage;
SearchPage searchPage;

    @And("user open search page")
    public void userOpenSearchPage() {
        homePage = new HomePage(driver);
        homePage.openSearchPage();
    }

    @And("user choose awesome tag")
    public void userChooseAwesomeTag() {
        searchPage = new SearchPage(driver);
        searchPage.selectAwesomeTag();

    }

    @Then("awesome products page should appear to the user")
    public void awesomeProductAppear() {
        tagsPage = new TagsPage(driver);
        String awesomeUrl = "https://demo.nopcommerce.com/awesome";
        Assert.assertEquals(tagsPage.getTagsUrl(), awesomeUrl);
    }
}
