package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.GetirPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class GetirStepDefinition {
    private static final Logger log = LoggerFactory.getLogger(GetirStepDefinition.class);
    GetirPage getirPage = new GetirPage();

    @Given("Navigate to {string} address.")
    public void navigateToTheGetirUrl(String getirUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(getirUrl));
        ReusableMethods.wait(2);
    }
    @And("If there is cookies accept them.")
    public void AcceptCookies() {
        try {
            getirPage.cookiesAcceptButton.click();
        } catch (Exception e) {
            System.out.println("Cookies Accept Button has not found.");
        }

    }
    @Then("Verify that the Getir homepage has opened.")
    public void verifyGetirPageHasOpened() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("getirUrl");
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @And("Quit the browser.")
    public void quitBrowser() {
        Driver.quitDriver();
    }

    @Given("Click on the Fit&Form category.")
    public void clickOnTheFitFormCategory() {

    }
    @And("Verify that the Fit&Form has opened.")
    public void verifyFitAndFormHasOpened() {

    }
    @Then("Verify that the basket is empty.")
    public void verifyTheBasketIsEmpty() {

    }
    @And("Click on the Granola category in the left category menu.")
    public void clickOnTheGranolaSubcategory() {

    }
    @Then("Verify that Granola section has opened.")
    public void verifyGranolaSubcategoryHasOpened() {

    }
    @And("Click on the most expensive product in the Granola subcategory.")
    public void clickOnTheMostExpensiveProductInTheGranolaSubcategory() {

    }
    @Then("Verify that the product price on the product details page matches the price displayed in the category.")
    public void verifyProductPricesIsEquals() {

    }
    @And("Quit the browser.")
    public void quitBrowserAgain() {
        Driver.quitDriver();
    }

}
