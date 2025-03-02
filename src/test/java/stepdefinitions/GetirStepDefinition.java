package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.GetirPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.*;

public class GetirStepDefinition {

    GetirPage getirPage = new GetirPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    String selectedProductPriceInProductList;

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
        try {
            actions.click(getirPage.fitAndFormButton).perform();
            ReusableMethods.wait(5);
        } catch (Exception e) {
            getirPage.fitAndFormButton.click();
            ReusableMethods.wait(5);
        }
    }

    @And("Verify that the Fit&Form has opened.")
    public void verifyFitAndFormHasOpened() {
        String actualUrl = Driver.getDriver().getTitle();
        String expectedText = "Fit & Form";
        Assert.assertTrue(actualUrl.contains(expectedText));
    }

    @Then("Verify that the basket is empty.")
    public void verifyTheBasketIsEmpty() {
        String actualText = getirPage.emptyCartText.getText();
        String expectedText = "Your basket is empty";
        Assert.assertEquals(expectedText, actualText);
    }

    @And("Click on the Granola category in the left category menu.")
    public void clickOnTheGranolaSubcategory() {
        getirPage.granolaSubCategoryButton.click();
    }

    @Then("Verify that Granola section has opened.")
    public void verifyGranolaSubcategoryHasOpened() {
        String actualText = getirPage.granolaSubCategoryTitle.getText();;
        String expectedText = "Granola";
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @And("Click on the one of the most expensive product in the Granola subcategory.")
    public void clickOnTheMostExpensiveProductInTheGranolaSubcategory() {
        List<Double> priceList = new ArrayList<>();
        Map<Double, Integer> indexOfProductPrice = new HashMap<>();
        for (int i = 0; i < getirPage.granolaSubCategoryProductList.size(); i++) {
            String productInfo = getirPage.granolaSubCategoryProductList.get(i).getText();
            String productPrice = productInfo.substring(1,7).replaceAll("[^0-9,]", "").replace(",", ".").trim();
            Double productPriceDouble = Double.parseDouble(productPrice);
            priceList.add(productPriceDouble);
            indexOfProductPrice.put(productPriceDouble,i);
        }
        priceList.sort(Collections.reverseOrder());
        int indexOfOneOfTheExpensiveProducts= 0;
        try {
            indexOfOneOfTheExpensiveProducts = indexOfProductPrice.get(priceList.get((int)(Math.random() * 5)));
        } catch (Exception e) {
            indexOfOneOfTheExpensiveProducts = indexOfProductPrice.get(priceList.get(0));
        }
        String selectedProductInfo = getirPage.granolaSubCategoryProductList.get(indexOfOneOfTheExpensiveProducts).getText();
        selectedProductPriceInProductList = selectedProductInfo.substring(1,7).replaceAll("\\p{L}", "").trim();
        getirPage.granolaSubCategoryProductList.get(indexOfOneOfTheExpensiveProducts).click();
        ReusableMethods.wait(2);
    }

    @Then("Verify that the product price on the product details page matches the price displayed in the category.")
    public void verifyProductPricesIsEquals() {
        String productPriceInProductDetailPage = getirPage.ProductPriceInProductDetailPage.getText();
        Assert.assertEquals(selectedProductPriceInProductList,productPriceInProductDetailPage.substring(1));
    }
    @And("Quit the browser again.")
    public void quitBrowserAgain() {
        Driver.quitDriver();
    }
}
