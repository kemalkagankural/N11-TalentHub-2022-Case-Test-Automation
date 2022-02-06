package tasks;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CampaignDetails extends BasePage {
    List<String> promotionsNames;
    List<String> bpromotionsNames;
    By campaignNameLocator = new By.ByCssSelector("div.panelContent div.categoryMenuTab:nth-child(1) ul.campPromTab li .title");




    public CampaignDetails(WebDriver driver) {
        super(driver);
    }

       //Get the name of the campaign
        public void getCampaign() {
            promotionsNames = new ArrayList<>();
            bpromotionsNames = new ArrayList<>();
            Helper.waitFor(3);
        for (int i=1;i<getAllProducts().size();i++){
            getAllProducts().get(i).click();
            bpromotionsNames.add(getAllProducts().get(i).getText() + " - " + getLink(i+1).getAttribute("href")+"\n");
        for(int a=0;a< getMinorLinks(i+1).size();a++){
            promotionsNames.add(getAllProducts().get(i).getText() + " - " + getMinorLinks(i + 1).get(a).getAttribute("href")+"\n");
        }
        }
    }
    //Write the name of the campaign and the link to the file
    public void writeToCSV() throws IOException {
      Helper.writeToCsv(bpromotionsNames.toString()+promotionsNames.toString());
    }



    public List<WebElement> getAllProducts(){
        return findAll(campaignNameLocator);
    }
    public List<WebElement> getMinorLinks(int indis){
        By minorCampaignLinks = new By.ByXPath((String.format("//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div/section[%1$s]/ul/li/a",indis)));
        return findAll(minorCampaignLinks);
    }
    private WebElement getLink(int section) {
        By largeLinkcampaignLink = new By.ByXPath(String.format("//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div/section[%s]/a", section));
        return find(largeLinkcampaignLink);
    }

}

