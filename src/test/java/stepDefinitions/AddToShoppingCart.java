package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BooksPage;
import pages.LoginPage;
import pages.ShoppingCart;

import java.util.List;
import static stepDefinitions.Hooks.driver;

public class AddToShoppingCart {
    LoginPage loginPage;
    BooksPage booksPage;
    ShoppingCart shoppingCart;

    @And("user navigate to books pages")
    public void userNavigateToBooksPages() {
        loginPage = new LoginPage(driver);
        loginPage.clickOnBooksCat();
    }

    @And("user add items to shopping cart")
    public void userAddItemsToShoppingCart() {
        booksPage = new BooksPage(driver);
        booksPage.addItemsToCart();
    }

    @And("user navigate to shopping cart")
    public void userNavigateToShopingCart() {
        booksPage.openShoppingCartPage();
    }

    @Then("added items should appear at shopping cart")
    public void addedItemsShouldAppearAtShoppingCart() {
        shoppingCart = new ShoppingCart(driver);
        List<WebElement> itemsName = shoppingCart.getItemsNamesInShoppingCart();
        Assert.assertEquals(itemsName.get(0).getText(),"Fahrenheit 451 by Ray Bradbury");
        Assert.assertEquals(itemsName.get(1).getText(),"First Prize Pies");
        Assert.assertEquals(itemsName.get(2).getText(),"Pride and Prejudice");

        List<WebElement> itemsQty = shoppingCart.getItemsQtyInShoppingCart();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx" + itemsQty.get(0).getAttribute("value"));
        int qty = 0;
        for (WebElement qtyElement : itemsQty){
            qty += Integer.parseInt(qtyElement.getAttribute("value"));

        }
        System.out.println("qty : "+qty);
        Assert.assertEquals(qty,3);

        Assert.assertEquals(shoppingCart.getShoppingCartTitle(), "Shopping cart");
    }

}
