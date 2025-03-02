package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class GetirPage {

    public GetirPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //CookiesAcceptButton
    @FindBy(xpath = "(//button[@data-testid='button'])[1]")
    public WebElement cookiesAcceptButton;

    //Fit&FormCategoryButton
    @FindBy(xpath = "(//div[@data-testid='link'])[16]//a")
    public WebElement fitAndFormButton;

    //EmptyCartText
    @FindBy(xpath = "((//span[@data-testid='text'])//span[@data-testid='text'])[18]")
    public WebElement emptyCartText;

    //GranolaSubCategoryButton
    @FindBy(xpath = "(//div[@data-testid='link'])[21]//a/span")
    public WebElement granolaSubCategoryButton;

    //GranolaSubCategoryTitle
    @FindBy(xpath = "(//h5[@data-testid='title'])[5]")
    public WebElement granolaSubCategoryTitle;

    //GranolaSubCategoryProductList
    @FindBy(xpath = "(//div[@data-testid='card'])[6]//article")
    public List<WebElement> granolaSubCategoryProductList;

    //ProductPriceInProductDetailPage
    @FindBy(xpath = "(//main[@role='main']//span[@data-testid='text'])[3]")
    public WebElement ProductPriceInProductDetailPage;
}
