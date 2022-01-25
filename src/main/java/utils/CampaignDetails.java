package utils;

import com.opencsv.CSVWriter;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CampaignDetails extends BasePage {
    List<String> promotionsNames;
    List<String> bpromotionsNames;
    List<String> allpromotionsNames;
    By campaignNameLocator = new By.ByCssSelector("div.panelContent div.categoryMenuTab:nth-child(1) ul.campPromTab li:not(.disabled) .title");
    By promotionLocator = new By.ByXPath("//*[@id=\"contentCampaignPromotion\"]/div/div[2]/div/div[2]/div/section");



    public CampaignDetails(WebDriver driver) {
        super(driver);
    }


        public void getCampaign() {
            promotionsNames = new ArrayList<>();
            bpromotionsNames = new ArrayList<>();
            Helper.waitFor(3);
        for (int i=1;i<getAllProducts().size();i++){
            getAllProducts().get(i).click();
            bpromotionsNames.add(getAllProducts().get(i).getText() + " - " + getLink(i+1).getAttribute("href")+"\n");
        for(int a=1;a< getMinorLinks(i+1).size();a++){
            promotionsNames.add(getAllProducts().get(i).getText() + " - " + getMinorLinks(i + 1).get(a).getAttribute("href")+"\n");
        }
        }
    }

    public void writeToCSV() throws IOException {
        String csv = "target/test-classes/output.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        writer.writeNext(new String[]{bpromotionsNames.toString()+"\n"+promotionsNames.toString()});
        writer.close();
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

