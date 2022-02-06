package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By acceptCookiesLocator = By.xpath("//body/div[@id='cookieUsagePopIn']/span[1]");
    public HomePage(WebDriver driver) {
        super(driver);

    }


    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }

}
