package testrunner;

import helper.Helper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import tasks.CampaignDetails;
import pages.CampaignPage;
import pages.HomePage;
import java.io.IOException;



public class Test_Campaign_List extends BaseTest {
    HomePage homePage;
    CampaignPage campaignPage;
    CampaignDetails campaignDetails;




    @Test
    @Order(1)
    public void open_campaign_page() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        campaignPage = new CampaignPage(driver);
        Assertions.assertTrue(campaignPage.isCampaignPage() ,
               "Not on products page!");
        Helper.waitFor(1);
    }

    @Test
    @Order(2)
    public void get_promotions(){
        campaignDetails = new CampaignDetails(driver);
        campaignDetails.getCampaign();
        Helper.waitFor(1);
    }
    @Test
    @Order(3)
    public void write_to_CSV() throws IOException {
        campaignDetails.writeToCSV();
    }
}
