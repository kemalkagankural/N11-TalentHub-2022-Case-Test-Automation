package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {

    By acceptCookiesLocator = By.xpath("//body/div[@id='cookieUsagePopIn']/span[1]");
    By acceptNotificationLocator= By.id("myLocation-close-info");
    By closeNotificationLocator= By.xpath("//body/div[@id='dengage-push-perm-slide']/div[1]/div[2]/div[1]/button[1]");
    public HomePage(WebDriver driver) {
        super(driver);

    }
    public void closeMainNotification(){
        if (isDisplayed(closeNotificationLocator)){
            click(closeNotificationLocator);
        }
    }

    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            click(acceptCookiesLocator);
        }
    }
    public void closeNotification(){
        if (isDisplayed(acceptNotificationLocator)){
            click(acceptNotificationLocator);
        }
    }
}
