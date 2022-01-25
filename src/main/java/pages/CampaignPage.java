package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CampaignPage extends BasePage {

    By campaignPageLocator = By.cssSelector("div.categoryMenuTab:nth-child(1)");


    public CampaignPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCampaignPage() {
        return isDisplayed(campaignPageLocator);
    }




}
