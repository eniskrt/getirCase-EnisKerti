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
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify that the Fit&Form has opened.")
    public void verify_that_the_fit_form_has_opened() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Verify that the basket is empty.")
    public void verify_that_the_basket_is_empty() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("Click on the Granola category in the left category menu.")
    public void click_on_the_granola_category_in_the_left_category_menu() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify that Granola section has opened.")
    public void verify_that_granola_section_has_opened() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Click on the most expensive product in the Granola subcategory.")
    public void click_on_the_most_expensive_product_in_the_granola_subcategory() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Verify that the product price on the product details page matches the price displayed in the category.")
    public void verify_that_the_product_price_on_the_product_details_page_matches_the_price_displayed_in_the_category() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
