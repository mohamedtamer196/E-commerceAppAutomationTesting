package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TagsPage {

    WebDriver driver;

    public TagsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
    }

    public String getTagsUrl(){
        return driver.getCurrentUrl();
    }

}
